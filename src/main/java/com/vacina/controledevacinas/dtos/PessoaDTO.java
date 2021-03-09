package com.vacina.controledevacinas.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.vacina.controledevacinas.common.UniqueValue;
import com.vacina.controledevacinas.entities.Pessoa;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PessoaDTO {

    @NotBlank
    private String name;
    @UniqueValue(domainClass = Pessoa.class, fieldName = "email")
    @NotBlank
    @Email
    private String email;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate nascimento;

    @UniqueValue(domainClass = Pessoa.class, fieldName = "cpf")
    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private String estado;
    @NotBlank
    private String cidade;

    public Pessoa toEntity() {
        return new Pessoa(this.name, this.email, this.nascimento, this.cpf, this.estado, this.cidade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
