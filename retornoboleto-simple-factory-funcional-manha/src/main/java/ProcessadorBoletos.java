import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
//tag::class-start[] 
public class ProcessadorBoletos {
    private final Function<String[], Boleto> processarLinhaArquivo;

    public ProcessadorBoletos(Function<String[], Boleto> processarLinhaArquivo) {
        this.processarLinhaArquivo = processarLinhaArquivo;
    }

    public final List<Boleto> processar(URI arq){
        try {
            var listaLinhas = Files.readAllLines(Paths.get(arq));
            var boletos = new ArrayList<Boleto>();
            for (String linha : listaLinhas) {
                String[] vetor = linha.split(";");
                var boleto = processarLinhaArquivo.apply(vetor);
                boletos.add(boleto);
                System.out.println(boleto);
            }
            return boletos;
        }catch(IOException ex){
            throw new UncheckedIOException(ex);
        }
    }
}
