package hu.ak_akademia.mss.model;

import hu.ak_akademia.mss.model.user.MssUser;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
public class RegistrationVerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name = "verificationCode", unique = true)
    private String verificationCode;


    @OneToOne(targetEntity = MssUser.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private MssUser user;

    private LocalDate expirydate;

    public RegistrationVerificationCode() {
        // Alapértelmezett konstruktor
    }
    public RegistrationVerificationCode(String verificationCode, MssUser user, LocalDate expirydate) {
        this.verificationCode = verificationCode;
        this.user = user;
        this.expirydate = expirydate;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public MssUser getUser() {
        return user;
    }

    public void setUser(MssUser user) {
        this.user = user;
    }

    public LocalDate getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(LocalDate expirydate) {
        this.expirydate = expirydate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationVerificationCode that = (RegistrationVerificationCode) o;
        return Objects.equals(verificationCode, that.verificationCode) && Objects.equals(user, that.user) && Objects.equals(expirydate, that.expirydate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verificationCode, user, expirydate);
    }

    @Override
    public String toString() {
        return "RegistrationVerificationCode{" +
                "verificationCode='" + verificationCode + '\'' +
                ", user=" + user +
                ", expirydate=" + expirydate +
                '}';
    }
}

