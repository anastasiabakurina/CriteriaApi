package criteriaAPI.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "gender", targetEntity = Candidates.class)
    private Set<Candidates> candidates;

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

    public Set<Candidates> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidates> candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "gender='" + gender + '\'';
    }
}
