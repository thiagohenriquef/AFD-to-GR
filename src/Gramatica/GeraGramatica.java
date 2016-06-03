package Gramatica;

import Automato.GeraAutomato;
import Modelo.Automato;
import Modelo.Estado;
import Modelo.Transicao;
import java.util.ArrayList;
import java.util.List;
import projeto1teoria.Arquivo;

/**
 *
 * @author Thiago
 */
public class GeraGramatica {
    String valores = "GR\t#tipo de formalismo" ;
    Arquivo arq = new Arquivo();
    GeraAutomato gerAut = new GeraAutomato();
    String S;
    int contador = 0;
    public GeraGramatica() {
    }
    
    public void CriaGramatica(Automato aut, String dir, int simbolos){
        String file = dir+"grteste.txt";
        /*for(Transicao tran : aut.getTransicao()){
            System.out.println(tran.getOrigem().getName()+"\t"+tran.getSimbolo()+"\t"+tran.getDestino().getName());
        }*/
        arq.escreveArquivo(file, valores);
        
        String estadoInicial = estadoInicial(aut);
        String estadoFinal = estadoFinal(aut);
        int contaSimbolos = simbolos;
        
        arq.escreveArquivo(file, aut.getEstado().size()+"\t#Numero de variaveis");
        arq.escreveArquivo(file, contaSimbolos+"\t#Numero de simbolos terminais");
        
        contador = 0;
        for(int i = 0; i < aut.getTransicao().size(); i++){
            if(aut.getTransicao().get(i).getOrigem().getName().equals("q"+i)){
                contador++;
            }
        }
        
        
        
        //System.out.println(contador);
        
        //checa se é estado final e incrementa uma palavra vazia na string
        for(Estado est: aut.getEstado()){
            if(est.isEstadoFinal()){
                valores += "&";
            }
        }
    }
    
    public String estadoInicial(Automato aut){
       contador = 0;
       while(contador<aut.getEstado().size()){
            if(aut.getEstado().get(contador).isEstadoInicial()){
                S = aut.getEstado().get(contador).getName();
            }
            contador++;
        } 
       return S;
    }
    
    public String estadoFinal(Automato aut){
       contador = 0;
       while(contador<aut.getEstado().size()){
            if(aut.getEstado().get(contador).isEstadoFinal()){
                S = aut.getEstado().get(contador).getName();
            }
            contador++;
        } 
       return S;
    }     
}
