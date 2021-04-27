package com.vacina.controledevacinas.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDate nascimento;
    private String cpf;
    private String estado;
    private String cidade;

    @OneToMany(mappedBy = "pessoa")
    List<Vacina> vacinas;


    @Deprecated
    public Pessoa() {
    }

    public Pessoa(String name, String email, LocalDate nascimento, String cpf, String estado, String cidade) {
        this.name = name;
        this.email = email;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.estado = estado;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }
}
