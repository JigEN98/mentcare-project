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
    public String setDoctor(@RequestParam(name="id", required=true) Long id, Model model) {

        Optional<Doctor> result_doc = doctorRepository.findById(id);
        if(result_doc.isPresent()) {
            Doctor doc = result_doc.get();
            List<Patient> doctorPatients = patientRepository.findByDoc(doc.getID());
            //System.out.println(doctorPatients.toString());
            model.addAttribute("patients", doctorPatients);
            // TODO fare la stessa cosa con le visite
            model.addAttribute("doctor", doc);
            return "welcomepagedoc";
        } else {
            return "notfound";
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
