package criteriaAPI.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contacts")
public class Contacts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "contact")
    private String contact;

    @Column(name = "candidatesid")
    private Integer candidatesid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getCandidatesid() {
        return candidatesid;
    }

    public void setCandidatesid(Integer candidatesid) {
        this.candidatesid = candidatesid;
    }

    @Override
    public String toString() {
        return contact;
    }

}
