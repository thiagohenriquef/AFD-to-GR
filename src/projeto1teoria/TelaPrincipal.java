package projeto1teoria;

import Automato.*;
import Modelo.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author thiago
 */
public class TelaPrincipal {
    ArrayList<String> arquivo = new ArrayList();
    String pastaPrincipal = "src\\Arquivos\\";
    String nomeArq;
    Scanner entrada = new Scanner(System.in);
    Arquivo arq = new Arquivo();
    
    public TelaPrincipal() {
        System.out.print("Digite o nome do arquivo de entrada a ser lido: "+pastaPrincipal);
        nomeArq = entrada.nextLine();
        arquivo = arq.lerArquivo(pastaPrincipal+nomeArq);
        
        if(arquivo.get(0).equals("AFD")){
            //System.out.println("é um afd");
            GeraAutomato.leitura(arquivo);
        }
        if(arquivo.get(0).equals("GR")){
            System.out.println("é uma gr");
        }
        
        /*for(String str : arquivo){
                System.out.println(str);
            }
        
        System.out.print("Digite o nome do arquivo de entrada a ser a ser gravado: "+pastaPrincipal);
        nomeArq = entrada.nextLine();
        arq.escreveArquivo(pastaPrincipal+nomeArq, arquivo);
        */       
    }
    
}
