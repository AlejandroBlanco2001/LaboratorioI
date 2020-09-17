package Arbol;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Clase abstracta que se encarga de hacer la funcion de un Nodo y sus funciones basicas
 * @author alexz
 */
public abstract class Nodo implements Serializable{
    
    /**
     * Hijos de cada nodo
     */
    protected LinkedList<Nodo> hijos;
    
    /**
     * Metodo que se encarga de devolver los hijos de un Nodo en especifico
     * @return hijos Hijos de cada nodo
     */
    public LinkedList getHijos() {
        return hijos;
    }
    
}
