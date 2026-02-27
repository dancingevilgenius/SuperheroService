package com.ceg.superherows.entity;

//package com.example.superhero;

import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "superheroes")
public class Superhero {

    @Id
    private Long id;


    @JdbcTypeCode(SqlTypes.JSON) 
    @Column(columnDefinition = "jsonb") // Explicitly define the column as JSONB in the DB
    private HeroData heroData; 



    public Superhero() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HeroData getHeroData() {
        return heroData;
    }


    public void setHeroData(HeroData heroData) {
        this.heroData = heroData;
    }



}
