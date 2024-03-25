package com.example.boleto;


import java.time.LocalDate;
import java.time.LocalDateTime;

import io.github.thibaultmeyer.cuid.CUID;
import lombok.Data;

@Data()
public class Boleto {
  private   CUID id;
  private  String codBanco;
  private  LocalDate dataVencimento;
  private  LocalDateTime dataPagamento;
  private String cpfCliente;
  private double valor;
  private double multa;
  private double juros;
  private String agencia;
  private String contaBancaria;


  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(String.format("ID: %s Banco: %3s", id, codBanco));
      if(agencia != null && !agencia.isEmpty() && contaBancaria != null && !contaBancaria.isEmpty())
          sb.append(String.format(" Ag.: %6s CC: %10s", agencia, contaBancaria));
      sb.append(String.format(" Venc.: %s Pag.: %s Valor: %10.2f",
              ProcessoBoleto.FORMATO_DATA.format(dataVencimento),
              ProcessoBoleto.FORMATO_DATA_HORA.format(dataPagamento), valor));
      if(multa > 0)
          sb.append(String.format(" Multa: %10.2f", multa));
      if(juros > 0)
          sb.append(String.format(" Juros: %10.2f", juros));
      return sb.toString();
  }
  
}
