package com.agro.capataztech.controller;

import com.agro.capataztech.model.Animal;
import com.agro.capataztech.repository.AnimalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("animais", animalRepository.findAll());
        return "animais/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        Animal animal = new Animal();
        animal.setSituacao("Disponível");
        model.addAttribute("animal", animal);
        return "animais/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("animal") Animal animal, BindingResult result) {
        if (result.hasErrors()) return "animais/formulario";
        animalRepository.save(animal);
        return "redirect:/animais";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("animal", animal);
        return "animais/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        animalRepository.deleteById(id);
        return "redirect:/animais";
    }
}