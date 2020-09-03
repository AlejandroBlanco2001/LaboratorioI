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
public class Persona {
    
    private String name;
    private String phone;
    private String website;
    private Direccion adress;
    private Compañia company;

    public Persona(String name, String phone, String website, Direccion adress, Compañia company) {
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.adress = adress;
        this.company = company;
    }
}
