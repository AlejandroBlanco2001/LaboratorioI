package Arbol;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author alexz
 */
public class Arbol implements Operaciones, Serializable {

    // Nodo vacio
    private User raiz;

    public Arbol() {
        raiz = new User();
    }

    @Override
    public void Agregar(LinkedList<Nodo> insercciones) {
        for (Nodo i : insercciones) {
            if (i instanceof User) {
                insertarUser(i);
            } else if (i instanceof Post) {
                insertarPost(i);
            } else {
                insertarComment(i);
            }
        }
    }

    public void insertarUser(Nodo nodo) {
        User user = (User) nodo;
        raiz.setPost(user);
    }

    public void insertarPost(Nodo nodo) {
        Post post = (Post) nodo;
        for (Nodo user : raiz.getPosts()) {
            User u = (User) user;
            if (u.getID() == post.getUserId()) {
                u.setPost(post);
            }
        }
    }

    public void insertarComment(Nodo nodo) {
        Comment comment = (Comment) nodo;
        Post p = getPost(comment.getPostId());
        p.setComments(comment);
    }

    public User busquedaUser(int id) {
        for (Nodo n : raiz.getPosts()) {
            User user = (User) n;
            if (user.getID() == id) {
                return user;
            }
        }
        return null;
    }

    public User busquedaUser(String username) {
        for (Nodo n : raiz.getPosts()) {
            User user = (User) n;
            if (user.getUsername().toLowerCase().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public LinkedList<User> matchPosibbleUsers(String username) {
        LinkedList<User> matches = new LinkedList();
        for (Nodo n : raiz.getPosts()) {
            User user = (User) n;
            if (user.getUsername().toLowerCase().startsWith(username)) {
                matches.add(user);
            }
        }
        return matches;
    }

    public Post getPost(int postId) {
        for (Nodo user : raiz.getPosts()) {
            User u = (User) user;
            if (u.checkPostId(postId)) {
                return u.getPost(postId);
            }
        }
        return null;
    }

    public Post getPost(String title) {
        for (Nodo user : raiz.getPosts()) {
            User u = (User) user;
            if (u.checkPostName(title)) {
                return u.getPost(title);
            }
        }
        return null;
    }

    public User getUserByPost(String title) {
        for (Nodo user : raiz.getPosts()) {
            User u = (User) user;
            if (u.checkPostName(title)) {
                return u;
            }
        }
        return null;
    }

    public User getUserByPost(int id) {
        for (Nodo user : raiz.getPosts()) {
            User u = (User) user;
            if (u.getID() == id) {
                return u;
            }
        }
        return null;
    }

    // TEST ONLY USE
    public void muestrameTodo() {
        for (Nodo user : raiz.getPosts()) {
            User u = (User) user;
            u.mostrarUser();
        }
    }

    public int cantidadDeUsers() {
        return raiz.getPosts().size();
    }

    public int cantidadPosts() {
        int cont = 0;
        for (Nodo n : raiz.getPosts()) {
            User user = (User) n;
            cont += user.getPosts().size();
        }
        return cont;
    }

    public int cantidadDeComments() {
        int cont = 0;
        for (Nodo n : raiz.getPosts()) {
            User user = (User) n;
            cont += user.getAllComments();
        }
        return cont;
    }

    @Override
    public int Tamaño() {
        int cont = raiz.getPosts().size();
        for (Nodo n : raiz.getPosts()) {
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

    public User getRaiz() {
        return raiz;
    }

}
