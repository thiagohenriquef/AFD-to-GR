package Gramatica;

import Automato.GeraAutomato;
import Modelo.*;
import java.util.*;
import projeto1teoria.Arquivo;

/**
 *
 * @author Thiago
 */
public class GeraGramatica {
    String valores = "GR\t#tipo de formalismo" ;
    Arquivo arq = new Arquivo();
    GeraAutomato gerAut = new GeraAutomato();
    Gramatica gramatica = new Gramatica();
    String S;
    int contador = 0;
    ArrayList<String> array = new ArrayList();
    
    public GeraGramatica() {
    }
    
    public void CriaGramatica(Automato aut, String dir, int simbolos){
        String file = dir+"afd_para_gr.txt";
        int numTrans = aut.getTransicao().size();
        int numEst = aut.getEstado().size();
        ArrayList<String> varProducao = new ArrayList();
        ArrayList<String> varTerminal = new ArrayList();
        
        arq.escreveArquivo(file, valores);
        
        String estadoInicial = estadoInicial(aut);
        String estadoFinal = estadoFinal(aut);
        int contaSimbolos = simbolos;
        
        arq.escreveArquivo(file, numEst+"\t#Numero de variaveis");
        arq.escreveArquivo(file, contaSimbolos+"\t#Numero de simbolos terminais");
        
        for(Transicao t: aut.getTransicao()){
            String prod = t.getSimbolo()+t.getDestino().getName();
            
            if(t.getDestino().isEstadoInicial()){
                    varProducao.set(0, t.getSimbolo());
                    varProducao.add(t.getOrigem().getName()+"->"+prod);
                }
            else if(t.getDestino().getName().equals("ind")){
                varProducao.add(t.getOrigem().getName()+"->"+t.getSimbolo()+"%");
            }
            else if(t.getOrigem().isEstadoFinal()){
                varProducao.add(t.getOrigem().getName()+"->"+t.getSimbolo()+"&");
                
            }else{
                varTerminal.add(t.getSimbolo());
                varProducao.add(t.getOrigem().getName()+"->"+prod);
            }
            
            }
        
        arq.escreveArquivo(file, varTerminal, "#variaveis terminais");
        arq.escreveArquivo(file, varProducao, "#variaveis de producao");
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
