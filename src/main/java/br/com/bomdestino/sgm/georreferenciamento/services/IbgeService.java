package br.com.bomdestino.sgm.georreferenciamento.services;

import java.util.List;

import br.com.bomdestino.sgm.georreferenciamento.models.Estado;
import br.com.bomdestino.sgm.georreferenciamento.models.Municipio;

public interface IbgeService {

	List<Municipio> getMunicipiosPorUF(String uf);

	List<Estado> getTodosEstados();

	String getMalhaPorMunicipio(Long idMunicipio);
}
