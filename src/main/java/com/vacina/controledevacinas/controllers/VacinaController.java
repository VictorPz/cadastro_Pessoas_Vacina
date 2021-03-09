package com.vacina.controledevacinas.controllers;

import com.vacina.controledevacinas.dtos.PessoaDTO;
import com.vacina.controledevacinas.dtos.VacinaDTO;
import com.vacina.controledevacinas.entities.Pessoa;
import com.vacina.controledevacinas.entities.Vacina;
import com.vacina.controledevacinas.repositories.VacinaRepository;
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
@RequestMapping("/vacinas")
public class VacinaController {
    @Autowired
    private VacinaRepository vacinaRepository;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastroPessoa(@RequestBody @Valid VacinaDTO request, UriComponentsBuilder builder) {
        Vacina vacina = request.toEntity();
        vacinaRepository.save(vacina);
        URI uri = builder.path("/vacina/{id}").buildAndExpand(vacina.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
