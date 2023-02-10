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

import java.util.*;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

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
    public String patientapplist(@RequestParam(name = "id", required = true) Long id, Model model) {
        Optional<Patient> result_pat = patientRepository.findById(id);
        if (result_pat.isPresent()) {
            Patient pat = result_pat.get();
            model.addAttribute("patient", pat);

            Optional<Doctor> result_doc = doctorRepository.findById(pat.getDoc());
            if (result_doc.isPresent()) {
                Doctor doc = result_doc.get();
                model.addAttribute("doctor", doc);

                // lista degli appuntamenti
                List<Appointment> patientAppointments = appointmentRepository.findByIdPatient(pat.getID());
                model.addAttribute("appointments", patientAppointments);

                System.out.println(appointmentRepository.findByIdPatient(pat.getID()));

                return "patientapplist";
            }

        }
        return "notfound";
    }
}


