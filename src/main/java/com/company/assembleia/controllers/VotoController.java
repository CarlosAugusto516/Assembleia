package com.company.assembleia.controllers;

import com.company.assembleia.entities.Voto;
import com.company.assembleia.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/votos")
public class VotoController {

    private final VotoService votoService;

    @Autowired
    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @GetMapping
    public ResponseEntity<List<Voto>> getAllVotos() {
        List<Voto> votos = votoService.getAllVotos();
        return ResponseEntity.ok(votos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voto> getVotoById(@PathVariable Long id) {
        Optional<Voto> voto = votoService.getVotoById(id);
        return voto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Voto> saveVoto(@RequestBody Voto voto) {
        Voto savedVoto = votoService.saveVoto(voto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVoto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoto(@PathVariable Long id) {
        votoService.deleteVoto(id);
        return ResponseEntity.noContent().build();
    }
}
