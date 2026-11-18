package com.agro.capataztech.controller;

import com.agro.capataztech.model.Vacina;
import com.agro.capataztech.repository.VacinaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacinas")
public class VacinaController {

    @Autowired
    private VacinaRepository vacinaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vacinas", vacinaRepository.findAll());
        return "vacinas/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("vacina", new Vacina());
        return "vacinas/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("vacina") Vacina vacina, BindingResult result) {
        if (result.hasErrors()) return "vacinas/formulario";
        vacinaRepository.save(vacina);
        return "redirect:/vacinas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Vacina vacina = vacinaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("vacina", vacina);
        return "vacinas/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        vacinaRepository.deleteById(id);
        return "redirect:/vacinas";
    }
}