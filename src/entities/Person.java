package entities;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue
    int id;
    String name;
    @OneToMany(mappedBy = "person")
    List<HomeAdress> homeAdress;

    public Person() {
    }

    public Person(String name, List<HomeAdress> homeAdress) {
        this.name = name;
        this.homeAdress = homeAdress;
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

    public List<HomeAdress> getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(List<HomeAdress> homeAdress) {
        this.homeAdress = homeAdress;
    }
}
