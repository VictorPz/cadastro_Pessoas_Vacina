package com.vacina.controledevacinas.controllers;

import com.vacina.controledevacinas.dtos.VacinaDTO;
import com.vacina.controledevacinas.dtos.VacinaResponseDTO;
import com.vacina.controledevacinas.entities.Vacina;
import com.vacina.controledevacinas.repositories.PessoaRepository;
import com.vacina.controledevacinas.repositories.VacinaRepository;
import com.vacina.controledevacinas.services.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {

    @Autowired
    VacinaService vacinaService;

    @Autowired
    private VacinaRepository vacinaRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

// Retona código 201
// O método Created no response Entity pede uma uri
    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastroPessoa(@RequestBody @Valid VacinaDTO request) {
        Vacina vacina = request.toEntity(pessoaRepository);
        vacinaRepository.save(vacina);
        return ResponseEntity.status(HttpStatus.CREATED).body(vacina.toResponse());
    }

    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<?> pessoasVacinadas(@PathVariable Long idPessoa) {
        List<Vacina> vacinas = vacinaService.vacinaPorPessoa(idPessoa);
        if (vacinas.isEmpty()) {
            return ResponseEntity.ok("A Pessoa não possui vacinas cadastradas");
        }
        List<VacinaResponseDTO> vacinasResponse = vacinaService.listaVacinaResposeDTO(vacinas);
        return ResponseEntity.ok(vacinasResponse);
    }

//    @PostMapping("/cadastro")
//    public String criarVacina(@RequestBody @Valid VacinaDTO request) {
//        Vacina vacina = request.toEntity();
//        vacinaRepository.save(vacina);
//        return "Cadastro Efetuado";
//    }
//  Retorna código 200

}
