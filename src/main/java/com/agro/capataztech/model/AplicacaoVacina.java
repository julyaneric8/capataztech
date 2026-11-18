package com.agro.capataztech.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AplicacaoVacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    @NotNull(message = "O animal é obrigatório")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "vacina_id", nullable = false)
    @NotNull(message = "A vacina é obrigatória")
    private Vacina vacina;

    private LocalDate dataAplicacao;
    private LocalDate proximaDose;
}