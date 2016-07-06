package projeto1teoria;

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
    private static ArrayList<Gramatica> gra = new ArrayList<Gramatica>();
    private static ArrayList<Automato> tra = new ArrayList<Automato>();
    Arquivo arq = new Arquivo();
    GeraGramatica ger = new GeraGramatica();
    public static String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public TelaPrincipal(String[] arg) throws FileNotFoundException {
        Scanner entrada = new Scanner(new FileReader(arg[0]));
        
        String s = arq.lerFormalismo(entrada);
        if(s.equals("AFD")){
            tra = arq.leAutomato(entrada);
            tra = arq.leEstadoInicialeFinal(entrada, tra);
            
            gra = ger.CriaGramatica(tra);
            
            arq.gravaArquivo(gra);
            for(Gramatica g : gra){
                System.out.println(g);
            }
            /*for(Automato t : tra ){
                System.out.println(t);
            }*/
        }
        //System.out.println(s);
    
    }

    public static ArrayList<Automato> getTra() {
        return tra;
    }

    public static void setTra(ArrayList<Automato> tra) {
        TelaPrincipal.tra = tra;
    }
 
    
    public static ArrayList<Gramatica> getGra() {
        return gra;
    }

    public static void setGra(ArrayList<Gramatica> aGra) {
        gra = aGra;
    }
}
