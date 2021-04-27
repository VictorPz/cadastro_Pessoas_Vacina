package com.vacina.controledevacinas.controllers;

import com.vacina.controledevacinas.dtos.PessoaDTO;
import com.vacina.controledevacinas.dtos.VacinaDTO;
import com.vacina.controledevacinas.entities.Pessoa;
import com.vacina.controledevacinas.entities.Vacina;
import com.vacina.controledevacinas.repositories.PessoaRepository;
import com.vacina.controledevacinas.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {
    @Autowired
    private VacinaRepository vacinaRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

// Retona código 201
// O método Created no response Entity pede uma uri
    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastroPessoa(@RequestBody @Valid VacinaDTO request, UriComponentsBuilder builder) {
        Vacina vacina = request.toEntity(pessoaRepository);
        vacinaRepository.save(vacina);
        URI uri = builder.path("/vacina/{id}").buildAndExpand(vacina.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<?> pessoasVacinadas(@PathVariable Long id) {
        return ResponseEntity.ok().body(vacinaRepository.findByPessoaId(id)
                .stream().map(Vacina::toResponse).collect(Collectors.toList()));
    }

//    @PostMapping("/cadastro")
//    public String criarVacina(@RequestBody @Valid VacinaDTO request) {
//        Vacina vacina = request.toEntity();
//        vacinaRepository.save(vacina);
//        return "Cadastro Efetuado";
//    }
//  Retorna código 200

}
