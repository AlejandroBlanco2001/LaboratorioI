/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author alexz
 */
public class Direccion {
    
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Coordenadas coordenada;

    public Direccion(String street, String suite, String city, String zipcode, Coordenadas coordenada) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.coordenada = coordenada;
    }
    
    
}
