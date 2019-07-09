package app.springboot.simpleclinic.controllers;

import app.springboot.simpleclinic.constants.MainConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @Value("${simple.clinic.page.title.login}")
    private String message;

    @GetMapping("/")
    public String login(Map<String, Object> model) {
        model.put("message", message);
        return MainConstants.PAGE_REQUEST_LOGIN;
    }

}
