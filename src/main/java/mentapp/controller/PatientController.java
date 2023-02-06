package mentapp.controller;

import mentapp.models.Patient;
import mentapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("/patient")
    public String patientlist(@RequestParam(name="id", required=true) Long id,
                              Model model) {
        Optional<Patient> result = patientRepository.findById(id);

        if (result.isPresent()) {
            Patient pat = result.get();
            model.addAttribute("patient", pat);
            return "welcomepagepatient";
        }
        return "ciao";
    }


}
