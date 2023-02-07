package mentapp.controller;

import mentapp.models.Appointment;
import mentapp.models.Patient;
import mentapp.repository.AppointmentRepository;
import mentapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    private AppointmentRepository appointmentRepository;

    @RequestMapping("/patient")
    public String setPatient(@RequestParam(name = "id", required = true) Long id,
                             Model model) {
        Optional<Patient> result_patient = patientRepository.findById(id);
        if (result_patient.isPresent()) {
            Patient patient = result_patient.get();
            model.addAttribute("patient", patient);
            return "welcomepagepatient";
        } else {
            return "notfound";
        }
    }

    @RequestMapping("/profilepatient")
    public String profilepatient(
            @RequestParam(name = "id", required = true) Long id,
            Model model) {
        Optional<Patient> result_patient = patientRepository.findById(id);
        if (result_patient.isPresent()) {
            Patient patient = result_patient.get();
            model.addAttribute("profilepatient", patient);
            return "profilepatient";
        } else {
            return "notfound";
        }
    }

    @RequestMapping("/patientapplist")
    public String patientapplist(@RequestParam(name="id", required=true) Long id, Model model) {
        Optional<Patient> result_pat = patientRepository.findById(id);
        if(result_pat.isPresent()) {
            Patient pat = result_pat.get();
            System.out.println(pat.getID());

            // lista degli appuntamenti
            List<Appointment> patientAppointments = appointmentRepository.findByIdPatient(pat.getID());
            model.addAttribute("appointments", patientAppointments);

            return "patientapplist";
        } else {
            return "notfound";
        }
    }
}

