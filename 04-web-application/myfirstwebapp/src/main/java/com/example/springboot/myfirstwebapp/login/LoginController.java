package com.example.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    //JSP
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    @RequestMapping("login")
    public String gotoLoginPage() {
        return "login";
    }
}
