package mentapp.controller;

import mentapp.models.Appointment;
import mentapp.models.Doctor;
import mentapp.models.Patient;
import mentapp.repository.AppointmentRepository;
import mentapp.repository.DoctorRepository;
import mentapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @RequestMapping("/doctor")
    public String setDoctor(@RequestParam(name="id", required=true) Long id, Model model) {
        Optional<Doctor> result_doc = doctorRepository.findById(id);
        if(result_doc.isPresent()) {
            Doctor doc = result_doc.get();
            model.addAttribute("doctor", doc);
            // lista dei pazienti
            List<Patient> doctorPatients = patientRepository.findByDoc(doc.getID());
            model.addAttribute("patients", doctorPatients);

            // lista degli appuntamenti
            List<Appointment> doctorAppointments = appointmentRepository.findByIdDoctor(doc.getID());
            model.addAttribute("appointments", doctorAppointments);

            return "welcomepagedoc";
        } else {
            return "notfound";
        }
    }
    @RequestMapping("/insertp")
    public String inPatient(Long id, Model model) {
        Optional<Doctor> result_doc = doctorRepository.findById(id);
        if(result_doc.isPresent()) {
            Long doc = result_doc.get().getID();
            model.addAttribute("doctor", doc);
            return "insertpatient";
        }
        return "redirect:/inputerror?id="+id+"&&message=Generic";
    }
   @RequestMapping("/insert_patient")
    public String insertPatient(@RequestParam(name="name", required=true) String firstname,
                                @RequestParam(name="surname", required=true) String lastname,
                                @RequestParam(name="date", required=true) String date_s,
                                @RequestParam(name="id", required=true) Long id, Model model) {

        //check dati
        if(  firstname.isEmpty()  || lastname.isEmpty() || date_s.isEmpty() ) {
           return "redirect:/inputerror?id="+id+"&&message=Empty";
        }

        Optional<Doctor> result_doc = doctorRepository.findById(id);
        if(result_doc.isPresent()) {
            Long doc = result_doc.get().getID();
            model.addAttribute("doctor", doc);
            String[] temp = date_s.split("-");
            Integer year = Integer.parseInt(temp[0]);
            Integer month =Integer.parseInt(temp[1]);
            Integer day =Integer.parseInt(temp[2]);

            LocalDate date = LocalDate.of(year,month,day);

            //check date
            if(  date.isAfter(LocalDate.now())  || date.isBefore(LocalDate.of(1920,1,1))) {
                return "redirect:/inputerror?id="+id+"&&message=Date";
            }
            patientRepository.save(new Patient(firstname, lastname, date, id));
            return "redirect:/doctor?id=" + doc;
        }
        else{
            return "redirect:/inputerror?id="+id+"&&message=Generic";
        }
    }

    @RequestMapping("/modify_patient")
    public String modifyPatient(@RequestParam(name="id_doc", required=true) Long id_doc,
                                @RequestParam(name="id", required=true) Long id, Model model) {
        Optional<Patient> result = patientRepository.findById(id);
        if (result.isPresent()) {
            Patient pat = result.get();
            model.addAttribute("patient", pat);
            return "modifypatient";
        } else {
            return "redirect:/inputerror?id="+id_doc+"&&message=Generic";
        }
    }
    // TODO la modifica da inserire nel db

    @RequestMapping("/update_patient")
    public String updatePatient(@RequestParam(name="id_doc", required=true) Long id_doc,
                                @RequestParam(name="name", required=true) String firstname,
                                @RequestParam(name="surname", required=true) String lastname,
                                @RequestParam(name="date", required=true) String date_s,
                                @RequestParam(name="id", required=true) Long id, Model model) {

        //check dati
        if(  firstname.isEmpty()  || lastname.isEmpty() || date_s.isEmpty() ) {
            return "redirect:/inputerror?id="+id_doc+"&&message=Empty";
        }

        Optional<Patient> result = patientRepository.findById(id);
        if (result.isPresent()) {
            Patient pat = result.get();
            model.addAttribute("patient", pat);
            Long id_pat = pat.getID();
            patientRepository.delete(result.get());
            String[] temp = date_s.split("-");
            Integer year = Integer.parseInt(temp[0]);
            Integer month =Integer.parseInt(temp[1]);
            String day_temp = temp[2].substring(0,2);
            Integer day =Integer.parseInt(day_temp);
            LocalDate date = LocalDate.of(year,month,day);

            //check date
            if(  date.isAfter(LocalDate.now())  || date.isBefore(LocalDate.of(1920,1,1))) {
                return "redirect:/inputerror?id="+id_doc+"&&message=Date";
            }

            patientRepository.save(new Patient(firstname, lastname, date, pat.getDoc()));
            return "redirect:/doctor?id=" + pat.getDoc();
        } else{
            return "redirect:/inputerror?id="+id_doc+"&&message=Generic";
        }
    }

    @RequestMapping("/delete_patient")
    public String deletePatient(@RequestParam(name="id", required=true) Long id, Model model) {
        Optional<Patient> result = patientRepository.findById(id);
        if (result.isPresent()){
            patientRepository.delete(result.get());
            return "redirect:/doctor?id="+result.get().getDoc();
        }
        else{
            return "redirect:/inputerror?id="+id+"&&message=Generic";
        }
    }
    // TODO eliminazione da inserire nel db

    @RequestMapping("/insertapp")
    public String inAppointment(Long id, Model model) {
        Optional<Doctor> result_doc = doctorRepository.findById(id);
        if(result_doc.isPresent()) {
            Long doc = result_doc.get().getID();
            model.addAttribute("doctor", doc);
            List<Patient> pat = patientRepository.findByDoc(doc);
            model.addAttribute("patients", pat);

            return "insertappointment";
        }
        return "notfound";
    }

    @RequestMapping("/insert_appointment")
    public String insertAppointment(@RequestParam(name="date", required=true) String date_s,
                                    @RequestParam(name="time", required=true) String time,
                                    @RequestParam(name="description", required=true) String description,
                                    @RequestParam(name="id_pat", required=true) Long id_pat,
                                    @RequestParam(name="id", required=true) Long id, Model model) {
        Optional<Doctor> result_doc = doctorRepository.findById(id);
        if(result_doc.isPresent()) {
            Long doc = result_doc.get().getID();
            model.addAttribute("doctor", doc);
            String[] temp = date_s.split("-");
            Integer year = Integer.parseInt(temp[0]);
            Integer month =Integer.parseInt(temp[1]);
            Integer day =Integer.parseInt(temp[2]);
            System.out.println("pat" +id_pat + "doc" + doc);
            LocalDate date = LocalDate.of(year,month,day);
            appointmentRepository.save(new Appointment(date, time, description, id_pat, doc));
            return "redirect:/doctor?id=" + doc;
        }
        else{
            return "notfound";
        }
    }

    @RequestMapping("/modify_appointment")
    public String modifyAppointment(@RequestParam(name="id", required=true) Long id, Model model) {
        Optional<Appointment> result = appointmentRepository.findById(id);
        if (result.isPresent()) {
            Appointment app = result.get();
            model.addAttribute("appointment", app);
            return "modifyappointment";
        } else {
            return "notfound";
        }
    }
    // TODO la modifica da inserire nel db

    @RequestMapping("/update_appointment")
    public String updateAppointment(@RequestParam(name="date", required=true) String date_s,
                                @RequestParam(name="time", required=true) String time,
                                @RequestParam(name="description", required=true) String description,
                                @RequestParam(name="id", required=true) Long id, Model model) {
        Optional<Appointment> result = appointmentRepository.findById(id);
        if (result.isPresent()) {
            Appointment app = result.get();
            model.addAttribute("appointment", app);
            Long id_app = app.getID();
            appointmentRepository.delete(result.get());
            String[] temp = date_s.split("-");
            Integer year = Integer.parseInt(temp[0]);
            Integer month =Integer.parseInt(temp[1]);
            String day_temp = temp[2].substring(0,2);
            Integer day =Integer.parseInt(day_temp);
            LocalDate date = LocalDate.of(year,month,day);
            appointmentRepository.save(new Appointment(date, time, description, app.getIdPatient(), app.getIdDoctor()));
            return "redirect:/doctor?id=" + app.getIdDoctor();
        } else {
            return "notfound";
        }
    }

    @RequestMapping("/delete_appointment")
    public String deleteAppointment(@RequestParam(name="id", required=true) Long id, Model model) {
        Optional<Appointment> result = appointmentRepository.findById(id);
        if (result.isPresent()){
            appointmentRepository.delete(result.get());
            return "redirect:/doctor?id="+result.get().getIdDoctor();
        }
        else
            return  "notfound";
    }

    @RequestMapping("/inputerror")
    public String inputerror(
            @RequestParam(name="id", required=true) Long id,
            @RequestParam(name="message", required=true) String message,
            Model model) {

        model.addAttribute("doctor", id);
        model.addAttribute("message", message);

        return "inputerror";
    }
}
