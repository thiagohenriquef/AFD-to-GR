package projeto1teoria;

import Automato.*;
import Gramatica.GeraGramatica;
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
    Automato aut;
    String pastaPrincipal = "src\\Arquivos\\";
    String nomeArq;
    Scanner entrada = new Scanner(System.in);
    Arquivo arq = new Arquivo();
    GeraGramatica ger = new GeraGramatica();
    GeraAutomato gerAut = new GeraAutomato();
    
    public TelaPrincipal() {
        System.out.print("Digite o nome do arquivo de entrada a ser lido: "+pastaPrincipal);
        nomeArq = entrada.nextLine();
        arquivo = arq.lerArquivo(pastaPrincipal+nomeArq);
        
        if(arquivo.get(0).equals("AFD")){
            aut = gerAut.leitura(arquivo);
            int i = gerAut.getQuantSimbolos();
            ger.CriaGramatica(aut, pastaPrincipal, i);
            
        }
        if(arquivo.get(0).equals("GR")){
            //System.out.println("é uma gr");
        }
    }
    
}
