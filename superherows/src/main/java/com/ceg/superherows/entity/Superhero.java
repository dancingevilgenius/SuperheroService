package com.ceg.superherows.entity;

//package com.example.superhero;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "superheroes")
public class Superhero {

    @Id
    private Long id;

    private String heroName;
    private String civilianFirstName;
    private String civilianLastName;

    @ElementCollection
    private List<String> powerSet;

    @ElementCollection
    private List<Address> addresses;

    public Superhero() {
    }

    public Superhero(String heroName,
            String civilianFirstName,
            String civilianLastName,
            List<String> powerSet,
            List<Address> addresses) {
        this.heroName = heroName;
        this.civilianFirstName = civilianFirstName;
        this.civilianLastName = civilianLastName;
        this.powerSet = powerSet;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getCivilianFirstName() {
        return civilianFirstName;
    }

    public void setCivilianFirstName(String civilianFirstName) {
        this.civilianFirstName = civilianFirstName;
    }

    public String getCivilianLastName() {
        return civilianLastName;
    }

    public void setCivilianLastName(String civilianLastName) {
        this.civilianLastName = civilianLastName;
    }

    public List<String> getPowerSet() {
        return powerSet;
    }

    public void setPowerSet(List<String> powerSet) {
        this.powerSet = powerSet;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
