package com.agro.capataztech.controller;

import com.agro.capataztech.repository.AnimalRepository;
import com.agro.capataztech.repository.VendaRepository;
import com.agro.capataztech.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired private AnimalRepository animalRepo;
    @Autowired private VacinaRepository vacinaRepo;
    @Autowired private VendaRepository vendaRepo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("totalAnimais", animalRepo.count());
        model.addAttribute("totalVacinas", vacinaRepo.count());
        model.addAttribute("totalVendas", vendaRepo.count());
        return "index";
    }
}