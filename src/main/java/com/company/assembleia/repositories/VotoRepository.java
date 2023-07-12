package com.company.assembleia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.assembleia.entities.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long>{
	


}
