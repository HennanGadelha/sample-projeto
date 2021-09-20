package com.sampleprojeto.instituicao.controller;

import com.sampleprojeto.instituicao.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/v1/instituicoes"))
public class DeletandoInstituicaoController {

    @Autowired
    private InstituicaoRepository repository;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletandoInstituicao(@PathVariable String id){


        repository.deleteById(id);
        return  ResponseEntity.ok().build();
    }

}
