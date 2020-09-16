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
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alexz
 */
public class Lab {

    private static Arbol arbol;
    private static Ventana ventana;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here   
        ventana = new Ventana();
        ventana.dispose();
        ventana.setUndecorated(true);
        arbol = new Arbol();
        File[] files = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "*.txt,*.csv", "txt", "csv");
        chooser.setFileFilter(filter);
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            files = chooser.getSelectedFiles();
        }
        if(files.length == 1){
            arbol = Serializador.recover(files[0].getCanonicalPath());
        }else{
            Lab.createTree(files);
        }
        ventana.setVisible(true);
        ventana.setArbol(arbol);
    }

    public static Arbol createTree(File[] files) throws IOException {
        arbol = new Arbol();
        files = organizeFiles(files);
        Parser p = Parser.getParser();
        LinkedList<String> tempo = p.getObjects(files[0].getName(), files[0].getCanonicalPath());
        LinkedList<Nodo> lista = new LinkedList();
        for (String t : tempo) {
            lista.add((User) p.cleanData(t));
        }
        arbol.Agregar(lista);
        tempo = p.getObjects(files[1].getName(), files[1].getCanonicalPath());
        lista.clear();
        for (String t : tempo) {
            lista.add((Post) p.cleanData(t));
        }
        arbol.Agregar(lista);
        lista.clear();
        tempo = p.getObjects(files[2].getName(), files[2].getCanonicalPath());
        for (String t : tempo) {
            lista.add((Comment) p.cleanData(t));
        }
        arbol.Agregar(lista);
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

    // TEST ONLY USE
    public static LinkedList<Post> getRandomPost(Arbol arbol) {
        LinkedList<Post> lista = new LinkedList();
        for (Nodo nodo : arbol.getRaiz().getPosts()) {
            User user = (User) nodo;
            if (user.getPosts().get(0) != null) {
                lista.add((Post) user.getPosts().get(0));
            }
        }
        return lista;
    }


    public Arbol getArbol() {
        return arbol;
    }

}
