package com.company.assembleia.services;

import com.company.assembleia.entities.Voto;
import com.company.assembleia.repositories.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotoService {

    private final VotoRepository votoRepository;

    @Autowired
    public VotoService(VotoRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    public List<Voto> getAllVotos() {
        return votoRepository.findAll();
    }

    public Optional<Voto> getVotoById(Long id) {
        return votoRepository.findById(id);
    }

    public Voto saveVoto(Voto voto) {
        return votoRepository.save(voto);
    }

    public void deleteVoto(Long id) {
        votoRepository.deleteById(id);
    }
}
