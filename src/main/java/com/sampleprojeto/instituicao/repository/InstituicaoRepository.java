package com.sampleprojeto.instituicao.repository;

import com.sampleprojeto.instituicao.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstituicaoRepository extends JpaRepository<Instituicao, UUID> {
}
