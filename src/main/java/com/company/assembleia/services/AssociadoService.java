package com.company.assembleia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.assembleia.entities.Associado;
import com.company.assembleia.repositories.AssociadoRepository;

@Service
public class AssociadoService {
    private final AssociadoRepository associadoRepository;

    @Autowired
    public AssociadoService(AssociadoRepository associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    public Associado cadastrarAssociado(Associado associado) {
        return associadoRepository.save(associado);
    }

    public List<Associado> listarAssociados() {
        return associadoRepository.findAll();
    }

    public Associado obterAssociadoPorId(Long associadoId) {
        Optional<Associado> associadoOptional = associadoRepository.findById(associadoId);
        return associadoOptional.orElseThrow(() -> new IllegalArgumentException("Associado não encontrado"));
    }

    public void excluirAssociado(Long associadoId) {
        associadoRepository.deleteById(associadoId);
    }
}

