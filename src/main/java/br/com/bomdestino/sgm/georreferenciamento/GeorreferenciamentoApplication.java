package br.com.bomdestino.sgm.georreferenciamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GeorreferenciamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeorreferenciamentoApplication.class, args);
	}

}
