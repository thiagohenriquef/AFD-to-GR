package Modelo;

/**
 *
 * @author Thiago
 */
public class Gramatica {
    private Producao producao;
    private Terminal terminal;
    private Variavel variavel;

    public Gramatica() {
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Variavel getVariavel() {
        return variavel;
    }

    public void setVariavel(Variavel variavel) {
        this.variavel = variavel;
    }
}
