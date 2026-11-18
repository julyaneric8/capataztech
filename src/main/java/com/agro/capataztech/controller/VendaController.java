package com.agro.capataztech.controller;

import com.agro.capataztech.model.Animal;
import com.agro.capataztech.model.Venda;
import com.agro.capataztech.repository.AnimalRepository;
import com.agro.capataztech.repository.VendaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vendas", vendaRepository.findAll());
        return "vendas/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("venda", new Venda());
        model.addAttribute("animais", animalRepository.findAll().stream()
                .filter(a -> "Disponível".equals(a.getSituacao()))
                .toList());
        return "vendas/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("venda") Venda venda, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("animais", animalRepository.findAll().stream()
                    .filter(a -> "Disponível".equals(a.getSituacao()))
                    .toList());
            return "vendas/formulario";
        }

        Animal animal = venda.getAnimal();

        if (animal.getDataNascimento() != null) {
            long meses = ChronoUnit.MONTHS.between(animal.getDataNascimento(), LocalDate.now());
            venda.setIdadeMeses((int) meses);
        }

        if (venda.getValor() == null && animal.getPeso() != null) {
            venda.setValor(animal.getPeso() * 15.0);
        }

        if (venda.getDataVenda() == null) {
            venda.setDataVenda(LocalDate.now());
        }

        animal.setSituacao("Vendido");
        animalRepository.save(animal);

        vendaRepository.save(venda);
        return "redirect:/vendas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));

        Animal animal = venda.getAnimal();
        animal.setSituacao("Disponível");
        animalRepository.save(animal);

        vendaRepository.delete(venda);
        return "redirect:/vendas";
    }
}