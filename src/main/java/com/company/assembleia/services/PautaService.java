package com.company.assembleia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.assembleia.entities.Pauta;
import com.company.assembleia.entities.Voto;
import com.company.assembleia.repositories.PautaRepository;

import jakarta.persistence.OneToMany;

@Service
public class PautaService {

    private final PautaRepository pautaRepository;

    @Autowired
    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public List<Pauta> getAllPautas() {
        return pautaRepository.findAll();
    }

    public Optional<Pauta> getPautaById(Long id) {
        return pautaRepository.findById(id);
    }

    public Pauta savePauta(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    public void deletePautaById(Long id) {
        pautaRepository.deleteById(id);
    }
    
    public int calcularResultadoPauta(Long pautaId) {
        Optional<Pauta> pautaOptional = pautaRepository.findById(pautaId);
        if (pautaOptional.isPresent()) {
            Pauta pauta = pautaOptional.get();
            List<Voto> votos = pauta.getVotos();

            int totalSim = 0;
            int totalNao = 0;

            for (Voto voto : votos) {
                if (voto.getVotoOpcao() == Voto.VotoOpcao.SIM) {
                    totalSim++;
                } else if (voto.getVotoOpcao() == Voto.VotoOpcao.NAO) {
                    totalNao++;
                }
            }

            if (totalSim > totalNao) {
                return 1; // Pauta aprovada
            } else if (totalSim < totalNao) {
                return -1; // Pauta reprovada
            } else {
                return 0; // Empate
            }
        } else {
            throw new IllegalArgumentException("Pauta não encontrada");
        }
    }

}
