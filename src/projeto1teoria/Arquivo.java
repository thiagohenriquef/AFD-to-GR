package projeto1teoria;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author thiago
 */
public class Arquivo {
    ArrayList<String> afd = new ArrayList();
    Scanner entrada = new Scanner(System.in);
    
    public Arquivo() {
    }
    
    public ArrayList lerArquivo(String nomeArq){
        try { 
            Scanner entrada = new Scanner(new FileReader(nomeArq));
            
            while(entrada.hasNextLine()){
                afd.add(entrada.nextLine());
            }
            return afd;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    
    public void escreveArquivo(String nomeArq, ArrayList array){
        try{
            FileWriter arq = new FileWriter(nomeArq, true);
            PrintWriter gravarArq = new PrintWriter(arq);
            
            for(int i = 0; i< array.size(); i++){
                gravarArq.println(array.get(i));
            }
            arq.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void escreveArquivo(String nomeArq, String nome){
        try{
            FileWriter arq = new FileWriter(nomeArq, true);
            PrintWriter gravarArq = new PrintWriter(arq);
            
            gravarArq.println(nome);
            
            arq.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
      
}
