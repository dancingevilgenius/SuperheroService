package com.ceg.superherows.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceg.superherows.entity.Superhero;
import com.ceg.superherows.service.SuperheroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class SuperheroController {

    @Autowired
    private SuperheroService service;

    @PostMapping("/save")
    public Superhero save(@RequestBody Superhero superhero) {

        // @TODO validate input parameters

        return service.saveSuperhero(superhero);
    }

    @GetMapping("findAll")
    public List<Superhero> findAll() {
        return service.findAll();
    }

    @GetMapping("/findById")
    public Superhero findById(@RequestParam Long id) {
        // @TODO validate input parameters
        return service.findById(id);
    }

    @PutMapping("/update")
    public Superhero update(@RequestBody Superhero superhero) {

        // @TODO validate input parameters

        return service.updateSuperhero(superhero);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam Long id) {
        // @TODO validate input parameters

        Superhero tmpHero = new Superhero();
        tmpHero.setId(id);
        service.deleteSuperhero(tmpHero);
    }

}
