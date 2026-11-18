package com.agro.capataztech.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    @NotNull(message = "O animal é obrigatório")
    private Animal animal;

    @NotBlank(message = "O nome do comprador é obrigatório")
    private String comprador;

    private LocalDate dataVenda;

    private Double valor;

    private Integer idadeMeses;
}