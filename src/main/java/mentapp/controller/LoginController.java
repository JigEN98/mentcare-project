package mentapp.controller;

import mentapp.models.User;
import mentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

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

        if(user.getPassword().equals(password)) {

            if(user.getRole().equals("patient")) {
                // check patient
                return "redirect:/patient?id="+user.getID();
            }
            else if(user.getRole().equals("doctor")) {
                // check doctor
                return "redirect:/doctor?id="+user.getID();
            }
            else if(user.getRole().equals("admin")) {
                // check admin
                return "redirect:/admin?id="+user.getID();
            }
            else
                return "notfound";

            // check admin
        } else {
            // password wrong!
            System.out.println("psw wrong");
            return "notfound";
        }

    }

}
