package com.ceg.superherows.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceg.superherows.entity.HeroData;
import com.ceg.superherows.entity.Superhero;
import com.ceg.superherows.service.SuperheroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class SuperheroController {

    @Autowired
    private SuperheroService service;

    @PostMapping("/save")
    public Superhero save(@RequestBody HeroData heroData) {

        Superhero tmpSuperhero = new Superhero();
        // @TODO validate input parameters
        if(heroData == null){
            System.out.println("superhero from RequestBody is null");
            return tmpSuperhero;
        }

        if(heroData.getHeroName() == null || heroData.getHeroName().isEmpty()){
            System.out.println("heroData.heroName is null or empty");
            return tmpSuperhero;
        }

        tmpSuperhero.setHeroData(heroData);


        return service.saveSuperhero(tmpSuperhero);
    }

    // Tested. Works!
    @GetMapping("findAll")
    public List<Superhero> findAll() {
        return service.findAll();
    }

    // Tested. Works!
    @GetMapping("/findById")
    public Superhero findById(@RequestParam Long id) {
        // @TODO validate input parameters
        return service.findById(id);
    }

    @PutMapping("/update/{id}")
    public Superhero update(@RequestBody HeroData heroData, @PathVariable Long id) {

        Superhero tmpSuperhero = new Superhero();

        if(id == null){
            System.out.println("input param id is null.");
            return tmpSuperhero;
        }

        Superhero existingSuperhero = service.findById(id);
        if(existingSuperhero == null){
            System.out.println("No data found for id:" + id);
            return tmpSuperhero;
        }
        existingSuperhero.setHeroData(heroData);

        return service.updateSuperhero(existingSuperhero);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam Long id) {
        // @TODO validate input parameters
        System.out.println("Enter deleteById");
        Superhero tmpHero = new Superhero();
        tmpHero.setId(id);
        service.deleteSuperhero(tmpHero);
        System.out.println("Exit deleteById");
    }

}
