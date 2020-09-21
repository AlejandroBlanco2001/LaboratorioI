package Arbol;

import Prinicipal.ListaEnlazada;
/**
 * Clase que abstrae la idea de una Persona natural que posee una cuenta User
 * @author alexz
 */
public class Persona{
    
    private String name;
    private String phone;
    private String website;
    private Direccion adress;
    private Compañia company;
    private User user;
    
    /**
     * Constructor publico
     * @param name Nombre de la Persona 
     * @param phone Numero de la Persona
     * @param website Webiste de la Persona
     * @param user Usuario asociado a esta Persona
     */
    public Persona(String name, String phone, String website,User user) {
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.adress = adress;
        this.company = company;
        this.user = user;
    }

    /**
     * Metodo que se encarga de la creacion de la Direccion, Compañia y Coordenada asociadas a este Persona
     * @param street Calle de la Direccion
     * @param suite Suite de la Direccion
     * @param city Ciudad de la Direccion 
     * @param zipcode Codigo postal de la Direccion
     * @param info Informacion de los campos restantes
     */
    public void setAdress(String street, String suite, String city, String zipcode,ListaEnlazada<String> info) {
        this.adress = new Direccion(street,suite,city,zipcode);
        this.adress.setGeo(Float.parseFloat(info.get(8)),Float.parseFloat(info.get(9)));
        this.company = new Compañia(info.get(12),info.get(13),info.get(14));
    }

    /**
     * Metodo que retorna el nombre de la Persona
     * @return name Nombre de la Persona
     */
    public String getName() {
        return name;
    }

    /**
     *  Metodo que retorna el numero de telefono de la Persona
     * @return phone Numero de la Persona
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Metodo que retorna el Website de la Persona
     * @return website Website de la Persona
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Metodo que retorna el objeto {@link Direccion} de la Persona
     * @return adress Objeto {@link Direccion} de la Persona
     */
    public Direccion getAdress() {
        return adress;
    }

    /**
     * Metodo que retorna el objeto {@link Compañia} de la Persona
     * @return company Objeto {@link Compañia}
     */
    public Compañia getCompany() {
        return company;
    }

    /**
     * Metodo que se encarga de la creacion o modificacion del objeto {@link Coordenada} de cada Persona
     * @param adress Direccion a crear 
     */
    public void setAdress(Direccion adress) {
        this.adress = adress;
    }

    /**
     * Metodo que se encarga de la creacion o modificacion del objeto {@link Compañia} de cada Persona
     * @param company Compañia a crear
     */
    public void setCompany(Compañia company) {
        this.company = company;
    }

    /**
     * Metodo que se encarga de volver los datos de Persona en una String separados por coma
     *
     * @return String Cadena que contiene todos los datos del Persona
     */
    public String getAllData(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(",").append(this.phone).append(",").append(this.website).append("\n").append(this.adress.getAllData()).append("\n").append(this.company.getAllData());
        return sb.toString();
    }
    
}
