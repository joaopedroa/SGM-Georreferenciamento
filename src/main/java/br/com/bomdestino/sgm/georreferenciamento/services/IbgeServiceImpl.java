package br.com.bomdestino.sgm.georreferenciamento.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.bomdestino.sgm.georreferenciamento.exceptions.ServiceException;
import br.com.bomdestino.sgm.georreferenciamento.models.Estado;
import br.com.bomdestino.sgm.georreferenciamento.models.Municipio;

@Service
public class IbgeServiceImpl implements IbgeService {
	
	private final DependencyFactory dependencyFactory;
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public IbgeServiceImpl(DependencyFactory dependencyFactory,  RestTemplate restTemplate) {
		this.dependencyFactory = dependencyFactory;
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Municipio> getMunicipiosPorUF(String uf) {
		try {
			String url = this.dependencyFactory.getUrlIBGE() + "/v1/localidades/estados/" + uf + "/municipios";
			ParameterizedTypeReference<List<Municipio>> type = new ParameterizedTypeReference<List<Municipio>>() {};
			HttpEntity<Object> httpEntity = new HttpEntity<Object>(new HttpHeaders());
			ResponseEntity<List<Municipio>> response = this.restTemplate.exchange(url, HttpMethod.GET, httpEntity, type);
			return response.getBody();
		} catch (Exception e) {
			throw new ServiceException("Erro ao consultar municípios por UF", e);
		}
	}

	@Override
	public List<Estado> getTodosEstados() {
		try {
			String url = this.dependencyFactory.getUrlIBGE() + "/v1/localidades/estados";
			System.out.println(url);
			ParameterizedTypeReference<List<Estado>> type = new ParameterizedTypeReference<List<Estado>>() {};
			HttpEntity<Object> httpEntity = new HttpEntity<Object>(new HttpHeaders());
			ResponseEntity<List<Estado>> response = this.restTemplate.exchange(url, HttpMethod.GET, httpEntity, type);
			List<Estado> estados = response.getBody();
			Collections.sort(estados, new Comparator<Estado>() {
				@Override
				public int compare(Estado e1, Estado e2) {
					return e1.getNome().compareTo(e2.getNome());
				}
			});
			return estados;
		} catch (Exception e) {
			throw new ServiceException("Erro ao buscar todos os estados", e);
		}
	}

	@Override
	public String getMalhaPorMunicipio(Long idMunicipio) {
		try {
			String url = this.dependencyFactory.getUrlIBGE() + "/v3/malhas/municipios/" + idMunicipio;
			HttpEntity<Object> httpEntity = new HttpEntity<Object>(new HttpHeaders());
			ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
			return response.getBody();
		} catch (Exception e) {
			throw new ServiceException("Erro ao buscar malha pelo id do município", e);
		}
	}

}
