package mentapp.controller;

import mentapp.models.Patient;
import mentapp.models.User;
import mentapp.repository.PatientRepository;
import mentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PatientController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("/patient")
    public String toPatient(@RequestParam(name="username", required=true) String username, Model model) {
        User user = userRepository.findByUsername(username);
        System.out.println(user.getUsername());
            return "welcomepagepatient";


        /*if () {
            Patient patient = result.get();
            model.addAttribute("infoPatient", patient);
            return "welcomepagepatient";
        }
        else
            return "notfound";*/
    }
}
