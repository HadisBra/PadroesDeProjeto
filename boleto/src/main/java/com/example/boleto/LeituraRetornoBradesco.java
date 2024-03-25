package com.example.boleto;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import io.github.thibaultmeyer.cuid.CUID;


public class LeituraRetornoBradesco{

//  public List<Boleto> lerArquivo(final URI camihoArquivo) {
//
//    try {
//      return Files.lines(Paths.get(camihoArquivo)).map(this::criarBoleto)
//          .collect(Collectors.toList());
//
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    return null;
//  }

  protected static Boleto criarBoleto(String linha) {
    String[] vetor = linha.split(";");
    var boleto = new Boleto();
    boleto.setId(CUID.randomCUID1());
    boleto.setCodBanco(vetor[1]);
    boleto.setAgencia(vetor[2]);
    boleto.setContaBancaria(vetor[3]);

    boleto.setDataVencimento(LocalDate.parse(vetor[4], ProcessoBoleto.FORMATO_DATA));
    boleto.setDataPagamento(LocalDateTime.parse(vetor[5], ProcessoBoleto.FORMATO_DATA_HORA));

    boleto.setCpfCliente(vetor[6]);
    boleto.setValor(Double.parseDouble(vetor[7]));
    boleto.setMulta(Double.parseDouble(vetor[8]));
    boleto.setJuros(Double.parseDouble(vetor[9]));

    return boleto;
  }



}
