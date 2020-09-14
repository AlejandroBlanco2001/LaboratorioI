/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.util.LinkedList;

/**
 *
 * @author alexz
 */
public interface Operaciones {
    
    public void Agregar(LinkedList<Nodo> operaciones);
    public void Rotar();
    public int Tamaño();
    public int Profundidad();
}
