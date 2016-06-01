package projeto1teoria;

import java.io.*;
import sun.misc.IOUtils;

/**
 *
 * @author thiago
 */
public class Arquivo {

    public Arquivo() {
    }
    
    public String lerArquivo(String nomeArq) {
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(nomeArq));
            String linha = "";
            
            while(true){
                if(linha!=null){
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
    }
    
    
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
