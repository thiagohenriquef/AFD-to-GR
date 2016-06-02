package projeto1teoria;

import java.io.*;
import sun.misc.IOUtils;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiago
 */
public class Arquivo {
    ArrayList<String> afd = new ArrayList();
    
    public Arquivo() {
    }
    
    public ArrayList lerArquivo(String nomeArq){
        try { 
            Scanner entrada = new Scanner(new FileReader(nomeArq));
            
            while(entrada.hasNextLine()){
                afd.add(entrada.nextLine());
            }
            
            return afd;
            /*for(String str : afd){
                System.out.println(str);
            }*/
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    /*public String lerArquivo(String nomeArq) {
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(nomeArq));
            String linha = "";
            
            while(true){
                if(linha != null){
                    System.out.println(linha);
                }else{
                    break;
                }
                
                linha = buffer.readLine();
                
                buffer.close();
                return linha;
            }
        }    
        catch(Exception e){
            System.err.println(e.getMessage());
            }
        return null;
    }*/
    
    
    public void escreveArquivo(String nomeArq){
        try{
            FileWriter arq = new FileWriter(nomeArq);
            PrintWriter gravarArq = new PrintWriter(arq);
            
            gravarArq.printf("Gravando no arquivo");
            
            
            arq.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
      
}
