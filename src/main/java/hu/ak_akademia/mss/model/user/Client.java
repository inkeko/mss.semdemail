package hu.ak_akademia.mss.model.user;

import hu.ak_akademia.mss.model.Language;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Client extends MssUser {


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String placeOfBirth;

    private String mothersName;
    @Column(length = 11)
    private String TAJNumber;

    public Client() {
    }

    public Client(int userId, boolean active, LocalDateTime registrationDate, String email, String password, String firstName, String lastName, int gender, String phoneNumber, String roles, List<Language> languages, LocalDate dateOfBirth, String placeOfBirth, String mothersName, String TAJNumber) {
        super(userId, active, registrationDate, email, password, firstName, lastName, gender, phoneNumber, roles, languages, Collections.emptyList());
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.mothersName = mothersName;
        this.TAJNumber = TAJNumber;
    }

    //  ACTIVE FIELD NÉLKÜLI KONSTRUKTOR - Dexter
//    public Client(int userId, LocalDateTime registrationDate, String email, String password, String firstName, String lastName, int gender, String phoneNumber, String roles, List<Language> languages, LocalDate dateOfBirth, String placeOfBirth, String mothersName, String TAJNumber) {
//        super(userId, registrationDate, email, password, firstName, lastName, gender, phoneNumber, roles, languages, Collections.emptyList());
//        this.dateOfBirth = dateOfBirth;
//        this.placeOfBirth = placeOfBirth;
//        this.mothersName = mothersName;
//        this.TAJNumber = TAJNumber;
//    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getTAJNumber() {
        return TAJNumber;
    }

    public void setTAJNumber(String TAJNumber) {
        this.TAJNumber = TAJNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getDateOfBirth(), client.getDateOfBirth()) && Objects.equals(getPlaceOfBirth(), client.getPlaceOfBirth()) && Objects.equals(getMothersName(), client.getMothersName()) && Objects.equals(getTAJNumber(), client.getTAJNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDateOfBirth(), getPlaceOfBirth(), getMothersName(), getTAJNumber());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Client.class.getSimpleName() + "[", "]")
                .add("dateOfBirth=" + dateOfBirth)
                .add("placeOfBirth='" + placeOfBirth + "'")
                .add("mothersName='" + mothersName + "'")
                .add("TAJNumber='" + TAJNumber + "'")
                .toString();
    }
}
