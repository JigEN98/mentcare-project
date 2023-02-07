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
    public String inPatient() {
        return "insertpatient";
    }
    @RequestMapping("/insert_patient")
    public String insertPatient(Model model) {
        // TODO request mapping dell'inserimento dei valori a di insertpatient.html
        return "notfound";
    }

    @RequestMapping("/modify_patient")
    public String modifyPatient(@RequestParam(name="id", required=true) Long id, Model model) {
        System.out.println(id);
        return "modifypatient";
    }
    // TODO la modifica da inserire nel db

    @RequestMapping("/delete_patient")
    public String deletePatient(@RequestParam(name="id", required=true) Long id, Model model) {
        System.out.println(id);
        return "notfound";
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
