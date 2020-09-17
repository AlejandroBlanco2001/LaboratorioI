/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.io.Serializable;

/**
 * Clase que abstrae la idea de Geolocalizacion
 * @author alexz
 */
public class Coordenada implements Serializable {
    
    private final float latitude;
    private final float longitude;

    /**
     * Constructor publico
     * @param latitude Latitud de la Coordenada
     * @param longitude Longitud de la Coordenada
     */
    public Coordenada(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Metodo que retorna la latitud de la Coordenada
     * @return latitude Latitud de la Coordenada
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Metodo que retorna la longitud de la Coordenada
     * @return longtide Longitud de la Coordenada
     */
    public float getLongitude() {
        return longitude;
    }

    
}
