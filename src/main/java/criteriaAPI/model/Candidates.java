package criteriaAPI.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "candidates")
public class Candidates {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "middlename")
    private String patronymic;

    @Column(name = "birthday")
    private Date birthday;

    @ManyToOne(targetEntity = Gender.class)
    @JoinColumn(name = "genderid", referencedColumnName = "id")
    private Gender gender;

    @OneToMany(mappedBy = "candidatesid", targetEntity = Contacts.class)
    private Set<Contacts> contactsSet;

    @OneToMany(mappedBy = "candidatesid", targetEntity = Technologies.class)
    private Set<Technologies> technologiesSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Contacts> getContactsSet() {
        return contactsSet;
    }

    public void setContactsSet(Set<Contacts> contactsSet) {
        this.contactsSet = contactsSet;
    }

    public Set<Technologies> getTechnologiesSet() {
        return technologiesSet;
    }

    public void setTechnologiesSet(Set<Technologies> technologiesSet) {
        this.technologiesSet = technologiesSet;
    }

    @Override
    public String toString() {
        return "Candidates{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", genderid=" + gender +
                ", contactsSet=" + contactsSet +
                ", technologiesSet=" + technologiesSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidates that = (Candidates) o;
        return id == that.id &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(name, that.name) &&
                Objects.equals(patronymic, that.patronymic) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(contactsSet, that.contactsSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, birthday, gender, contactsSet);
    }
}
