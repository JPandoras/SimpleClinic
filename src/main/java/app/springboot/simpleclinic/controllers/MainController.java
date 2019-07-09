package app.springboot.simpleclinic.controllers;

import app.springboot.simpleclinic.constants.MainConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Value("${simple.clinic.page.title.login}")
    private String message;

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("message", message);

        return MainConstants.PAGE_REQUEST_LOGIN;
    }

}
