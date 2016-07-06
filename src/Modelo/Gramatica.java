/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author thiago
 */
public class Gramatica {
    private String ladoEsq;
    private String ladoDir;

    public Gramatica() {
    }

    public Gramatica(String ladoEsq, String ladoDir) {
        this.ladoEsq = ladoEsq;
        this.ladoDir = ladoDir;
    }

    public String getLadoEsq() {
        return ladoEsq;
    }

    public void setLadoEsq(String ladoEsq) {
        this.ladoEsq = ladoEsq;
    }

    public String getLadoDir() {
        return ladoDir;
    }

    public void setLadoDir(String ladoDir) {
        this.ladoDir = ladoDir;
    }

    @Override
    public String toString() {
        return ladoEsq+"->"+ladoDir;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gramatica other = (Gramatica) obj;
        if (!Objects.equals(this.ladoEsq, other.ladoEsq)) {
            return false;
        }
        if (!Objects.equals(this.ladoDir, other.ladoDir)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
