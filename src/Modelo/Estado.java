package Modelo;

/**
 *
 * @author Thiago
 */
public class Estado {
    private String name;
    private boolean estadoFinal;

    public Estado(String name, boolean estadoFinal) {
        this.name = name;
        this.estadoFinal = estadoFinal;
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
}
