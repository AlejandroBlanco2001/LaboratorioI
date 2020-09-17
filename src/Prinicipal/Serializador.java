package Prinicipal;

import Arbol.Arbol;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * Clase que contiene el sistema de Serializacion del Arbol
 * @author Shalem Janna
 */

// Idea del path por https://stackoverflow.com/questions/1080634/how-to-get-the-desktop-path-in-java por Princely Royan
public class Serializador implements Serializable {

    public static String desktopPath = System.getProperty("user.home") + "\\" + "Desktop";

    public static void serialize(Arbol arbol) {

        try {
            ObjectOutputStream Datos_Salida = new ObjectOutputStream(new FileOutputStream(desktopPath + "\\Arbol.txt"));
            Datos_Salida.writeObject(arbol);
            Datos_Salida.close();
        } catch (IOException e) {

        }
    }

    public static Arbol recover(String ruta) throws ClassNotFoundException {
        try {
            ObjectInputStream Datos_Entrada = new ObjectInputStream(new FileInputStream(ruta));
            return (Arbol)Datos_Entrada.readObject();
        } catch (IOException e) {

        }
        return null;
    }
}
