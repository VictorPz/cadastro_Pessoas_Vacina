package com.vacina.controledevacinas.dtos;

import com.vacina.controledevacinas.entities.Pessoa;
import com.vacina.controledevacinas.entities.Vacina;
import com.vacina.controledevacinas.repositories.PessoaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VacinaDTO {

    @NotBlank
    private String nomeVacina;
    private String emailPessoa;
    @NotNull
    private Long pessoaId;
    private LocalDate date = LocalDate.now();

    public Vacina toEntity(PessoaRepository pessoaRepository) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).get();
        return new Vacina(this.nomeVacina, this.emailPessoa, pessoa, date);
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

    public Long getPessoaId(){
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }
}
