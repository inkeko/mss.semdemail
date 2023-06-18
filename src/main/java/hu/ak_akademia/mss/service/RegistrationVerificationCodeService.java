package hu.ak_akademia.mss.service;
import hu.ak_akademia.mss.model.RegistrationVerificationCode;
import hu.ak_akademia.mss.model.user.MssUser;
import hu.ak_akademia.mss.repository.RegistrationVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
@Service
    public class RegistrationVerificationCodeService {
        private RegistrationVerificationRepository registrationVerificationRepository;
        @Autowired
        public RegistrationVerificationCodeService(RegistrationVerificationRepository registrationVerificationRepository) {
            this.registrationVerificationRepository = registrationVerificationRepository;
        }
        public void saveVerificationCode(RegistrationVerificationCode verificationCode) {
            registrationVerificationRepository.save(verificationCode);
        }
        public boolean isValidCode(String verificationCode) {
            RegistrationVerificationCode code = registrationVerificationRepository.findByVerificationCode(verificationCode);
            return code != null;
        }
        public MssUser findUserByVerificationCode(String verificationCode) {
            RegistrationVerificationCode code = registrationVerificationRepository.findByVerificationCode(verificationCode);
            return code != null ? code.getUser() : null;
        }
        public boolean isRegistrationCodeValid(String verificationCode) {
            RegistrationVerificationCode code = registrationVerificationRepository.findByVerificationCode(verificationCode);
            if (code != null) {
                LocalDate experodate = code.getExpirydate();
                LocalDate currentDate = LocalDate.now();
                return experodate.plusDays(1).isAfter(currentDate);
            }
            return false;
        }
    }


