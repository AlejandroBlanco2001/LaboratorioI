/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.util.LinkedList;

/**
 *
 * @author alexz
 */
public class User {
    private final int ID;
    private String username;
    private String email;
    private Persona persona;

    private User(int ID, String username, String email) {
        this.ID = ID;
        this.username = username;
        this.email = email;
    }   
    
    
    public static User createUser(int id, String username, String email){
        return new User(id,username,email);
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void addPersona(LinkedList<String> info) {
        this.persona = new Persona(info.get(1),info.get(10),info.get(11));
        this.persona.setAdress(info.get(4),info.get(5),info.get(6),info.get(7),info);
    }

    
    
}
