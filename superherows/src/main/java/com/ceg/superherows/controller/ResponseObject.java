package com.ceg.superherows.controller;

import java.util.List;

import com.ceg.superherows.entity.Superhero;

public record ResponseObject(boolean success, List<String> errorList, Superhero superhero) {    
}
