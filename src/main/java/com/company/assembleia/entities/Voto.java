package com.company.assembleia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_voto	")
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "associado_id")
	private Associado associado;
	
	@ManyToOne
	@JoinColumn(name = "pauta_id")
	private Pauta pauta;
	private VotoOpcao votoOpcao;

	
	

	public Voto(Long id, Associado associado, Pauta pauta, VotoOpcao votoOpcao) {
		this.id = id;
		this.associado = associado;
		this.pauta = pauta;
		this.votoOpcao = votoOpcao;
	}

	public Voto() {

	}
	
	public enum VotoOpcao {
	    SIM("Sim"),
	    NAO("Não");

	    private String descricao;

	    VotoOpcao(String descricao) {
	        this.descricao = descricao;
	    }

	    public String getDescricao() {
	        return descricao;
	    }
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public VotoOpcao getVotoOpcao() {
		return votoOpcao;
	}

	public void setVotoOpcao(VotoOpcao votoOpcao) {
		this.votoOpcao = votoOpcao;
	}
	
	

}
