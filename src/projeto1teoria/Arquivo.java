package projeto1teoria;

import Modelo.Automato;
import Modelo.Gramatica;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

    public String lerFormalismo(Scanner entrada) {
        try {
            while (true) {
                String x = entrada.nextLine();
                if (x.charAt(0) == '#') {
                    continue;
                } else {
                    String ent = x;
                    String[] partes = ent.split(" ");
                    return partes[0];
                }
            }
        } catch (Exception e) {
            String x = null;
            return x;
        }
    }

    public ArrayList<Automato> leAutomato(Scanner entrada) {
        ArrayList<Automato> tra = new ArrayList<>();
        String x = "";
        x = entrada.nextLine();
        while (true) {
            if (Character.isDigit(x.charAt(0))) {
                break;
            } else {
                x = entrada.nextLine();
            }
        }
        int quantEst = Integer.parseInt("" + x.charAt(0));

        x = entrada.nextLine();
        while (true) {
            if (Character.isDigit(x.charAt(0))) {
                break;
            } else {
                x = entrada.nextLine();
            }
        }
        int quantTer = Integer.parseInt("" + x.charAt(0));

        for (int i = 0; i < quantEst; i++) {
            char a = 'a';

            for (int j = 0; j < quantTer; j++) {
                String ent = "";
                while (true) {
                    x = entrada.nextLine();
                    if (x.charAt(0) == '#') {
                        continue;
                    } else {
                        break;
                    }
                }

                String[] partes = x.split(" ");
                ent = partes[0];

                Automato t = new Automato("" + i, ent, "" + a);
                tra.add(t);
                a++;
            }
        }

        return tra;
    }

    public ArrayList<Automato> leEstadoInicialeFinal(Scanner entrada, ArrayList<Automato> tra) {
        String x = "";
        x = entrada.nextLine();
        while (true) {
            if (Character.isDigit(x.charAt(0))) {
                break;
            } else {
                x = entrada.nextLine();
            }
        }
        for (int i = 0; i < tra.size(); i++) {
            x = "" + x.charAt(0);
            if (x.equals(tra.get(i).getOrigem())) {
                tra.get(i).setEstadoInicial(true);
            }
        }

        while (entrada.hasNextLine()) {
            try {
                while (true) {
                    x = entrada.nextLine();
                    if (x.charAt(0) == '#') {
                        continue;
                    }

                    int count = Integer.parseInt("" + x.charAt(0));
                    x = "" + entrada.nextLine().charAt(0);
                    for (int j = 0; j < count; j++) {
                        for (int i = 0; i < tra.size(); i++) {
                            if (tra.get(i).getOrigem().equals(x)) {
                                tra.get(i).setEstadoFinal(true);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                break;
            }
        }
        return tra;
    }

    public void gravaArquivo(ArrayList<Gramatica> gra) {
        try {
            FileWriter file = new FileWriter("afd_gr.txt", false);
            PrintWriter arq = new PrintWriter(file);

            arq.printf("GR \t#Tipo de formalismo\n");

            int j = TelaPrincipal.alfabeto.indexOf(gra.get(gra.size() - 1).getLadoEsq());
            j++;
            arq.printf(j + "\t#Quantidade de variavies\n");

            ArrayList<String> quant = new ArrayList<String>();
            for (j = 0; j < gra.size(); j++) {
                String x = "" + gra.get(j).getLadoDir().charAt(0);
                if (x.equals("&")) {
                    continue;
                }
                quant.add(x);
            }
            List repetidos = new ArrayList(new HashSet(quant));
            int n = repetidos.size()-1;
            arq.printf(n+"\tNumero de símbolos terminais sem palavra vazia\n");
            
            for(j=0; j<gra.size(); j++){
                arq.printf(gra.get(j).getLadoEsq()+"\tVariável\n");
                arq.printf(gra.get(j).getLadoDir()+"\tProdução da variavel acima\n");
            }
            arq.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex);
        }
    }

}
