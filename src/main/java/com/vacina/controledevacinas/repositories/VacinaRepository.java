package com.vacina.controledevacinas.repositories;

import com.vacina.controledevacinas.entities.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    List<Vacina> findByPessoaId(Long pessoaId);
}
