package com.company.assembleia.controllers;

import com.company.assembleia.entities.Pauta;
import com.company.assembleia.services.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pautas")
public class PautaController {

    private final PautaService pautaService;

    @Autowired
    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @GetMapping
    public ResponseEntity<List<Pauta>> getAllPautas() {
        List<Pauta> pautas = pautaService.getAllPautas();
        return ResponseEntity.ok(pautas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pauta> getPautaById(@PathVariable Long id) {
        Optional<Pauta> pauta = pautaService.getPautaById(id);
        return pauta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pauta> savePauta(@RequestBody Pauta pauta) {
        Pauta savedPauta = pautaService.savePauta(pauta);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPauta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePauta(@PathVariable Long id) {
        pautaService.deletePautaById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}/resultado")
    public ResponseEntity<String> obterResultadoPauta(@PathVariable Long id) {
        int resultado = pautaService.calcularResultadoPauta(id);
        String mensagem;

        if (resultado == 1) {
            mensagem = "Pauta aprovada";
        } else if (resultado == -1) {
            mensagem = "Pauta reprovada";
        } else {
            mensagem = "Empate";
        }

        return ResponseEntity.ok(mensagem);
    }

}
