/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import Prinicipal.ListaEnlazada;
import java.util.LinkedList;

/**
 * Interfaz que tiene las operaciones basicas que debe realizar un Arbol
 * 
 * @author alexz
 */
public interface Operaciones {

    /**
     * Metodo que cumple la funcion de agregar nodos en cierto nivel del Arbol.
     *
     * @param nodos {@code ListaEnlazada} Nodos a agregar al Arbol
     */
    public void Agregar(ListaEnlazada<Nodo> nodos);

    /**
     * Metodo que dependiendo del Arbol que se quiera crear, cumple la funcion de balancear el Arbol.
     */
    public void Rotar();

    /**
     * Metodo que cumple la funcion de devolver el Tamaño del Arbol
     *
     * @return tamaño Cantidad de {@link Nodo} presentes en el Arbol
     */
    public int Tamaño();

    /**
     * Metodo que cumple la funcion de devolver la cantidad de niveles del Arbol
     *
     * @return nivel Altura del Arbol partiendo de la raiz del Arbol
     */
    public int Profundidad();
}
