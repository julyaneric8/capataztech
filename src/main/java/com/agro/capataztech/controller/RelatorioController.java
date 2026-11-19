package com.agro.capataztech.controller;

import com.agro.capataztech.model.Venda;
import com.agro.capataztech.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RelatorioController {

    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping("/relatorios")
    public String relatorio(Model model) {
        List<Venda> vendas = vendaRepository.findAll();

        Double faturamentoTotal = vendas.stream()
                .mapToDouble(Venda::getValor)
                .sum();

        model.addAttribute("vendas", vendas);
        model.addAttribute("faturamentoTotal", faturamentoTotal);

        return "relatorios/financeiro";
    }
}