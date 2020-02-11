package criteriaAPI.model;

import javax.persistence.*;

@Entity
@Table(name = "technologies")
public class Technologies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "technologies")
    private String technologies;

    @Column(name = "candidatesid")
    private String candidatesid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getCandidatesid() {
        return candidatesid;
    }

    public void setCandidatesid(String candidatesid) {
        this.candidatesid = candidatesid;
    }

    @Override
    public String toString() {
        return technologies;
    }
}
