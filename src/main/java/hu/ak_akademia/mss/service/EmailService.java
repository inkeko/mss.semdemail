package hu.ak_akademia.mss.service;

import hu.ak_akademia.mss.model.RegistrationVerificationCode;
import hu.ak_akademia.mss.model.user.MssUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class EmailService {
    private String uniqueCode;

    private  JavaMailSender emailSender;
    private TemplateEngine templateEngine;
    @Autowired
    private RegistrationVerificationCodeService registrationVerificationCodeService;
    @Autowired
    public EmailService(JavaMailSender emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    private void generateUniqueCode() {
        UUID uuid = UUID.randomUUID();
        uniqueCode = uuid.toString();
    }
    public void sendRegistrationEmail(String email) throws MessagingException {
        generateUniqueCode();
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);


        helper.setFrom("inkeko@gmail.com");
        helper.setTo(email);
        helper.setSubject("Regisztráció megerősítése");
        Context context = new Context();
        context.setVariable("generatedCode", uniqueCode);
        String processedHtmlContent = templateEngine.process("activate_registration.html", context);
        helper.setText(processedHtmlContent, true);
        emailSender.send(message);
    }
    public void saveRegistrationVerificationCode(MssUser user) {
        RegistrationVerificationCode verificationCode = new RegistrationVerificationCode();
        verificationCode.setVerificationCode(uniqueCode);
        verificationCode.setUser(user);
        verificationCode.setExpirydate(LocalDate.now().plusDays(1));
        registrationVerificationCodeService.saveVerificationCode(verificationCode);
    }
}
