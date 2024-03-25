import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public final class LeituraRetorno {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static Function<String[], Boleto> procesarLinhaArquivo(URI nomeArquivo){
        if (nomeArquivo.toString().contains("bradesco"))
            return LeituraRetorno::processarLinhaBradesco;
        else if (nomeArquivo.toString().contains("banco-brasil"))
            return LeituraRetorno::processarLinhaBancoBrasil;
//        else if (nomeArquivo.toString().contains("itau"))
//            return LeituraRetorno::processarLinhaItau;

        throw new UnsupportedOperationException("Banco não implementado");
    }

//
//    public static  Boleto processarLinhaItau(String[] vetor){
//Boleto boleto = new Boleto();
//boleto.setId(Integer.parseInt());
//
//    }

    public static Boleto processarLinhaBancoBrasil(String[] vetor) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(vetor[1]);
        //end::method-start[]  

        boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0, 0));

        //tag::method-end[]  
        boleto.setCpfCliente(vetor[4]);
        boleto.setValor(Double.parseDouble(vetor[5]));
        boleto.setMulta(Double.parseDouble(vetor[6]));
        boleto.setJuros(Double.parseDouble(vetor[7]));
        return boleto;
    }

    public static Boleto processarLinhaBradesco(String[] vetor) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(vetor[1]);
        //end::method-start[]

        boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
        boleto.setDataPagamento(LocalDateTime.parse(vetor[5], FORMATO_DATA_HORA));

        boleto.setCpfCliente(vetor[6]);
        boleto.setValor(Double.parseDouble(vetor[7]));
        boleto.setMulta(Double.parseDouble(vetor[8]));
        boleto.setJuros(Double.parseDouble(vetor[9]));

        return boleto;
    }


}
//end::method-end[]  
