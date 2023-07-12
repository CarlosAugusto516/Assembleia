package com.company.assembleia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.assembleia.entities.Associado;
import com.company.assembleia.services.AssociadoService;

@RestController
@RequestMapping("/associados")
public class AssociadoController {
    private final AssociadoService associadoService;

    @Autowired
    public AssociadoController(AssociadoService associadoService) {
        this.associadoService = associadoService;
    }

    @PostMapping
    public ResponseEntity<Associado> cadastrarAssociado(@RequestBody Associado associado) {
        Associado novoAssociado = associadoService.cadastrarAssociado(associado);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAssociado);
    }

    @GetMapping
    public ResponseEntity<List<Associado>> listarAssociados() {
        List<Associado> associados = associadoService.listarAssociados();
        return ResponseEntity.ok(associados);
    }

    @GetMapping("/{associadoId}")
    public ResponseEntity<Associado> obterAssociadoPorId(@PathVariable Long associadoId) {
        Associado associado = associadoService.obterAssociadoPorId(associadoId);
        return ResponseEntity.ok(associado);
    }

    @DeleteMapping("/{associadoId}")
    public ResponseEntity<Void> excluirAssociado(@PathVariable Long associadoId) {
        associadoService.excluirAssociado(associadoId);
        return ResponseEntity.noContent().build();
    }
}

