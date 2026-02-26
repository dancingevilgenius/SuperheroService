package com.ceg.superherows.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceg.superherows.entity.Superhero;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

}
