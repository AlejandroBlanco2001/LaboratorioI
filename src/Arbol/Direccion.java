/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.io.Serializable;

/**
 *
 * @author alexz
 */
public class Direccion implements Serializable {
    
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Coordenada coordenada;

    public Direccion(String street, String suite, String city, String zipcode) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
    }

    void setGeo(float lat, float lng) {
        this.coordenada = new Coordenada(lat,lng);
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }
    
    
    
    
}
