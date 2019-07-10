package app.springboot.simpleclinic;

import app.springboot.simpleclinic.constants.MainConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Value("${simple.clinic.page.title.login}")
    private String title;

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("title", title);
        return MainConstants.PAGE_REQUEST_LOGIN;
    }

}
