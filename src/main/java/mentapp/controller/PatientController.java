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
    public String setPatient(@RequestParam(name="id", required=true) Integer id,
                              Model model) {
        Patient result = patientRepository.findByCode(id);

        if(result == null) {
            return "notfound";
        } else {
            model.addAttribute("patient", result);
            return "welcomepagepatient";
        }
    }

    @RequestMapping("/profilepatient")
    public String profilepatient(
            @RequestParam(name="id", required=true) Integer id,
            Model model) {
        System.out.println("PROFILO");
        Patient result = patientRepository.findByCode(id);
        if(result == null) {
            return "notfound";
        } else {
            model.addAttribute("profilepatient", result.getID());
            System.out.println(result.getID());
            return "redirect:/profilepatient?id="+id;
        }
    }
}


