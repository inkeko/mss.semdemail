package hu.ak_akademia.mss.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id")
    private int id;

    private String gender;

    public Gender() {
    }

    public Gender(int id, String gender) {
        this.id = id;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender1 = (Gender) o;
        return id == gender1.id && Objects.equals(gender, gender1.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gender);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
