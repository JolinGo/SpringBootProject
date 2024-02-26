package com.example.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password,
                                  ModelMap model) {

        // Authentication
        // name - test
        // password - password

        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);

            return "welcome";
        }

        model.put("errorMessage", "Invalid Credentials! Please try again");
        return "login";
    }
}
