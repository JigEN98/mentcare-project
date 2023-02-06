package mentapp.controller;

import mentapp.models.User;
import mentapp.models.Patient;
import mentapp.repository.PatientRepository;
import mentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserRepository userRepository;



    @RequestMapping("/")
    public String index(){
        return "loginpage";
    }

    @RequestMapping("/login")
    public String login(){
        return "loginpage";
    }

    @RequestMapping("/login_check")
    public String login_check(
            @RequestParam(name="username", required=true) String username,
            @RequestParam(name="password", required=true) String password,
            Model model) {

        User user = userRepository.findByUsername(username);
        System.out.println(user);
        if(user == null)
        {
            System.out.println("Entro nel null");
            return "notfound";
        }
        System.out.println(user.getPassword());
        System.out.println(password);
        if(user.getPassword().equals(password)) {
                // check patient
                System.out.println("psw correct");
                for (Patient p :patientRepository.findAll()) {
                    if(user.getUsername() == p.getUserName()) {
                        System.out.println("user found!");
                        return "redirect:/patient?id="+p.getID();
                    }
                }
                // check doctor
                // check admin
            } else {
                // password wrong!
                System.out.println("psw wrong");
                return "notfound";
            }

        return "notfound";
    }

}
