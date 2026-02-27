package com.ceg.superherows.controller;

import java.util.List;

import com.ceg.superherows.entity.Superhero;

public record ResponseList(boolean success, List<String> errorList, List<Superhero> list) {    
}
