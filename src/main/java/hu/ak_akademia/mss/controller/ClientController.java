package hu.ak_akademia.mss.controller;

import hu.ak_akademia.mss.model.user.Client;
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
public class ClientController {

    private RegistrationService registrationService;


    @Autowired
    private RegistrationVerificationService registrationVerificationService;

    @Autowired
    public ClientController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping()
    public String registration(Client client, Model model) {
        model.addAttribute("genderList", registrationService.getAllGender());
        model.addAttribute("languageList", registrationService.getLanguages());
        return "registration";
    }

    @PostMapping("/client")
    public String registrationForm(Client client, Model model) throws MessagingException {
        Map<String, String> errorList = registrationService.testMSSUserData(client);
        if (errorList.isEmpty()) {
            client.setRoles("ROLE_CLIENT");
            registrationService.encryptPassword(client);
            registrationService.save(client);
            return registrationVerificationService.performRegistrationVerification(client, model);
        }
        model.addAttribute("genderList", registrationService.getAllGender());
        model.addAttribute("languageList", registrationService.getLanguages());
        model.addAllAttributes(errorList);
        return "registration";
    }


}
