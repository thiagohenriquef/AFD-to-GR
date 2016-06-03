package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class Automato {
    private ArrayList<Estado> estado;
    private ArrayList<Transicao> transicao;

    public Automato(ArrayList<Estado> estado, ArrayList<Transicao> transicao) {
        this.estado = estado;
        this.transicao = transicao;
    }

    public ArrayList<Estado> getEstado() {
        return estado;
    }

    public void setEstado(ArrayList<Estado> estado) {
        this.estado = estado;
    }

    public ArrayList<Transicao> getTransicao() {
        return transicao;
    }

    public void setTransicao(ArrayList<Transicao> transicao) {
        this.transicao = transicao;
    }
    
}
