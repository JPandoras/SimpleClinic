package app.springboot.simpleclinic.controllers;

import app.springboot.simpleclinic.constants.MainConstants;
import app.springboot.simpleclinic.models.UserLogin;
import app.springboot.simpleclinic.models.UserLoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Role;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Value("${simple.clinic.page.title.login}")
    private String title;

    @GetMapping("/login")
    public String index(Model model) {
        model.addAttribute("title", title);
        return MainConstants.PAGE_REQUEST_LOGIN;
    }

    @GetMapping("/loginFailed")
    public String error(Model model) {
        model.addAttribute("title", title);
        model.addAttribute("error", true);
        return MainConstants.PAGE_REQUEST_LOGIN;
    }

    @PostMapping("/successLogin")
    public String login(Model model, HttpSession session) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        if (usernamePasswordAuthenticationToken.getPrincipal() instanceof UserLogin) {
            throw new IllegalArgumentException("Principal cannot be null!");
        }

        UserLogin userLogin = ((UserLoginDetails) usernamePasswordAuthenticationToken.getPrincipal()).getUserLogin();

        model.addAttribute("currentUser", userLogin.getUsername());
        session.setAttribute("userId", userLogin.getUserId());

        if ("DC".equals(userLogin.getRole().getRoleType())) {
            return doctorPage(model);
        } else if ("CA".equals(userLogin.getRole().getRoleType())) {
            return clinicAdmPage(model);
        }

        return pharmacyPage(model);
    }

    @GetMapping("/logout")
    public String loginError(Model model) {
        model.addAttribute("title", title);
        model.addAttribute("logout", true);
        return MainConstants.PAGE_REQUEST_LOGIN;
    }

    @GetMapping("/doctor")
    public String doctorPage(Model model) {
        return MainConstants.PAGE_REQUEST_DOCTOR;
    }

    @GetMapping("/clinicadm")
    public String clinicAdmPage(Model model) {
        return MainConstants.PAGE_REQUEST_CLINIC_ADM;
    }

    @GetMapping("/pharmacy")
    public String pharmacyPage(Model model) {
        return MainConstants.PAGE_REQUEST_PHARMACY;
    }

}
