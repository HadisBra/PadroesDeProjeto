package com.example.boleto;

import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoletoApplication {

	public static void main(String[] args) throws URISyntaxException {
		SpringApplication.run(BoletoApplication.class, args);
		final  var processarBoleto =
				new ProcessoBoleto(
						LeituraRetornoBancoBrasil :: criarBoleto);
		var caminhoArquivo = BoletoApplication.class.getResource("/banco-brasil-1.csv").toURI();
		System.out.println("Lendo o arquivo -> " + caminhoArquivo + " <-\n");
		processarBoleto.processar(caminhoArquivo);
		

		final var  processarBoletoBradesco =
				new ProcessoBoleto( LeituraRetornoBradesco :: criarBoleto);
		var caminhoBradesco = BoletoApplication.class.getResource("/bradesco-1.csv").toURI();

		System.out.println("\nLendo o arquivo -> " + caminhoBradesco + " <-\n");
		processarBoletoBradesco.processar(caminhoBradesco);
	}

}
