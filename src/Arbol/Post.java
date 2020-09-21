package Arbol;

import Prinicipal.ListaEnlazada;

/**
 * Clase que abstrae la idea del Post
 * @author alexz
 */
public class Post extends Nodo {

    private final int userId;
    private final int id;
    private String title;
    private String body;

    private static String temporaryData[] = new String[4];

    /**
     * Constructor privado del Post, que se encarga de verificar que solo el se pueda crear a el mismo
     *
     * @param userId ID del User que hizo el Post
     * @param id ID del Post
     * @param title Titulo del Post
     * @param body Cuerpo del Post
     */
    private Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
        hijos = new ListaEnlazada();
    }

    /**
     * Metodo que se encarga de separar los datos y crear el objeto Post
     *
     * @param separatedData {@code LinkedList} que contiene todos los datos ordenados segun su aparicion en el JSON
     * @return Post {@link Post} el Post creado
     */
    public static Post cleanInfo(ListaEnlazada<String> separatedData) {
        int a = 0;
        for(Object t: separatedData){
            temporaryData[a] = (String) t;
            a++;
        }
        int userIdTemp = Integer.parseInt(temporaryData[0]);
        int idTemp = Integer.parseInt(temporaryData[1]);
        String tittleT = temporaryData[2];
        String bodyT = temporaryData[3];
        return new Post(userIdTemp, idTemp, tittleT, bodyT);
    }

    /**
     * Metodo que retorna el ID del User que creo el Post
     * @return userId ID del User que creo el Post
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Metodo que retorna el ID del Post
     * @return id ID del Post
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que retorna el titulo del Post
     * @return title Titulo del Post
     */
    public String getTitle() {
        return title;
    }

    /**
     * Metodo que retorna el cuerpo del Post
     * @return body Cuerpo de Post
     */
    public String getBody() {
        return body;
    }

    /**
     * Metodo que se encarga de agregar los Nodos a el Post
     * @param comment {@link Nodo} Nodo a agregar
     */
    public void setComments(Nodo comment) {
        if (comment != null) {
            hijos.add(comment);
        }
    }

    /**
     * Metodo que se encarga de obtener un Comment especifico a partir de su ID
     *
     * @param ID ID del Comment
     * @return c {@link Comment} Devuelve el Comment a buscar, {@code null} en caso contrario devuelve
     */
    public Comment getComment(int ID) {
        for (Object nodo : getComments()) {
            Comment c = (Comment) nodo;
            if (c.getId() == ID) {
                return c;
            }
        }
        return null;
    }

    /**
     * Metodo que se encarga de obtener un Comment especifico a partir de su Titulo, Cuerpo o email del creador
     *
     * @param title Titulo, cuerpo o email del creador del Comment
     * @return c {@link Comment} Devuelve el Comment a buscar, {@code null} en caso contrario devuelve
     */
    public Comment getComment(String title) {
        for (Object nodo : getComments()) {
            Comment c = (Comment) nodo;
            if (c.getBody().equals(title) || c.getEmail().equals(title) || c.getName().equals(title)) {
                return c;
            }
        }
        return null;
    }

    // TEST ONLY USE

    /**
     * Metodo que se encargar de mostrar en consola toda la informacion del Post
     */
    public void mostrarPost() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t \n" + "ID del post:" + this.id).append("\t \n" + "ID del post del user" + this.userId).append("\t \n" + "Titulo del post" + this.title).append("\t \n" + "Contenido: " + this.body);
        System.out.println(sb.toString());
        for (Object nodo : hijos) {
            Comment c = (Comment) nodo;
            c.mostrarComment();
        }
    }

    /**
     * Metodo que se encargar de devolver los hijos del Post
     * @return hijos Hijos del nodo
     */
    public ListaEnlazada<Nodo> getComments() {
        return hijos;
    }
    
    @Override
    public String getAllData(){
        StringBuilder sb = new StringBuilder();
        sb.append("P").append(",").append(this.userId).append(",").append(this.id).append(",").append(this.title).append(",").append(this.body).append("\n");
        for(Object nodo: this.getHijos()){
            Comment c = (Comment) nodo;
            sb.append(c.getAllData());
            System.out.println("Comment ID: " + c.getId());
        }
        return sb.toString();
        
    }

}
