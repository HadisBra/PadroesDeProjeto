package com.example.boleto;

import lombok.Setter;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Setter
public  class ProcessoBoleto {
  public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

  private  Function<String, Boleto>  criarBoleto;

  public ProcessoBoleto(Function<String, Boleto> criarBoleto) {
    this.criarBoleto = criarBoleto;
  }


  public final void processar(URI nomeArquivo) {
    try {
      var boletos = Files.lines(Paths.get(nomeArquivo))
              .map(this.criarBoleto)
              .toList();
      boletos.forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


//protected abstract Boleto criarBoleto(String linha);





}
