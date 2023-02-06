package mentapp.controller;

import mentapp.models.Doctor;
import mentapp.models.Patient;
import mentapp.repository.DoctorRepository;
import mentapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @RequestMapping("/doctor")
    public String setDoctor(@RequestParam(name="id", required=true) Integer id, Model model) {

        Doctor result_doc = doctorRepository.findByCode(id);
        if(result_doc == null) {
            return "notfound";
        } else {
            List<Patient> doctorPatients = patientRepository.findByDoc(result_doc.getID());
            //System.out.println(doctorPatients.toString());
            model.addAttribute("patients", doctorPatients);
            // TODO fare la stessa cosa con le visite
            model.addAttribute("doctor", result_doc);
            return "welcomepagedoc";
        }
    }
    @RequestMapping("/insert_patient")
    public String insertPatient() {
        return "welcomepagedoc";
    }

    @RequestMapping("/modify_patient")
    public String modifyPatient() {
        return "welcomepagedoc";
    }

    @RequestMapping("delete_patient")
    public String deletePatient() {
        return "welcomepagedoc";
    }
}
