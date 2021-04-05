package br.com.bomdestino.sgm.georreferenciamento.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bomdestino.sgm.georreferenciamento.models.InformacoesMunicipios;
import br.com.bomdestino.sgm.georreferenciamento.services.InformacoesLocalidadesService;

@RequestMapping("/info")
@RestController
public class InformacoesLocalidadesController {
	
	private final InformacoesLocalidadesService service;
	
	public InformacoesLocalidadesController(InformacoesLocalidadesService service) {
		this.service = service;
	}
	
	@PostMapping("/municipio")
	public ResponseEntity<Void> cadastrarInformacoesMunicipio(@RequestBody InformacoesMunicipios infos){
		this.service.cadastrarInformacoesMunicipio(infos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/municipio/{idMunicipio}")
	public ResponseEntity<InformacoesMunicipios> getInforPorMunicipio(@PathVariable Long idMunicipio){
		InformacoesMunicipios info = this.service.getInfoPorMunicipio(idMunicipio);
		return new ResponseEntity<InformacoesMunicipios>(info, HttpStatus.OK);
		
	}
	
	@GetMapping("/total")
	public ResponseEntity<Integer> getTotal(){
		return new ResponseEntity<Integer>(this.service.getTotalCadastrado(), HttpStatus.OK);
	}

}
