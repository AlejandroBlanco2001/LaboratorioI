package Arbol;

import Prinicipal.ListaEnlazada;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Clase abstracta que se encarga de hacer la funcion de un Nodo y sus funciones basicas
 *
 * @author alexz
 */
public abstract class Nodo {

    /**
     * Hijos de cada nodo
     */
    protected ListaEnlazada<Nodo> hijos;

    /**
     * Metodo que se encarga de devolver los hijos de un Nodo en especifico
     *
     * @return hijos Hijos de cada nodo
     */
    public ListaEnlazada<Nodo> getHijos() {
        return hijos;
    }

    /**
     * Metodo que se encarga de volver los datos de un User en una String separados por coma
     *
     * @return String Cadena que contiene todos los datos del User y sus componentes.
     */
    public abstract String getAllData();

}
