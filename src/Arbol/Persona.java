/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author alexz
 */
public class Persona implements Serializable {
    
    private String name;
    private String phone;
    private String website;
    private Direccion adress;
    private Compañia company;

    public Persona(String name, String phone, String website) {
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.adress = adress;
        this.company = company;
    }

    void setAdress(String street, String suite, String city, String zipcode,LinkedList<String> info) {
        this.adress = new Direccion(street,suite,city,zipcode);
        this.adress.setGeo(Float.parseFloat(info.get(8)),Float.parseFloat(info.get(9)));
        this.company = new Compañia(info.get(12),info.get(13),info.get(14));
    }
}
