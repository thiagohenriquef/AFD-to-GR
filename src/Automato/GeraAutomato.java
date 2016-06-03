package Automato;

import Modelo.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class GeraAutomato {
    ArrayList<Estado> est = new ArrayList();
    ArrayList<Transicao> trans = new ArrayList();
    String nome;
    Estado nulo = new Estado("ind", false, false);
    private int quantSimbolos;
    
    public GeraAutomato() {
    }
    
    public Automato leitura(ArrayList<String> array){
        boolean valorIni = false;
        boolean valorFim = false;
        
        int numEstados = converteInteiro(array.get(1));
        int numTerminais = converteInteiro(array.get(2));
        
        int quantEstados = converteInteiro(array.get(array.size()-2));
        int vetorEstadosFinais[] = new int[quantEstados];
        
        int quant = 0;
        while(quant < quantEstados){
            String s = Character.toString(array.get(array.size()-1).charAt(quant));
            vetorEstadosFinais[quant] = converteInteiro(s);
            quant++;
        }
        
        int contador = 3;
        for(int count = 0; count < numEstados; count++){
            int ultimo = converteInteiro(array.get(array.size()-1));
            int primeiro = converteInteiro(array.get(array.size()-3));
            
            if(verificaFim(vetorEstadosFinais, count)){
                    valorFim = true;
            }
            if(count==primeiro){
                valorIni = true;
            }
            Estado e = new Estado(Integer.toString(count), valorIni, valorFim);
            est.add(e);
            
            valorFim = false;
            valorIni = false;
        }
        
        for(int i=0; i<numEstados; i++){               
            for(int j=0; j<numTerminais; j++){
                int value = converteInteiro(array.get(contador));          
                switch(j){
                    case 0:
                        nome = "a";
                        break;
                    case 1:
                        nome = "b";
                        break;
                    case 2:
                        nome = "c";
                        break;
                    case 3:
                        nome = "d";
                        break;
                    case 4:
                        nome = "e";
                        break;
                }
                
                this.setQuantSimbolos(j+1);
                
                if(value==-1){
                    Transicao t = new Transicao(est.get(i), this.nulo, nome);
                    trans.add(t);
                }
                else{    
                    Transicao t = new Transicao(est.get(i), est.get(value), nome);
                    trans.add(t);
                }
                contador++;
            }
        }
        
        Automato aut = new Automato(est, trans);
        return aut;
    }
    
    public static int converteInteiro(String palavra){
        int numero;
        numero = Integer.parseInt(palavra);
        return numero;
    }
    
    public static boolean verificaFim(int vetor[], int x){
        int i=0;
        while(i<vetor.length){
            if(x==vetor[i]){
                return true;
            }
            i++;
        }        
        return false;
    }

    public int getQuantSimbolos() {
        return quantSimbolos;
    }

    public void setQuantSimbolos(int quantSimbolos) {
        this.quantSimbolos = quantSimbolos;
    }
}
