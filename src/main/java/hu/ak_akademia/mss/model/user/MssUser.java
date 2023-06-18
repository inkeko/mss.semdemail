package hu.ak_akademia.mss.model.user;

import hu.ak_akademia.mss.model.AreaOfExpertise;
import hu.ak_akademia.mss.model.Language;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MssUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private boolean active = false;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime registrationDate = LocalDateTime.now(); // automatically LocalDateTime.now() value
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private int gender;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String roles;
    @ManyToMany
    @JoinTable(name = "mss_user_to_language",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languages;

    @ManyToMany
    @JoinTable(name = "mss_user_to_area_of_expertise",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "area_of_expertise_id"))
    private List<AreaOfExpertise> areaOfExpertise;

    public MssUser() {
    }

    public MssUser(int userId, boolean active, LocalDateTime registrationDate, String email, String password, String firstName, String lastName, int gender, String phoneNumber, String roles, List<Language> languages, List<AreaOfExpertise> areaOfExpertise) {
        this.userId = userId;
        this.active = active;
        this.registrationDate = registrationDate;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
        this.languages = languages;
        this.areaOfExpertise = areaOfExpertise;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<AreaOfExpertise> getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setAreaOfExpertise(List<AreaOfExpertise> areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MssUser mssUser)) return false;
        return getUserId() == mssUser.getUserId() && isActive() == mssUser.isActive() && getGender() == mssUser.getGender() && Objects.equals(getRegistrationDate(), mssUser.getRegistrationDate()) && Objects.equals(getEmail(), mssUser.getEmail()) && Objects.equals(getPassword(), mssUser.getPassword()) && Objects.equals(getFirstName(), mssUser.getFirstName()) && Objects.equals(getLastName(), mssUser.getLastName()) && Objects.equals(getPhoneNumber(), mssUser.getPhoneNumber()) && Objects.equals(getRoles(), mssUser.getRoles()) && Objects.equals(getLanguages(), mssUser.getLanguages()) && Objects.equals(getAreaOfExpertise(), mssUser.getAreaOfExpertise());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), isActive(), getRegistrationDate(), getEmail(), getPassword(), getFirstName(), getLastName(), getGender(), getPhoneNumber(), getRoles(), getLanguages(), getAreaOfExpertise());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MssUser.class.getSimpleName() + "[", "]")
                .add("userId=" + userId)
                .add("active=" + active)
                .add("registrationDate=" + registrationDate)
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("gender=" + gender)
                .add("phoneNumber='" + phoneNumber + "'")
                .add("roles='" + roles + "'")
                .add("languages=" + languages)
                .add("areaOfExpertise=" + areaOfExpertise)
                .toString();
    }
}


