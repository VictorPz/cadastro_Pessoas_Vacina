package com.vacina.controledevacinas.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeVacina;
    private String emailPessoa;
    private LocalDate date = LocalDate.now();

    @Deprecated
    public Vacina() {
    }

    public Vacina(String nomeVacina, String emailPessoa) {
        this.nomeVacina = nomeVacina;
        this.emailPessoa = emailPessoa;
    }

    public Long getId() {
        return id;
    }
}
