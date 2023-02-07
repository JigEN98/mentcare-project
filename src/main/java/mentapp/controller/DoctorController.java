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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
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
        return "notfound";
    }
   @RequestMapping("/insert_patient")
    public String insertPatient(@RequestParam(name="name", required=true) String firstname,
                                @RequestParam(name="surname", required=true) String lastname,
                                @RequestParam(name="date", required=true) String date_s,
                                @RequestParam(name="id", required=true) Long id, Model model) {
        Optional<Doctor> result_doc = doctorRepository.findById(id);
        if(result_doc.isPresent()) {
            System.out.println(result_doc.get().getID());
            Long doc = result_doc.get().getID();
            model.addAttribute("doctor", doc);
            String[] temp = date_s.split("-");
            Integer year = Integer.parseInt(temp[0]);
            Integer month =Integer.parseInt(temp[1]);
            Integer day =Integer.parseInt(temp[2]);

            Date date = new Date(year-1900,month-1,day-0);
            patientRepository.save(new Patient(firstname, lastname, date, id));
            return "redirect:/doctor?id=" + doc;
        }
        else{
                return "notfound";
        }
    }

    @RequestMapping("/modify_patient")
    public String modifyPatient(@RequestParam(name="id", required=true) Long id, Model model) {
        System.out.println(id);
        return "modifypatient";
    }
    // TODO la modifica da inserire nel db

    @RequestMapping("/delete_patient")
    public String deletePatient(@RequestParam(name="id", required=true) Long id, Model model) {
        Optional<Patient> result = patientRepository.findById(id);
        if (result.isPresent()){
            patientRepository.delete(result.get());
            System.out.println(result.get().getDoc());
            return "redirect:/doctor?id="+result.get().getDoc();
        }
        else
            return  "notfound";
    }
    // TODO eliminazione da inserire nel db

    @RequestMapping("/insert_appointment")
    public String insertAppointment(Model model) {
        // TODO request mapping dell'inserimento dei valori a di insertappointment.html
        return "notfound";
    }

    @RequestMapping("/modify_appointment")
    public String modifyAppointment(@RequestParam(name="id", required=true) Long id, Model model) {
        System.out.println(id);
        return "notfound";
    }

    @RequestMapping("/delete_appointment")
    public String deleteAppointment(@RequestParam(name="id", required=true) Long id, Model model) {
        System.out.println(id);
        return "notfound";
    }
}
