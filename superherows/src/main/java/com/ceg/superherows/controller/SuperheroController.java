package com.ceg.superherows.controller;

import java.util.ArrayList;
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

    @PostMapping("/")
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
    @GetMapping("/{id}")
    public ResponseObject findById(@PathVariable Long id) {

        boolean success = false;
        ResponseObject ro;
        List<String> errorMsgs = new ArrayList<String>();
        if(id == null || id < 0){
            errorMsgs.add("id parameter is null or negative");
            ro = new ResponseObject(success, errorMsgs, null);
            return ro;
        }
        


        Superhero sh = service.findById(id);
        success = true;
        ro = new ResponseObject(success, errorMsgs, sh);
        return ro;
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        // @TODO validate input parameters
        System.out.println("Enter deleteById");
        Superhero tmpHero = new Superhero();
        tmpHero.setId(id);
        service.deleteSuperhero(tmpHero);
        System.out.println("Exit deleteById");
    }

}
