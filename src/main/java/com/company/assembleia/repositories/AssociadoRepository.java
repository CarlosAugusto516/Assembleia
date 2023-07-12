package com.company.assembleia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.assembleia.entities.Associado;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

}
