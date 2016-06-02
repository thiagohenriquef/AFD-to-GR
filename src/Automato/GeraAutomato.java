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
    Automato aut = new Automato();
    static ArrayList<Estado> est = new ArrayList();
    static ArrayList<Transicao> trans = new ArrayList();
    static String nome;
    static Estado nulo = new Estado("ind", false);
    
    public GeraAutomato() {
    }
    
    public static ArrayList<Transicao> leitura(ArrayList<String> array){
        //System.out.println(array.get(0));
        boolean valor = false;
        
        int numEstados = Integer.parseInt(array.get(1));
        int numTerminais = Integer.parseInt(array.get(2));
        
        //System.out.println(array.get(1));
        //System.out.println(array.get(2));
        
        int contador = 3;
        
        for(int count = 0; count < numEstados; count++){
            int ultimo = Integer.parseInt(array.get(array.size()-1));
            if(count==ultimo){
                    valor = true;
            }
            Estado e = new Estado("q"+count, valor);
            est.add(e);
            //System.out.println(e.getName());
            //System.out.print(e.isEstadoFinal());
 
        }
        
        for(int i=0; i<numEstados; i++){               
            for(int j=0; j<numTerminais; j++){
                int value = Integer.parseInt(array.get(contador));            
                
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
                
                if(value==-1){
                    Transicao t = new Transicao(est.get(i), GeraAutomato.nulo, nome);
                    trans.add(t);
                }
                else{    
                    Transicao t = new Transicao(est.get(i), est.get(value), nome);
                    trans.add(t);
                }
                
                contador++;
            }
        }
        
        for(Transicao arr : trans){
            System.out.println(arr.getOrigem().getName()+"   "+arr.getDestino().getName()+"    "+arr.getSimbolo());
        }
        
        return trans;
    }
}
