package Arbol;

import java.io.Serializable;
import java.util.LinkedList;
import Prinicipal.ListaEnlazada;

/**
 * Clase que abstrae la idea de la estructura de Arbol, esta contiene toda la información y es la encargada de tener la raiz del mismo.
 *
 * @author alexz
 */
public class Arbol implements Operaciones, Serializable {

    // Nodo vacio
    private User raiz;

    /**
     * Constructor del Arbol, crear un {@link Nodo} de tipo {@link User} vacio
     */
    public Arbol() {
        raiz = new User();
    }

    @Override
    public void Agregar(ListaEnlazada<Nodo> insercciones) {
        for (Object i : insercciones) {
            if (i instanceof User) {
                insertarUser((User) i);
            } else if (i instanceof Post) {
                insertarPost((Post) i);
            } else {
                insertarComment((Comment) i);
            }
        }
    }

    /**
     * Metodo que se encarga de la creacion del nivel de Usuarios, por la forma de la creacion, solo es necesario castearlo a {@link User}
     *
     * @param nodo {@link Nodo} Nodo a ingresar al Arbol
     */
    public void insertarUser(Nodo nodo) {
        User user = (User) nodo;
        raiz.setPost(user);
    }

    /**
     * Metodo que se encarga de la creacion del nivel de Post, por la forma de la creacion, solo es necesario castearlo a {@link Post}
     *
     * Usando el campo {@code postId} de la clase {@link Post}, se compara con el ID de cada usuario existente en el {@link Arbol}
     *
     * @param nodo {@link Nodo} Nodo a ingresar al nivel de Post
     */
    public void insertarPost(Nodo nodo) {
        Post post = (Post) nodo;
        for (Object user : raiz.getPosts()) {
            User u = (User) user;
            if (u.getID() == post.getUserId()) {
                u.setPost(post);
            }
        }
    }

    /**
     * Metodo que se encarga de la creacion del nivel de Comment, por la forma de la creacion, solo es necesario castearlo a {@link Comment}
     *
     * @param nodo {@link Nodo} Nodo a ingresar al Arbol
     */
    public void insertarComment(Nodo nodo) {
        Comment comment = (Comment) nodo;
        Post p = getPost(comment.getPostId());
        p.setComments(comment);
    }

    /**
     * Metodo que se encarga de la busqueda de un Usuario en especifico
     *
     * @param id ID del usuario a buscar
     * @return {@link User} retorna el Usuario con dicho ID.
     */
    public User busquedaUser(int id) {
        for (Object n : raiz.getPosts()) {
            User user = (User) n;
            if (user.getID() == id) {
                return user;
            }
        }
        return null;
    }

    /**
     * Metodo que se encarga de la busqueda de un Usuario en especifico
     *
     * @param username Nombre de usuario a buscar
     * @return {@link User} retorna el Usuario con dicho nombre de usuario.
     */
    public User busquedaUser(String username) {
        for (Object n : raiz.getPosts()) {
            User user = (User) n;
            if (user.getUsername().toLowerCase().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Metodo que se encarga de devolver todas las coincidencias de primeros caracteres del los nombre de usuario.
     *
     * @param username coincidencia a buscar
     * @return {@code LinkedList<User>} donde contiene todos los usuarios que contengan esas coincidencias.
     */
    public LinkedList<User> matchPosibbleUsers(String username) {
        LinkedList<User> matches = new LinkedList();
        for (Object n : raiz.getPosts()) {
            User user = (User) n;
            if (user.getUsername().toLowerCase().startsWith(username)) {
                matches.add(user);
            }
        }
        return matches;
    }

    /**
     * Metodo que se encarga de la busqueda de un Post, partiendo del usuario que lo creo
     *
     * @param postId Campo {@code postId} que contiene el ID del usuario que creo dicho Post
     * @return {@link Post} retorna el Post especifico de dicho usuario especifico.
     */
    public Post getPost(int postId) {
        for (Object user : raiz.getPosts()) {
            User u = (User) user;
            if (u.checkPostId(postId)) {
                return u.getPost(postId);
            }
        }
        return null;
    }

    /**
     * Metodo que se encarga de la busqueda de un Post, partiendo si el Usuario tiene un post con dicho nombre
     *
     * @param title Campo {@code title} que contiene el titulo del Post
     * @return {@link Post} retorna el Post especifico de dicho usuario especifico.
     */
    public Post getPost(String title) {
        for (Object user : raiz.getPosts()) {
            User u = (User) user;
            if (u.checkPostName(title)) {
                return u.getPost(title);
            }
        }
        return null;
    }

    /**
     * Metodo que se encarga de la busqueda de un User, partiendo de su pertenencia de algun Post en especifico
     *
     * @param title Campo {@code title} Titulo del Post
     * @return {@link User} retorna el User especifico que contenga dicho Post
     */
    public User getUserByPost(String title) {
        for (Object user : raiz.getPosts()) {
            User u = (User) user;
            if (u.checkPostName(title)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Metodo que se encarga de la busqueda de un User, partiendo de su pertenencia de algun Post en especifico
     *
     * @param id Campo {@code id} ID del Post
     * @return {@link User} retorna el User especifico que contenga dicho Post
     */
    public User getUserByPost(int id) {
        for (Object user : raiz.getPosts()) {
            User u = (User) user;
            for (Object post : u.getPosts()) {
                Post p = (Post) post;
                if (id == p.getId()) {
                    return u;
                }
            }
        }
        return null;
    }

    // TEST ONLY USE

    /**
     * Metodo de prueba que se usa para mostrar toda la informacion del Arbol
     */
    public void muestrameTodo() {
        for (Object user : raiz.getPosts()) {
            User u = (User) user;
            u.mostrarUser();
        }
    }

    /**
     * Metodo que se encarga de contar la cantidad de Users en el Arbol
     *
     * @return Cantidad de {@link Nodo} tipo {@link User} en el {@link Arbol}
     */
    public int cantidadDeUsers() {
        return raiz.getPosts().size();
    }

    /**
     * Metodo que se encarga de contar la cantidad de Post en el Arbol
     *
     * @return cont Cantidad de {@link Nodo} tipo {@link Post} en el {@link Arbol}
     */
    public int cantidadPosts() {
        int cont = 0;
        for (Object n : raiz.getPosts()) {
            User user = (User) n;
            cont += user.getPosts().size();
        }
        return cont;
    }

    /**
     * Metodo que se encarga de contar la cantidad de Comment en el Arbol
     *
     * @return cont Cantidad de {@link Nodo} tipo {@link Comment} en el {@link Arbol}
     */
    public int cantidadDeComments() {
        int cont = 0;
        for (Object n : raiz.getPosts()) {
            User user = (User) n;
            cont += user.getAllComments();
        }
        return cont;
    }

    @Override
    public int Tamaño() {
        int cont = raiz.getPosts().size();
        for (Object n : raiz.getPosts()) {
            User user = (User) n;
            cont += user.getTam();
        }
        return cont;
    }

    @Override
    public int Profundidad() {
        return 0;
    }

    @Override
    public void Rotar() {

    }

    /**
     * Metodo que se obtener la raiz
     *
     * @return raiz {@link Nodo} raiz del Arbol
     */
    public User getRaiz() {
        return raiz;
    }

    /**
     * Metodo que se encarga de la busqueda de un Comment, partiendo de su titulo, email generador o su cuerpo.
     *
     * @param title cuerpo, email o titulo del Comment
     * @return comment Comentario especifico a buscar
     */
    public Comment getComment(String title) {
        for (Object n : raiz.getPosts()) {
            User user = (User) n;
            if (user.getComment(title) != null) {
                return (Comment) user.getComment(title);
            }
        }
        return null;
    }

    /**
     * Metodo que se encarga de la busqueda de un Comment, partiendo de su ID.
     *
     * @param ID Campo {@code ID} del Comment
     * @return comment Comentario especifico a buscar
     */
    public Comment getComment(int ID) {
        for (Object n : raiz.getPosts()) {
            User user = (User) n;
            if (user.getComment(ID) != null) {
                return (Comment) user.getComment(ID);
            }
        }
        return null;
    }
}
