package entities;

import enums.Days;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Students")
public class Student {


    //@Id
    //@GeneratedValue
    @Transient
    private int id;
    @Access(AccessType.PROPERTY)
    @Basic(optional = false, fetch = FetchType.LAZY)
    @Column(name="name", nullable = false, unique = false, updatable = false, length = 55)
    @Type(type = "string")
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private Days days;
    @Type(type="timestamp")
    private Date date;
    @EmbeddedId
    private Adress adress;

    public Student() {
        this.adress = new Adress(Adress.STRING_NOT_DEFINED, Adress.STRING_NOT_DEFINED, Adress.NOT_DEFINED, Adress.NOT_DEFINED);
    }

    public Student(String name, Date dt, Days days) {
        this.name = name;
        this.date = dt;
        this.days = days;
    }
    public Student(String name,  Date date, Days days,Adress adress) {
        this.name = name;
        this.days = days;
        this.date = date;
        this.adress = adress;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }


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




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return "Mr."+name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
