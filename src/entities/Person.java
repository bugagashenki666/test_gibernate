package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {

    @Id
    @GeneratedValue
    int id;
    String name;
    @OneToOne
    HomeAdress homeAdress;

    public Person() {
    }

    public Person(String name, HomeAdress homeAdress) {
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

    public HomeAdress getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(HomeAdress homeAdress) {
        this.homeAdress = homeAdress;
    }
}
