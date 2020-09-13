package Arbol;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author alexz
 */
public class User extends Nodo {
    
    private final int ID;
    private String username;
    private String email;
    private Persona persona;

    private User(int ID, String username, String email) {
        super();
        this.ID = ID;
        this.username = username;
        this.email = email;
        hijos = new LinkedList();
    }

    public User() {
        this.ID = 0;
        hijos = new LinkedList();
    }

    public static User createUser(int id, String username, String email) {
        return new User(id, username, email);
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Nodo> getPosts() {
        return hijos;
    }

    public void addPersona(LinkedList<String> info) {
        this.persona = new Persona(info.get(1), info.get(10), info.get(11));
        this.persona.setAdress(info.get(4), info.get(5), info.get(6), info.get(7), info);
    }

    public void setPost(Nodo post) {
        if (post != null) {
            hijos.add(post);
        }
    }

    public Post getPost(int id) {
        for (Nodo post : hijos) {
            Post p = (Post) post;
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public Post getPost(String title) {
        for (Nodo post : hijos) {
            Post p = (Post) post;
            if (p.getTitle().equals(title)) {
                return p;
            }
        }
        return null;
    }

    public boolean checkPostId(int postId) {
        for (Nodo post : hijos) {
            Post p = (Post) post;
            if (p.getId() == postId) {
                return true;
            }
        }
        return false;
    }

    public void mostrarUser() {
        StringBuffer sb = new StringBuffer();
        sb.append("ID del user:" + this.ID).append("\n Email del user: " + this.email).append("\n Nombre de usuario:" + this.username);
        System.out.println(sb.toString());
        for (Nodo nodo : hijos) {
            Post p = (Post) nodo;
            p.mostrarPost();
        }
    }

    public int getTam() {
        int cont = this.hijos.size();
        for (Nodo n : hijos) {
            Post p = (Post) n;
            cont += p.getComments().size();
        }
        return cont;
    }

    public int getAllComments() {
        int cont = 0;
        for (Nodo n : hijos) {
            Post p = (Post) n;
            cont += p.getComments().size();
        }
        return cont;
    }
}
