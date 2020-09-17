/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.io.Serializable;

/**
 * Clase que abstrae la idea de la Direccion
 * @author alexz
 */


public class Direccion implements Serializable {
    
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Coordenada coordenada;

    /**
     * Constructor publico de Direccion
     * @param street Calle de la Direccion
     * @param suite Tipo de Suite de la Direccion
     * @param city Ciudad donde se encuetra la Direccion
     * @param zipcode Codigo postal que maneja dicha Direcion
     */
    public Direccion(String street, String suite, String city, String zipcode) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
    }

    /**
     * Se encarga de crear el Objeto {@link Coordenada} para una Direccion
     * @param lat Latitud de la Coordenada
     * @param lng Longitud de la Coordenada
     */
    public void setGeo(float lat, float lng) {
        this.coordenada = new Coordenada(lat,lng);
    }

    /**
     * Metodo que retorna la calle de la Direccion
     * @return street Calle de la Direccion
     */
    public String getStreet() {
        return street;
    }
 
    /**
     * Metodo que retorna la Suite de la Direccion
     * @return suite Suite de la Direccion
     */
    public String getSuite() {
        return suite;
    }

    /**
     * Metodo que retorna la ciudad de la Direccion
     * @return city Ciudad de la Direccion
     */
    public String getCity() {
        return city;
    }

    /**
     * Metodo que retorna el codigo postal de la Direccion
     * @return zipcode Codigo postal de la Direccion
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Metodo que retorna el objeto de tipo {@link Coordenada} de la Direccion
     * @return coordenada Coordenada de la Direccion
     */
    public Coordenada getCoordenada() {
        return coordenada;
    }
    
    
    
    
}
