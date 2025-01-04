import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        BuscadorDeCep consultaCep = new BuscadorDeCep();

        System.out.println("Digite o número do CEP a ser consultado: ");
        var cep = teclado.nextLine();

        try {
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.geraArquivoJson(novoEndereco);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
