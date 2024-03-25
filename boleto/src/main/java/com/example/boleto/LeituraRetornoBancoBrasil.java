package com.example.boleto;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import io.github.thibaultmeyer.cuid.CUID;

public  class LeituraRetornoBancoBrasil {

    protected static Boleto criarBoleto(String linha) {
        String[] vetor = linha.split(";");
        var boleto = new Boleto();
        boleto.setId(CUID.randomCUID1());
        boleto.setCodBanco(vetor[1]);

        boleto.setDataVencimento(LocalDate.parse(vetor[2], ProcessoBoleto.FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetor[3], ProcessoBoleto.FORMATO_DATA).atTime(0, 0, 0));
        boleto.setCpfCliente(vetor[4]);
        boleto.setValor(Double.parseDouble(vetor[5]));
        boleto.setMulta(Double.parseDouble(vetor[6]));
        boleto.setJuros(Double.parseDouble(vetor[7]));

        return boleto;
    }



}
