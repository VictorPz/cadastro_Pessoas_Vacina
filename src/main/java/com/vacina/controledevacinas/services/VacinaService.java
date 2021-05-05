package com.vacina.controledevacinas.services;

import com.vacina.controledevacinas.dtos.VacinaResponseDTO;
import com.vacina.controledevacinas.entities.Vacina;
import com.vacina.controledevacinas.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VacinaService {

    @Autowired
    VacinaRepository vacinaRepository;

    public List<Vacina> vacinaPorPessoa(Long idPessoa) {
        return vacinaRepository.findByPessoaId(idPessoa);
    }

    public List<VacinaResponseDTO> listaVacinaResposeDTO(List<Vacina> vacinas) {
        return vacinas
                .stream()
                .map(Vacina::toResponse)
                .collect(Collectors.toList());
    }
}
