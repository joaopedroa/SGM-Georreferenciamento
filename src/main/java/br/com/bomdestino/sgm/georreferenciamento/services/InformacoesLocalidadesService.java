package br.com.bomdestino.sgm.georreferenciamento.services;

import br.com.bomdestino.sgm.georreferenciamento.models.InformacoesMunicipios;

public interface InformacoesLocalidadesService {

	void cadastrarInformacoesMunicipio(InformacoesMunicipios infos);
	
	InformacoesMunicipios getInfoPorMunicipio(Long idMunicipio);
	
	Integer getTotalCadastrado();
}
