package Prinicipal;

import Arbol.Arbol;
import Arbol.Post;
import Arbol.Comment;
import Arbol.Nodo;
import Arbol.User;
import Parser.Parser;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase prinicipal encargada de la creacion parcial del arbol, se encarga de dar inicio a la {@link Ventana}
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
        File[] files = getFiles();
        while (!files[0].getName().contains(".csv") && Lab.createTree(files) == null) {
            if (!files[0].getName().contains(".csv") && files.length == 1) {
                JOptionPane.showMessageDialog(null, "El archivo que contiene el arbol serializado debe ser .csv", "Archivo con extension invalida", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Archivos con nombre incorrecto, por favor maneje los nombres Comment,Users,Posts en formato .txt", "Error de ingreso de archivo", JOptionPane.ERROR_MESSAGE);
            }
            files = getFiles();
        }
        if (files.length == 1) {
            arbol = Serializador.recover(files[0].getAbsolutePath());
        } else {
            Lab.createTree(files);
        }
        ventana.setVisible(true);
        ventana.setArbol(arbol);
    }

    /**
     * Se encarga de crear el {@link Arbol} a partir de una arreglo de {@code File} previamente ordenado por el metodo {@code organizeFiles}.
     *
     * @param files Arreglo de tipo {@code File}, que contiene las rutas de los archivos
     * @return El arreglo de Files ordenado de la forma: User, Post , Comment
     * @throws java.io.IOException En el caso de que el archivo no exista
     */
    public static Arbol createTree(File[] files) throws IOException {
        arbol = new Arbol();
        files = organizeFiles(files);
        if (files == null) {
            return null;
        }
        Parser p = Parser.getParser();
        ListaEnlazada<String> tempo = p.getObjects(files[0].getName(), files[0].getCanonicalPath());
        ListaEnlazada<Nodo> lista = new ListaEnlazada();
        for (Object t : tempo) {
            lista.add((User) p.cleanData((String) t));
        }
        arbol.Agregar(lista);
        tempo = p.getObjects(files[1].getName(), files[1].getCanonicalPath());
        lista.clear();
        for (Object t : tempo) {
            lista.add((Post) p.cleanData((String) t));
        }
        arbol.Agregar(lista);
        lista.clear();
        tempo = p.getObjects(files[2].getName(), files[2].getCanonicalPath());
        for (Object t : tempo) {
            lista.add((Comment) p.cleanData((String) t));
        }
        arbol.Agregar(lista);
        return arbol;
    }

    /**
     * Se encargar de recibir un arreglo de tipo {@code File}, para ser ordenados de manera que su lectura, sea facilitada para el Parser.
     *
     * @param files Arreglo de tipo {@code File}, de los archivos seleccionados por el usuario
     * @return El arreglo de {@code Files} ordenado de la forma: {@link User}, {@link Post}, {@link Comment}
     */
    public static File[] organizeFiles(File[] files) {
        int cont = 0;
        File aux;
        if (!checkFiles(files)) {
            return null;
        }
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
    /**
     * Se encargar de obtener una cantidad de Post de manera aleatoria para ser desplegados por la Ventana.
     *
     * @param arbol {@link Arbol} Arbol n-ario que contiene toda la informacion.
     * @return Una {@code LinkedList<Post>} con los posts seleccionados.
     */
    public static ListaEnlazada<Post> getRandomPost(Arbol arbol) {
        ListaEnlazada<Post> lista = new ListaEnlazada();
        for (Object nodo : arbol.getRaiz().getPosts()) {
            User user = (User) nodo;
            if (user.getPosts().get(0) != null) {
                lista.add((Post) user.getPosts().get(0));
            }
        }
        return lista;
    }

    /**
     * Metodo que se encarga de verificar que el nombre de los archivos manejen la estructura correcta de nombre
     *
     * @param files Arreglo de {@link File} que contiene los archivos a examinar
     * @return checked {@code true} si los archivos cumplen la estructura, {@code false} en el caso contrario
     */
    private static boolean checkFiles(File[] files) {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        for (File f : files) {
            if (f.getName().equals("Comments.txt")) {
                flag1 = true;
            }
            if (f.getName().equals("Posts.txt")) {
                flag2 = true;
            }
            if (f.getName().equals("Users.txt")) {
                flag3 = true;
            }
        }
        if (flag1 && flag2 && flag3) {
            return true;
        }
        return false;
    }

    /**
     * Metodo que se encarga de retornar el Arbol
     *
     * @return arbol Arbol creado
     */
    public Arbol getArbol() {
        return arbol;
    }

    /**
     * Metodo que se encarga de la obtencion de los archivos por medio del JFileChooser
     *
     * @return files Arreglo de {@code File} seleccionados
     */
    public static File[] getFiles() {
        File[] files = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "*.txt,*.csv", "txt", "csv");
        chooser.setFileFilter(filter);
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            files = chooser.getSelectedFiles();
            return files;
        }
        return null;
    }

}
