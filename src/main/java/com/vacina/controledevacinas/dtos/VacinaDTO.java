package com.vacina.controledevacinas.dtos;

import com.vacina.controledevacinas.common.UniqueValue;
import com.vacina.controledevacinas.entities.Vacina;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class VacinaDTO {

    @NotBlank
    private String nomeVacina;
    @UniqueValue(domainClass = Vacina.class, fieldName = "emailPessoa")
    @NotBlank
    @Email
    private String emailPessoa;

    public Vacina toEntity() {
        return new Vacina(this.nomeVacina, this.emailPessoa);
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }
}
