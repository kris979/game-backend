package app.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String passportNumber;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }

    public Student(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }
}