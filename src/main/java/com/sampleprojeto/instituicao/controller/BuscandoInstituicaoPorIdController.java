package com.sampleprojeto.instituicao.controller;

import com.sampleprojeto.instituicao.controller.dto.InstituicaoResponse;
import com.sampleprojeto.instituicao.model.Instituicao;
import com.sampleprojeto.instituicao.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/instituicoes"))
public class BuscandoInstituicaoPorIdController {

    @Autowired
    private InstituicaoRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<InstituicaoResponse> buscarPorId(@PathVariable String id){

        Optional<Instituicao> instituicao = repository.findById(id);

        InstituicaoResponse response =
                new InstituicaoResponse(instituicao.get().getId(), instituicao.get().getNome());

        return ResponseEntity.ok().body(response);
    }


}
