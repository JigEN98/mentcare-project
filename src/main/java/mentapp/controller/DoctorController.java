package mentapp.controller;

import mentapp.models.Doctor;
import mentapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @RequestMapping("/doctor")
    public String doctorpage(@RequestParam(name="id", required=true) Long id,
                              Model model) {
        Optional<Doctor> result = doctorRepository.findById(id);

        if (result.isPresent()) {
            Doctor doc = result.get();
            model.addAttribute("doctor", doc);
            return "welcomepagedoc";
        }
        return "ciao";
    }


}