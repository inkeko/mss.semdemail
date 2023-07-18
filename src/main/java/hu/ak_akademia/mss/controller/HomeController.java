package hu.ak_akademia.mss.controller;

import hu.ak_akademia.mss.model.AreaOfExpertise;
import hu.ak_akademia.mss.model.user.MssUser;
import hu.ak_akademia.mss.repository.RegistrationVerificationRepository;
import hu.ak_akademia.mss.service.AreaOfExpertiseService;
import hu.ak_akademia.mss.service.MssUserDetailService;
import hu.ak_akademia.mss.service.RegistrationService;
import hu.ak_akademia.mss.service.RegistrationVerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {
    private RegistrationService registrationService;
    private AreaOfExpertiseService areaOfExpertiseService;

    @Autowired
    private RegistrationVerificationCodeService registrationVerificationCodeService;
    @Autowired
    private MssUserDetailService mssUserDetailService;
    @Autowired
    private RegistrationVerificationRepository registrationVerificationRepository;

    public HomeController() {
    }

    @Autowired
    public void setRegistrationService(RegistrationService registrationService, RegistrationVerificationCodeService registrationVerificationCodeService, AreaOfExpertiseService areaOfExpertiseService) {
        this.registrationService = registrationService;
        this.registrationVerificationCodeService = registrationVerificationCodeService;
        this.areaOfExpertiseService = areaOfExpertiseService;
    }

    @GetMapping
    public String index() {
        return "/index";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        var currentUser = registrationService.getLoggedInUser(principal.getName());
        model.addAttribute("currentUser", currentUser.getFirstName() + " " + currentUser.getLastName());
        List<AreaOfExpertise> areaOfExpertise = areaOfExpertiseService.getAllAreaOfexpertise();
        Collections.sort(areaOfExpertise, Comparator.comparing(AreaOfExpertise::getQualification));
        model.addAttribute("areaOfexpertise", areaOfExpertise);

        for (AreaOfExpertise qualifications : areaOfExpertise) {
            List<MssUser> doktors = mssUserDetailService.getDoctorOfSpetc(qualifications.getQualification());
            model.addAttribute("doktors_" + qualifications.getId(), doktors);
        }


        return "home";
    }

    @ExceptionHandler(value = RuntimeException.class)
    public String error(RuntimeException e, Model model) {
        model.addAttribute("exception", e.getMessage());
        return "error";
    }

//    ************************************************************************************************************

    @GetMapping("/login")
    public String login(Model model, String error) {
        if (error != null) {
            model.addAttribute("errorMsg", "Incorrect username or password1!");

        }
        return "login";
    }

    @PostMapping("/logout")
    public String logout() {
        return "login";
    }


    // *** regisztrácios kod ellenőrzése*****
    @GetMapping("verify_code")
    public String verifyRegistrationCode(@RequestParam("code") String verificationCode, Model model) {
        if (registrationVerificationCodeService.isValidCode(verificationCode)) {
            if (registrationVerificationCodeService.isRegistrationCodeValid(verificationCode)) {
                MssUser user = registrationVerificationCodeService.findUserByVerificationCode(verificationCode);
                if (user != null) {
                    // regisztrácios kod helyes és a kod ideje nem járt még le
                    user.setActive(true); // isActive mező true-ra állítás
                    registrationService.save(user); // Felhasználó mentése az adatbázisba
                    model.addAttribute("message", "Regisztrációs kód helyes!");
                    model.addAttribute("user_first_name", user.getFirstName());
                    model.addAttribute("user_last_name", user.getLastName());
                    model.addAttribute("loginUrl", "/login");
                    return "registration_verification";
                }
            } else {
                // Regisztrációs kód lejárt
                model.addAttribute("message", "Regisztrációs kód lejárt!");
                return "registration_verification";
            }
        }
        // Érvénytelen regisztrációs kód
        model.addAttribute("message", "Érvénytelen regisztrációs kód!");
        return "registration_verification";
    }
}
