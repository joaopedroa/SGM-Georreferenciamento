package br.com.bomdestino.sgm.georreferenciamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bomdestino.sgm.georreferenciamento.models.Estado;
import br.com.bomdestino.sgm.georreferenciamento.models.Municipio;
import br.com.bomdestino.sgm.georreferenciamento.services.IbgeService;

@RestController
@RequestMapping("/localidades")
public class LocalidadesController {

	private final IbgeService ibgeService;

	@Autowired
	public LocalidadesController(IbgeService ibgeService) {
		this.ibgeService = ibgeService;
	}

	@GetMapping("/municipios/{uf}")
	public ResponseEntity<List<Municipio>> getMunicipios(@PathVariable String uf) {
		List<Municipio> municipios = this.ibgeService.getMunicipiosPorUF(uf);
		return new ResponseEntity<List<Municipio>>(municipios, HttpStatus.OK);
	}

	@GetMapping("/estados")
	public ResponseEntity<List<Estado>> getEstados() {
		List<Estado> estados = ibgeService.getTodosEstados();
		return new ResponseEntity<List<Estado>>(estados, HttpStatus.OK);
	}

	@GetMapping("/malhas/municipios/{idMunicipio}")
	public ResponseEntity<String> getMalhaMunicipio(@PathVariable Long idMunicipio) {
		String malhaMunicipio = ibgeService.getMalhaPorMunicipio(idMunicipio);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf("image/svg+xml"));
		return new ResponseEntity<String>(malhaMunicipio, headers, HttpStatus.OK);
	}
	
	
}
