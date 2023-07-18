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


    public MssUserDetailService(MSSUserRepository mssUserRepository) {
        this.mssUserRepository = mssUserRepository;
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
        AreaOfExpertise areaOfExpertise = new AreaOfExpertise();
        areaOfExpertise.setQualification(qualification);
        return mssUserRepository.findByAreaOfExpertise(areaOfExpertise);
    }
 }