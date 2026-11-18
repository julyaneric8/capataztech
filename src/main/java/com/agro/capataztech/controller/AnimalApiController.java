package com.agro.capataztech.controller;

import com.agro.capataztech.model.Animal;
import com.agro.capataztech.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animais")
public class AnimalApiController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }
}