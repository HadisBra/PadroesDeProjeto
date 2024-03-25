import java.net.URI;
import java.net.URISyntaxException;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {

        System.out.println("Bradesco");
        URI arq = Principal.class.getResource("bradesco-1.csv").toURI();
        var processador = new ProcessadorBoletos(LeituraRetorno.procesarLinhaArquivo(arq));
        processador.processar(arq);
        System.out.println("Banco do Brasil");
        URI arq1 = Principal.class.getResource("banco-brasil-1.csv").toURI();
        processador = new ProcessadorBoletos(LeituraRetorno.procesarLinhaArquivo(arq1));
        processador.processar(arq1);


    }
}
