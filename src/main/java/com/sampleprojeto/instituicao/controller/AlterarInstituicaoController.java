package com.sampleprojeto.instituicao.controller;

import com.sampleprojeto.instituicao.controller.dto.InstituicaoRequest;
import com.sampleprojeto.instituicao.controller.dto.InstituicaoResponse;
import com.sampleprojeto.instituicao.model.Instituicao;
import com.sampleprojeto.instituicao.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/instituicoes"))
public class AlterarInstituicaoController {

    @Autowired
    private InstituicaoRepository repository;


    @PutMapping("/{id}")
    public ResponseEntity<InstituicaoResponse> alterarInstituicao
            (@PathVariable String id, @RequestBody InstituicaoRequest request){

        Optional<Instituicao> instituicao = repository.findById(id);

        updateData(instituicao.get(), request);

        repository.save(instituicao.get());

        return ResponseEntity.ok()
                .body(new InstituicaoResponse(
                        instituicao.get().getId(),
                        instituicao.get().getNome()));


    }


    public void updateData(Instituicao instituicaoAlterada, InstituicaoRequest request){

        instituicaoAlterada.setNome(request.getNome());
    }

}
