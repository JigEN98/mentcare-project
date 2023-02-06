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

        if(user == null)
        {
            return "notfound";
        }

        for (Patient p :patientRepository.findAll()) {
            if((user.getUsername() == p.getUserName()) && (user.getPassword() == p.getPassword())) {
                System.out.println("user found!");
                return "welcomepagepatient";
            }

        }
        return "notfound";
    }

}
