package com.vacina.controledevacinas.dtos;

import com.vacina.controledevacinas.common.UniqueValue;
import com.vacina.controledevacinas.entities.Vacina;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class VacinaResponseDTO {

    @NotBlank
    private String nomeVacina;
    @UniqueValue(domainClass = Vacina.class, fieldName = "emailPessoa")
    @NotBlank
    @Email
    private String emailPessoa;

    public VacinaResponseDTO(String nomeVacina, String emailPessoa) {
        this.nomeVacina = nomeVacina;
        this.emailPessoa = emailPessoa;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }
    public String getEmailPessoa() {
        return emailPessoa;
    }
}
