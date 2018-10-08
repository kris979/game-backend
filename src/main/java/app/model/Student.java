package app.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @SequenceGenerator(name = "COL_GEN", sequenceName = "COL_SQE",schema="TEST")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COL_GEN")
    private Long id;
    private String name;
    private String passportNumber;

    public Student() {
    }

    public Student(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}