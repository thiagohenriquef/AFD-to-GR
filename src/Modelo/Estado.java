package Modelo;

/**
 *
 * @author Thiago
 */
public class Estado {
    private String name;
    private boolean estadoFinal;
    private boolean estadoInicial;

    public Estado(String name, boolean estadoInicial, boolean estadoFinal) {
        this.name = name;
        this.estadoFinal = estadoFinal;
        this.estadoInicial = estadoInicial;
    }

    public Estado() {
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(boolean estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public boolean isEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(boolean estadoInicial) {
        this.estadoInicial = estadoInicial;
    }
    
    
}
