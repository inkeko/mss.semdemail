package hu.ak_akademia.mss.service;

import hu.ak_akademia.mss.model.AreaOfExpertise;
import hu.ak_akademia.mss.model.user.MssSecurityUser;
import hu.ak_akademia.mss.model.user.MssUser;
import hu.ak_akademia.mss.repository.AreaOfExpertiseRepository;
import hu.ak_akademia.mss.repository.MSSUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@Service
public class MssUserDetailService implements UserDetailsService {

    public MSSUserRepository mssUserRepository;
    private AreaOfExpertiseService areaOfExpertiseService;

    public MssUserDetailService(MSSUserRepository mssUserRepository, AreaOfExpertiseService areaOfExpertiseService) {
        this.mssUserRepository = mssUserRepository;
        this.areaOfExpertiseService = areaOfExpertiseService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MssUser mssUser = mssUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found " + email));
        return new MssSecurityUser(mssUser);
    }

    public void setActivationStatus(long userId, boolean isActive) {
        MssUser user = mssUserRepository.findById((int) userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        user.setActive(isActive);
        mssUserRepository.save(user);
    }
    public List<MssUser> getDoctorOfSpetc(String qualification) {
        AreaOfExpertise areaOfExpertise = areaOfExpertiseService.getAreaOfExpertiseByQualification(qualification);
        return mssUserRepository.findByAreaOfExpertise(areaOfExpertise);
    }


}