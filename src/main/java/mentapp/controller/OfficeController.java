package mentapp.controller;


import mentapp.models.Appointment;
import mentapp.models.Doctor;
import mentapp.models.Patient;
import mentapp.models.User;
import mentapp.repository.AppointmentRepository;
import mentapp.repository.PatientRepository;
import mentapp.repository.UserRepository;
import mentapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class OfficeController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DoctorRepository doctorRepository;


    @RequestMapping("/admin")
    public String setAdmin(@RequestParam(name = "id", required = true) Long id,
                             Model model) {
        Optional<User> result_user = userRepository.findById(id);
        if (result_user.isPresent()) {
            User user = result_user.get();
            model.addAttribute("admin", user);
            return "welcomepageoffice";
        } else {
            return "notfound";
        }
    }

    @GetMapping("statsDB")
    public String statsDB(@RequestParam(name = "id", required = true) Long id,
                          Model model){
        Optional<User> result_user = userRepository.findById(id);
        if (result_user.isPresent()) {
            User user = result_user.get();
            model.addAttribute("admin", user);
            long ct_doctors = doctorRepository.count();
            long ct_users = userRepository.count();
            long ct_patients = patientRepository.count();
            long ct_appointments = appointmentRepository.count();

            model.addAttribute("ct_doctors", ct_doctors);
            model.addAttribute("ct_users", ct_users);
            model.addAttribute("ct_patients", ct_patients);
            model.addAttribute("ct_appointments", ct_appointments);

            return "statsDB";
        }
        else {
            return "notfound";
        }
    }

    @RequestMapping("/officeapplist")
    public String officeapplist(@RequestParam(name="id", required=true) Long id, Model model) {
        Optional<User> result_user = userRepository.findById(id);
        if (result_user.isPresent()) {
            User user = result_user.get();
            model.addAttribute("admin", user);
            // lista apps
            List<Appointment> appointments = appointmentRepository.findAll();
            model.addAttribute("appointments", appointments);
            return "officeapplist";
            }
            else {
                //error
                return "notfound";
            }

        }

    @RequestMapping("/officeuserlist")
    public String officeuserlist(@RequestParam(name="id", required=true) Long id, Model model) {
        Optional<User> result_user = userRepository.findById(id);
        if (result_user.isPresent()) {
            User user = result_user.get();
            model.addAttribute("admin", user);

            // lista apps
            List<User> users = userRepository.findAll();
            model.addAttribute("users", users);
            return "officeuserlist";
        }
        else {
            //error
            return "notfound";
        }

    }
}

