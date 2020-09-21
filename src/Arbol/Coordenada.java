package Arbol;

/**
 * Clase que abstrae la idea de Geolocalizacion
 *
 * @author alexz
 */
public class Coordenada {

    private final float latitude;
    private final float longitude;

    /**
     * Constructor publico
     *
     * @param latitude Latitud de la Coordenada
     * @param longitude Longitud de la Coordenada
     */
    public Coordenada(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Metodo que retorna la latitud de la Coordenada
     *
     * @return latitude Latitud de la Coordenada
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Metodo que retorna la longitud de la Coordenada
     *
     * @return longtide Longitud de la Coordenada
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Metodo que se encarga de volver los datos de Coordenada en una String separados por coma
     *
     * @return String Cadena que contiene todos los datos del Coordenada
     */
    public String getAllData() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.latitude).append(",").append(this.longitude);
        return sb.toString();
    }

}
