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
public class Nodo {
    
    private LinkedList<Nodo> hijos;
    private Nodo LLink;
    private Nodo RLink;
    
    private User username;
    
    // Nodo N-Ario
    public Nodo(User username,Nodo... hijos){
        this.username = username;
        this.hijos = new LinkedList();
        for(Nodo h: hijos){
            if(h != null){
                this.hijos.add(h);
            }
        }
    }
    
    // Nodo Binario
    public Nodo(User username,Nodo LLink, Nodo RLink){
        this.username = username;
        this.LLink = LLink;
        this.RLink = RLink;
    }
}
