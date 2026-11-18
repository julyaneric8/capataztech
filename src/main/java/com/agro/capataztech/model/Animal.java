package com.agro.capataztech.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A identificação é obrigatória")
    @Column(unique = true)
    private String identificacao;

    private String nome;

    @NotBlank(message = "A raça é obrigatória")
    private String raca;

    private LocalDate dataNascimento;

    @Positive(message = "O peso deve ser maior que zero")
    private Double peso;

    private String situacao;
}