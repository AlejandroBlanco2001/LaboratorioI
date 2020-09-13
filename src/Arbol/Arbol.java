/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author alexz
 */
public class Arbol implements Operaciones, Serializable {
    
    // Nodo vacio
    public User raiz;

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

    public Post getPost(int postId) {
        for (Nodo user : raiz.getPosts()) {
            User u = (User) user;
            if (u.checkPostId(postId)) {
                return u.getPost(postId);
            }
        }
        return null;
    }

    public void insertarComment(Nodo nodo) {
        Comment comment = (Comment) nodo;
        Post p = getPost(comment.getPostId());
        p.setComments(comment);
    }

    // TEST ONLY USE
    public void muestrameTodo() {
        for (Nodo user : raiz.getPosts()) {
            User u = (User) user;
            u.mostrarUser();
        }
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
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    @Override
    public void Rotar() {
      
    }

    @Override
    public void Tamaño() {
        int cont = raiz.getPosts().size();
        for(Nodo n: raiz.getPosts()){
            User user = (User) n;
            cont += user.getTam();
        }
        System.out.println(cont);
    }

    public int cantidadDeUsers(){
        return raiz.getPosts().size();
    }
    
    public int cantidadPosts(){
        int cont = 0;
        for(Nodo n: raiz.getPosts()){
            User user = (User) n;
            cont += user.getPosts().size();
        }
        return cont;
    } 
    
    public int cantidadDeComments(){
        int cont = 0;
        for(Nodo n: raiz.getPosts()){
            User user = (User) n;
            cont += user.getAllComments();
        }
        return cont;
    }
    
    @Override
    public void Profundidad() {

    }
}
