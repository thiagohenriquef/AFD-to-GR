package projeto1teoria;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author thiago
 */
public class TelaPrincipal {
    String pastaPrincipal = "src\\Arquivos\\afd.txt";
    String nomeArq;
    Scanner entrada = new Scanner(System.in);
    Arquivo arq = new Arquivo();
    
    public TelaPrincipal() {
        System.out.print("Digite o nome do arquivo de entrada a ser lido: "+pastaPrincipal);
        nomeArq = entrada.nextLine();
        String nome  = arq.lerArquivo(pastaPrincipal+nomeArq);
        System.out.println(nome);
        
        
        System.out.print("Digite o nome do arquivo de entrada a ser a ser gravado: "+pastaPrincipal);
        nomeArq = entrada.nextLine();
        arq.escreveArquivo(pastaPrincipal+nomeArq);
    }
    
}
