package mentapp.controller;


import mentapp.models.*;
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

import java.util.LinkedList;
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

    @GetMapping("/statsDB")
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
            List<String> docs = new LinkedList<>();
            List<String> pats = new LinkedList<>();
            for (Appointment a: appointmentRepository.findAll()) {
                Optional<Doctor> doc = doctorRepository.findById(a.getIdDoctor());
                if(doc.isPresent()) {
                    docs.add(doc.get().getName().concat(" ").concat(doc.get().getSurname()));
                }
                Optional<Patient> pat = patientRepository.findById(a.getIdPatient());
                if(pat.isPresent()) {
                    pats.add(pat.get().getName().concat(" ").concat(pat.get().getSurname()));
                }
            }
            model.addAttribute("appointments", appointments);
            model.addAttribute("docs", docs);
            model.addAttribute("pats", pats);

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

            // liste utenti con nomi e cognomi associati (senza admin)
            List<String> userNS = new LinkedList<>();
            List<User> officeListUsers = new LinkedList<>();
            for (User u: userRepository.findAll()) {
               if(!u.getRole().equals("admin")) {
                   if(u.getRole().equals("patient")) {
                       Optional<Patient> p = patientRepository.findById(u.getID());
                       if(p.isPresent()) {
                           userNS.add(p.get().getName().concat(" ").concat(p.get().getSurname()));
                       }
                   }
                   if(u.getRole().equals("doctor")) {
                       Optional<Doctor> d = doctorRepository.findById(u.getID());
                       if(d.isPresent()) {
                           userNS.add(d.get().getName().concat(" ").concat(d.get().getSurname()));
                       }
                   }
                   officeListUsers.add(u);
               }
            }
            model.addAttribute("users", officeListUsers);
            model.addAttribute("ns", userNS);
            return "officeuserlist";
        }
        else {
            //error
            return "notfound";
        }

    }
}

