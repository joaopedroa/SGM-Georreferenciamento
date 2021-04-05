package br.com.bomdestino.sgm.georreferenciamento.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "info_municipios")
public class InformacoesMunicipios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long populacaoEstimada;

	private Long populacaoUltimoCenso;
	
	private Long densidadeDemografica;
	
	private Long municipioId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPopulacaoEstimada() {
		return populacaoEstimada;
	}

	public void setPopulacaoEstimada(Long populacaoEstimada) {
		this.populacaoEstimada = populacaoEstimada;
	}

	public Long getPopulacaoUltimoCenso() {
		return populacaoUltimoCenso;
	}

	public void setPopulacaoUltimoCenso(Long populacaoUltimoCenso) {
		this.populacaoUltimoCenso = populacaoUltimoCenso;
	}

	public Long getDensidadeDemografica() {
		return densidadeDemografica;
	}

	public void setDensidadeDemografica(Long densidadeDemografica) {
		this.densidadeDemografica = densidadeDemografica;
	}

	public Long getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Long municipioId) {
		this.municipioId = municipioId;
	}

	
}
