package com.vacina.controledevacinas.controllers;

import com.vacina.controledevacinas.entities.Pessoa;
import com.vacina.controledevacinas.dtos.PessoaDTO;
import com.vacina.controledevacinas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastroPessoa(@RequestBody @Valid PessoaDTO request, UriComponentsBuilder builder) {
        Pessoa pessoa = request.toEntity();
        pessoaRepository.save(pessoa);
        URI uri = builder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
