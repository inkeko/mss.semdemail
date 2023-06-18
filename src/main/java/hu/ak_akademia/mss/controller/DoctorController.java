package hu.ak_akademia.mss.controller;

import hu.ak_akademia.mss.model.user.Doctor;
import hu.ak_akademia.mss.service.RegistrationService;
import hu.ak_akademia.mss.service.RegistrationVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import java.util.Map;

@Controller
@RequestMapping("/register")
public class DoctorController {

    private RegistrationService registrationService;
    @Autowired
    private RegistrationVerificationService registrationVerificationService;
    @Autowired
    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/doctor")
    public String doctor_registration(Doctor doctor, Model model) {
        model.addAttribute("genderList", registrationService.getAllGender());
        model.addAttribute("areaOfExpertiseList", registrationService.getAllAreaOfExpertises());
        return "doctor_registration";
    }

    @PostMapping("/doctor")
    public String doctorRegistrationForm(Doctor doctor, Model model) throws MessagingException {
        Map<String, String> errorList = registrationService.testMSSUserData(doctor);
        if (errorList.isEmpty()) {
            doctor.setRoles("ROLE_DOCTOR");
            registrationService.save(doctor);
            return registrationVerificationService.performRegistrationVerification(doctor, model);

        }
        model.addAttribute("genderList", registrationService.getAllGender());
        model.addAttribute("areaOfExpertiseList", registrationService.getAllAreaOfExpertises());
        model.addAllAttributes(errorList);
        return "doctor_registration";
    }
}
