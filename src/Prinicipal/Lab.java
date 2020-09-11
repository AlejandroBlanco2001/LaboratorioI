package Prinicipal;

import Arbol.Arbol;
import Arbol.Post;
import Arbol.Comment;
import Arbol.Nodo;
import Arbol.User;
import Parser.Parser;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author alexz
 */
public class Lab {

    /**
     * @param args the command line arguments
     */
    public static User user;
    private static Arbol arbol;

    public static void main(String[] args) {
        // TODO code application logic here
        Ventana ventana = new Ventana();
        ventana.dispose();
        ventana.setUndecorated(true);
        Arbol arbol = new Arbol();
        Parser p = Parser.getParser();
        LinkedList<String> tempo = p.getObjects("Users.txt");
        LinkedList<Nodo> lista = new LinkedList();
        for (String t : tempo) {
            lista.add((User) p.cleanData(t));
        }
        user = (User) lista.get(0);
        arbol.Agregar(lista);
        tempo = p.getObjects("Posts.txt");
        lista.clear();
        for (String t : tempo) {
            lista.add((Post) p.cleanData(t));
        }
        arbol.Agregar(lista);
        lista.clear();
        tempo = p.getObjects("Comments.txt");
        for (String t : tempo) {
            lista.add((Comment) p.cleanData(t));
        }
        arbol.Agregar(lista);
        ventana.setVisible(true);
        ventana.setArbol(arbol);
    }

    public static Arbol createTree(File[] files) throws IOException {
        Arbol arbol = new Arbol();
        files = organizeFiles(files);
        Parser p = Parser.getParser();
        LinkedList<String> tempo = p.getObjects(files[0].getName(),files[0].getCanonicalPath());
        LinkedList<Nodo> lista = new LinkedList();
        for (String t : tempo) {
            lista.add((User) p.cleanData(t));
        }
        user = (User) lista.get(0);
        arbol.Agregar(lista);
        tempo = p.getObjects(files[1].getName(),files[1].getCanonicalPath());
        lista.clear();
        for (String t : tempo) {
            lista.add((Post) p.cleanData(t));
        }
        arbol.Agregar(lista);
        lista.clear();
        tempo = p.getObjects(files[2].getName(),files[2].getCanonicalPath());
        for (String t : tempo) {
            lista.add((Comment) p.cleanData(t));
        }
        return arbol;
    }

    public static File[] organizeFiles(File[] files) {
        int cont = 0;
        File aux;
        for (File file : files) {
            if (file.getName().equals("Comments.txt")) {
                aux = files[2];
                files[2] = file;
            } else if (file.getName().equals("Posts.txt")) {
                aux = files[1];
                files[1] = file;
            } else {
                aux = files[0];
                files[0] = file;
            }
            files[cont] = aux;
            cont++;
        }
        return files;
    }

    public User getUsuario() {
        return user;
    }

    public Arbol getArbol() {
        return arbol;
    }
}
