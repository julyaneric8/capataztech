package com.agro.capataztech.controller;

import com.agro.capataztech.model.AplicacaoVacina;
import com.agro.capataztech.repository.AplicacaoVacinaRepository;
import com.agro.capataztech.repository.AnimalRepository;
import com.agro.capataztech.repository.VacinaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aplicacoes")
public class AplicacaoVacinaController {

    @Autowired private AplicacaoVacinaRepository aplicacaoRepository;
    @Autowired private AnimalRepository animalRepository;
    @Autowired private VacinaRepository vacinaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("aplicacoes", aplicacaoRepository.findAll());
        return "aplicacoes/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("aplicacao", new AplicacaoVacina());
        model.addAttribute("animais", animalRepository.findAll());
        model.addAttribute("vacinas", vacinaRepository.findAll());
        return "aplicacoes/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("aplicacao") AplicacaoVacina aplicacao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("animais", animalRepository.findAll());
            model.addAttribute("vacinas", vacinaRepository.findAll());
            return "aplicacoes/formulario";
        }
        aplicacaoRepository.save(aplicacao);
        return "redirect:/aplicacoes";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        aplicacaoRepository.deleteById(id);
        return "redirect:/aplicacoes";
    }
}