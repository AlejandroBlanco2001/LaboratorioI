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
public class User {
    private final int ID;
    private String username;
    private String email;
    private Persona persona;

    public User(int ID, String username, String email, Persona persona) {
        this.ID = ID;
        this.username = username;
        this.email = email;
        this.persona = persona;
    }   
}
