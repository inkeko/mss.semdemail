package hu.ak_akademia.mss.model;

import hu.ak_akademia.mss.model.user.MssUser;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class AreaOfExpertise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_of_expertise_id")
    private int id;

    private String qualification;

    @ManyToMany(mappedBy = "areaOfExpertise")
    private List<MssUser> users;

    public AreaOfExpertise() {

    }

    public AreaOfExpertise(int id, String qualification, List<MssUser> users) {
        this.id = id;
        this.qualification = qualification;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<MssUser> getUsers() {
        return users;
    }

    public void setUsers(List<MssUser> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AreaOfExpertise that)) return false;
        return getId() == that.getId() && Objects.equals(getQualification(), that.getQualification()) && Objects.equals(getUsers(), that.getUsers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQualification(), getUsers());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AreaOfExpertise.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("qualification='" + qualification + "'")
                .toString();
    }
}
