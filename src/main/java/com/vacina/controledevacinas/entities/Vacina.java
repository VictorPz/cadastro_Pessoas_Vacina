package com.vacina.controledevacinas.entities;

import com.vacina.controledevacinas.dtos.VacinaResponseDTO;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeVacina;
    private String emailPessoa;
    private LocalDate date = LocalDate.now();

    @ManyToOne
    Pessoa pessoa;

    @Deprecated
    public Vacina() {
    }

    public Vacina(String nomeVacina, String emailPessoa, Pessoa pessoas, LocalDate date) {
        this.nomeVacina = nomeVacina;
        this.emailPessoa = emailPessoa;
        this.pessoa = pessoas;
        this.date = date;
    }

    public VacinaResponseDTO toResponse(){
        return new VacinaResponseDTO(nomeVacina, emailPessoa, date);
    }

    public Long getId() {
        return id;
    }
}
