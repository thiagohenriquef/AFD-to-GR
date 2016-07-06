package Modelo;

/**
 *
 * @author Thiago
 */
public class Automato {
    private String origem;
    private String destino;
    private String simbolo;
    private boolean estadoInicial;
    private boolean estadoFinal;

    public Automato(String ori, String des, String sim) {
        this.origem = ori;
        this.destino = des;
        this.simbolo = sim;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return origem + "-" + simbolo + "-" + destino +"("+estadoInicial+","+estadoFinal+")" ;
    }
    
        public boolean isEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(boolean estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public  boolean isEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(boolean estadoFinal) {
        this.estadoFinal = estadoFinal;
    }
    
}
