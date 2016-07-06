package Gramatica;

import Modelo.*;
import java.util.*;
import projeto1teoria.Arquivo;
import projeto1teoria.TelaPrincipal;

/**
 *
 * @author Thiago
 */
public class GeraGramatica {

    Gramatica gramatica = new Gramatica();

    public GeraGramatica() {
    }

    public ArrayList CriaGramatica(ArrayList<Automato> aut) {
        ArrayList<Gramatica> gra = new ArrayList<>();

        /*for(int i = 0; i<aut.size(); i++){
            if(aut.get(i).isEstadoInicial()){
                gra.add(new Gramatica(aut.get(i).getOrigem(), aut.get(i).getOrigem()));
            }
        }
        
         */
        for (int i = 0; i < aut.size(); i++) {
            String ladoEsq = "", ladoDir = "";
            
            if (aut.get(i).getDestino().equals("-1")) {
                ladoDir = aut.get(i).getSimbolo() + "%%";
                ladoEsq = TelaPrincipal.alfabeto.charAt(Integer.parseInt(aut.get(i).getOrigem())) + "";
                Gramatica g = new Gramatica(ladoEsq, ladoDir);
                if(gra.contains(g)){
                    gra.add(g);
                }
                else{
                    break;
                }
                
                gra.add(g);
                
            } 
            
            else {
                ladoDir = aut.get(i).getSimbolo() + TelaPrincipal.alfabeto.charAt(Integer.parseInt(aut.get(i).getDestino()));
                ladoEsq = TelaPrincipal.alfabeto.charAt(Integer.parseInt(aut.get(i).getOrigem())) + "";
                Gramatica g = new Gramatica(ladoEsq, ladoDir);
                gra.add(g);
            }
           
            
            if (aut.get(i).isEstadoFinal()) {
                ladoEsq = TelaPrincipal.alfabeto.charAt(Integer.parseInt(aut.get(i).getOrigem())) + "";
                ladoDir = "&%%";
                Gramatica g = new Gramatica(ladoEsq, ladoDir);
                if(!gra.contains(g)){
                    gra.add(g);
                }
                else{
                    break;
                }
            }
            

        }

        return gra;
    }
}
