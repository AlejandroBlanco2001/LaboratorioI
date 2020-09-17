/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.io.Serializable;

/**
 * Clase que abstrae la idea de Compañia
 * @author alexz
 */
public class Compañia implements Serializable{
    
    private String name;
    private String catchPhrase;
    private String bs; 

    /**
     * Constructor publico de la clase 
     * @param name Nombre de la Compañia
     * @param catchPhrase Slogan de la Compañia
     * @param bs BS de la Compañia
     */
    public Compañia(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    /**
     * Metodo que se encarga de devolver el nombre de la Compañia
     * @return name Nombre de la Compañia
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que se encarga de devolver el Slogan de la Compañia
     * @return catchPhrase Slogan de la Compañia
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     * Metodo que se encarga de devolver el BS de la Compañia
     * @return bs BS de la Compañia
     */
    public String getBs() {
        return bs;
    }
    
    
}
