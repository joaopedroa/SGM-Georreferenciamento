package br.com.bomdestino.sgm.georreferenciamento.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bomdestino.sgm.georreferenciamento.models.InformacoesMunicipios;

@Repository
public interface InformacoesLocalidadesRepository extends JpaRepository<InformacoesMunicipios, Long> {

	InformacoesMunicipios findByMunicipioId(Long idMunicipio);
}
