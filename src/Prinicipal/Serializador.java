package Prinicipal;

import Arbol.Arbol;
import Arbol.Comment;
import Arbol.Nodo;
import Arbol.Post;
import Arbol.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.JFileChooser;

/**
 * Clase que contiene el sistema de Serializacion del Arbol
 *
 * @author Shalem Janna e Isaac Blanco
 */
public class Serializador {
 
    /**
     * Metodo que se encarga de serializar el arbol, volviendolo un archivo de tipo .CSV
     * @param arbol Arbol a serializar
     * @throws FileNotFoundException Error en caso de que no encuentre el archivo a buscar
     * @throws UnsupportedEncodingException Error en caso de que la codificacion del archivo no sea valida 
     */
    public static void serialize(Arbol arbol) throws UnsupportedEncodingException, FileNotFoundException {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);
        File file = new File(f.getSelectedFile(), "arbol.csv");
        StringBuilder sb = new StringBuilder();
        PrintWriter writer = new PrintWriter(file);
        for (Object nodo : arbol.getRaiz().getHijos()) {
            User u = (User) nodo;
            System.out.println("USER " + u.getID());
            sb.append(u.getAllData());
        }
        writer.write(sb.toString());
    }

    /**
     * Metodo que se encarga de convertir el archivo .csv a la representacion del Arbol
     * @param ruta Ruta donde se encuentra el archivo .csv
     * @return Arbol Devuelve el arbol completamente creado a la clase {@link Lab}
     */
    public static Arbol recover(String ruta){
        StringBuffer sb = new StringBuffer();
        Arbol arbol = new Arbol();
        ListaEnlazada<Nodo> users = new ListaEnlazada();
        ListaEnlazada<Nodo> posts = new ListaEnlazada();
        ListaEnlazada<Nodo> comments = new ListaEnlazada();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String line = br.readLine();
            while (line != null) {
                if (line.startsWith("U")) {
                    ListaEnlazada<String> info = replaceI(line);
                    User user = User.createUser(Integer.parseInt(info.get(0)), info.get(1), info.get(2));
                    ListaEnlazada<String> personaData = replaceI(br.readLine());
                    ListaEnlazada<String> adressData = replaceI(br.readLine());
                    ListaEnlazada<String> geoData = replaceI(br.readLine());
                    ListaEnlazada<String> companyData = replaceI(br.readLine());
                    user.setAllData(user,personaData,adressData,geoData,companyData);
                    users.add(user);
                } else if (line.startsWith("P")) {
                    ListaEnlazada<String> info = replaceI(line);
                    Post p = Post.cleanInfo(info);
                    posts.add(p);
                } else {
                    ListaEnlazada<String> info = replaceI(line);
                    Comment c = Comment.cleanInfo(info);
                    comments.add(c);
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("NO SE");
        }
        arbol.Agregar(users);
        arbol.Agregar(posts);
        arbol.Agregar(comments);
        return arbol;
    }

    /**
     * Metodo que se encarga de obtener de cada linea del archivo los valores de tipo String
     * @param line Linea del archivo a separar
     * @return {@link ListaEnlazada} que contiene todos los valores del objeto separado
     */
    public static ListaEnlazada<String> replaceI(String line) {
        int contador = 0;
        int index = 0;
        boolean isAlreadyStarted = false;
        ListaEnlazada<String> info = new ListaEnlazada();
        while (contador != line.length()) {
            if (!line.substring(contador, contador + 1).equals(",")) {
                if (!isAlreadyStarted) {
                    isAlreadyStarted = true;
                    index = contador;
                }
            } else {
                String data = line.substring(index, contador);
                if (!data.equals("U") && !data.equals("P") && !data.equals("C")) {
                    info.add(data);
                }
                index = 0;
                isAlreadyStarted = false;
            }
            contador += 1;
        }
        String data = line.substring(index, line.length());
        info.add(data);
        return info;
    }
}
