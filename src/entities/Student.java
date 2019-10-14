package entities;

import enums.Days;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    @Basic(optional = false, fetch = FetchType.LAZY)
    @Column(name="studentName", nullable = false, unique = false, updatable = false, length = 55)
    @Type(type = "string")
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private Days days;
    @Type(type="timestamp")
    private Date date;
    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Student() {
    }

    public Student(String name, Date dt, Days days) {
        this.name = name;
        this.date = dt;
        this.days = days;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
