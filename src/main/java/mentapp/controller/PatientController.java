package mentapp.controller;

import mentapp.models.Patient;
import mentapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("/patient")
    public String setPatient(@RequestParam(name="id", required=true) Long id,
                              Model model) {
        Optional<Patient> result_patient = patientRepository.findById(id);
        if(result_patient.isPresent()) {
            Patient patient = result_patient.get();
            model.addAttribute("patient", patient);
            return "welcomepagepatient";
        } else {
            return "notfound";
        }
    }

    @RequestMapping("/profilepatient")
    public String profilepatient(
            @RequestParam(name="id", required=true) Long id,
            Model model) {
        Optional<Patient> result_patient = patientRepository.findById(id);
        if(result_patient.isPresent()) {
            Patient patient = result_patient.get();
            model.addAttribute("profilepatient", patient);
            return "profilepatient";
        } else {
            return "notfound";
        }
    }
}


