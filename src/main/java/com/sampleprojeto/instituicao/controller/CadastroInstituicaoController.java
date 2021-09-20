package com.sampleprojeto.instituicao.controller;

import com.sampleprojeto.instituicao.controller.dto.InstituicaoRequest;
import com.sampleprojeto.instituicao.controller.dto.InstituicaoResponse;
import com.sampleprojeto.instituicao.model.Instituicao;
import com.sampleprojeto.instituicao.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(("/api/v1/instituicoes"))
public class CadastroInstituicaoController {

    @Autowired
    private InstituicaoRepository repository;


    @PostMapping
    public ResponseEntity<InstituicaoResponse> cadastrarInstituicao(@RequestBody @Valid InstituicaoRequest request){
        Instituicao instituicao = request.toModel();
        repository.save(instituicao);

        InstituicaoResponse response =
                new InstituicaoResponse(instituicao.getId(), instituicao.getNome());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(instituicao.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

}
