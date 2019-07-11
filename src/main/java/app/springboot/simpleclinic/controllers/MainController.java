package app.springboot.simpleclinic.controllers;

import app.springboot.simpleclinic.constants.MainConstants;
import app.springboot.simpleclinic.helper.UUIDHelper;
import app.springboot.simpleclinic.models.*;
import app.springboot.simpleclinic.services.MedicationService;
import app.springboot.simpleclinic.services.PatientService;
import app.springboot.simpleclinic.services.TreatmentService;
import com.sun.net.httpserver.HttpsConfigurator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Role;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @Value("${simple.clinic.page.title.login}")
    private String title;

    @Autowired
    private PatientService patientService;

    @Autowired
    private TreatmentService treatmentService;

    @Autowired
    private MedicationService medicationService;

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
        model.addAttribute("patients", patientService.getAll());
        model.addAttribute("idleState", true);
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

    @PostMapping("/doSubmitEntry")
    public String submitEntry(@Valid @ModelAttribute("patient") Patient patient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", true);
        } else {
            patient.setId(UUIDHelper.getGeneratedID());
            patient.setStatus(MainConstants.PATIENT_STATUS_NEW);
            patientService.save(patient);

            model.addAttribute("success", true);
        }
        return MainConstants.PAGE_REQUEST_CLINIC_ADM;
    }

    @PostMapping("/doProcessPatient")
    public String processPatient(@RequestParam String id, Model model, HttpSession session) {
        Treatment treatment = patientService.patientTreatment(id, session.getAttribute("userId").toString());

        model.addAttribute("treatment", treatment);
        model.addAttribute("treatmentState", true);

        return MainConstants.PAGE_REQUEST_DOCTOR;
    }

    @PostMapping("/doEndProcessPatient")
    public String endProcessPatient(@RequestParam String id, Model model) {
        Treatment treatment = treatmentService.getTreatment(id);

        Patient patient = treatment.getPatientId();
        patient.setStatus(MainConstants.PATIENT_STATUS_MEDIC);

        patientService.save(patient);

        model.addAttribute("treatmentId", treatment.getId());
        model.addAttribute("medicationState", true);
        return MainConstants.PAGE_REQUEST_DOCTOR;
    }

    @PostMapping("/doAddMedication")
    public String addMedication(@RequestParam String id, @Valid @ModelAttribute("medication") Medication medication, Model model) {
        Treatment treatment = treatmentService.getTreatment(id);

        medication.setId(UUIDHelper.getGeneratedID());
        medication.setTreatmentId(treatment);

        medicationService.save(medication);

        model.addAttribute("doneState", true);
        return doctorPage(model);
    }

}
