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
    public String setDoctor(@RequestParam(name="id", required=true) Integer id, Model model) {
        return "notfound";
        /*Doctor result_doc = doctorRepository.findByID(id);

        if(result_doc.isPresent()) {
            Doctor doc = result_doc.get();
            model.addAttribute("doctor", doc);
            // TODO aggiungere lista pazienti del dottore (quindi metodo che prende tutti i pazienti = doc.getSurname)
            // TODO fare la stessa cosa con le visite
            return "welocomepagedoc";
        } else {
            return "notfound";
        }*/
    }
}
