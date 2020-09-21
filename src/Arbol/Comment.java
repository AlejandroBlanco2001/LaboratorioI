/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import Prinicipal.ListaEnlazada;

/**
 * Clase que abstrae la idea del Comment
 * @author alexz
 */
public class Comment extends Nodo {

    private final int postId;
    private final int id;
    private String name;
    private String body;
    private String email;

    private static String temporaryData[] = new String[5];

    /**
     * Constructor privado de Comment, para evitar su creacion por alguien distinto a el mismo.
     * @param postId ID del Post del que proviene
     * @param id ID del propio Comment
     * @param name Titulo del Comment
     * @param body Cuerpo del Comment
     * @param email Email de la persona que creo el Comment
     */
    private Comment(int postId, int id, String name, String body, String email) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.body = body;
        this.email = email;
    }
    
    /**
     * Metodo que se encarga de separar los datos y crear el objeto Comment
     * @param separatedData {@code LinkedList<String>} que contiene todos los datos ordenados segun su aparicion en el JSON
     * @return Comment {@link Comment} el Comment creado
     */
    public static Comment cleanInfo(ListaEnlazada<String> separatedData) {
        int a = 0;
        for(Object t: separatedData){
            temporaryData[a] = (String) t;
            a++;
        }
        int postIdTemp = Integer.parseInt(temporaryData[0]);
        int idTemp = Integer.parseInt(temporaryData[1]);
        String tittleT = temporaryData[2];
        String bodyT = temporaryData[4];
        String emailT = temporaryData[3];
        return new Comment(postIdTemp, idTemp, tittleT, bodyT, emailT);
    }

    /**
     * Metodo que se encarga de devolver el ID del Post en el cual se creo el Comment
     * @return postId ID del Post en el cual se encuentra el Comment
     */
    public int getPostId() {
        return postId;
    }

    /**
     * Metodo que se encarga de devolver el ID del Comment
     * @return id ID del Comment
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que se encarga de devolver el nombre del Comment
     * @return name Nombre del Comment
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que se encarga de devolver el cuerpo del Comment
     * @return body Cuerpo del Comment
     */
    public String getBody() {
        return body;
    }

    /**
     * Metodo que se encarga de devolver el Email asociado al Comment 
     * @return email E-Mail asociado al Comment
     */
    public String getEmail() {
        return email;
    }
    
    // Test only use

    /**
     * Metodo de prueba que se encarga de mostrar por consola la informacion del Comment
     */
    public void mostrarComment() {
        StringBuffer sb = new StringBuffer();
        sb.append("\t \t \n " + "ID del comment" + this.id).append("\t \t \n" + "post del Comment id: " +this.postId).append("\t \t \n" + "Email del comentarista" + this.email).append("\t \t \n" + "Persona del comment" + this.name).append("\t \t \n" + "Cuerpo del comment:" + this.body);
        System.out.println(sb.toString());
    }
    
    @Override
    public String getAllData(){
        StringBuilder sb = new StringBuilder();
        sb.append("C").append(",").append(this.postId).append(",").append(this.id).append(",").append(this.name).append(",").append(this.body).append(",").append(this.email).append("\n");
        return sb.toString();
    }
}
