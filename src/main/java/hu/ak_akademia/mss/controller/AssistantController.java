package hu.ak_akademia.mss.controller;

import hu.ak_akademia.mss.model.user.Assistant;
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
public class AssistantController {

    private RegistrationService registrationService;
    @Autowired
    private RegistrationVerificationService registrationVerificationService;
    @Autowired
    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/assistant")
    public String assistant_registration(Assistant assistant, Model model) {
        model.addAttribute("genderList", registrationService.getAllGender());
        return "assistant_registration";
    }

    @PostMapping("/assistant")
    public String assistantRegistrationForm(Assistant assistant, Model model) throws MessagingException {
        Map<String, String> errorList = registrationService.testMSSUserData(assistant);
        if (errorList.isEmpty()) {
            assistant.setRoles("ROLE_ASSISTANT");
            registrationService.encryptPassword(assistant);
            registrationService.save(assistant);
            return registrationVerificationService.performRegistrationVerification(assistant, model);

        }
        model.addAttribute("genderList", registrationService.getAllGender());
        model.addAllAttributes(errorList);
        return "assistant_registration";
    }
}
