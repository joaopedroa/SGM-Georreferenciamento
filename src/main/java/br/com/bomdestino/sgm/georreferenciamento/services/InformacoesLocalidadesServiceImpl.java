package br.com.bomdestino.sgm.georreferenciamento.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bomdestino.sgm.georreferenciamento.models.InformacoesMunicipios;
import br.com.bomdestino.sgm.georreferenciamento.repositorys.InformacoesLocalidadesRepository;

@Service
public class InformacoesLocalidadesServiceImpl implements InformacoesLocalidadesService {
	
	private final InformacoesLocalidadesRepository repository;
	
	public InformacoesLocalidadesServiceImpl(InformacoesLocalidadesRepository repository) {
		this.repository = repository;
	}

	@Override
	public void cadastrarInformacoesMunicipio(InformacoesMunicipios infos) {
		InformacoesMunicipios info = getInfoPorMunicipio(infos.getMunicipioId());
		if(info != null) {
			this.repository.delete(info);
		}
		this.repository.save(infos);
	}

	@Override
	public InformacoesMunicipios getInfoPorMunicipio(Long idMunicipio) {
		return this.repository.findByMunicipioId(idMunicipio);
	}

	@Override
	public Integer getTotalCadastrado() {
		List<InformacoesMunicipios> infos = this.repository.findAll();
		if(infos == null)
			return 0;
		
		return infos.size();
	}

}
