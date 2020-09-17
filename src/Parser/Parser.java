package Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Arbol.Comment;
import Arbol.Nodo;
import Arbol.Post;
import Arbol.User;

/**
 * Clase que se encarga de abstraer la idea de un Parse de JSON, se encarga de la manipulacion y extraccion de datos de los JSON con la estrucutara dada por los presentes en JSONPLACEHOLDER
 *
 * @author alexz
 */
public class Parser {

    private static Parser parser;
    private LinkedList<String> objetos;

    /**
     * Constructor Privado, con el fin de asegurar que solo el puede llamarse unicamente una vez a el mismo
     */
    private Parser() {
        objetos = new LinkedList();
    }

    /**
     * Metodo que se asegura de verificar que el Parser tenga una instancia de el mismo.
     *
     * @return parser {@link Parser} Crea y almacena la instancia de el mismo y se devuelve, en caso de existir devuelve la previamente creada
     */
    public static Parser getParser() {
        if (Parser.parser == null) {
            Parser.parser = new Parser();
        }
        return Parser.parser;
    }

    /**
     * Metodo que se encarga de separar cada objeto de un archivo JSON
     *
     * @param fileName Nombre del archivo
     * @return objetos {@code LinkedList<String>} con la division de cada objeto del JSON
     */
    public LinkedList<String> getObjects(String fileName) {
        String JSON = getData(fileName);
        if (!fileName.equals("Users.txt")) {
            Pattern pattern = Pattern.compile(RegexPattern.OBJECT.getPattern());
            Matcher matcher = pattern.matcher(JSON);
            objetos = getBegins(matcher, JSON, 0, 0);
        } else {
            Pattern pattern = Pattern.compile(RegexPattern.MULTI_OBJECTS.getPattern());
            Matcher matcher = pattern.matcher(JSON);
            objetos = getBegins(matcher, JSON);
        }
        return objetos;
    }

    /**
     * Metodo que se encarga de separar cada objeto de un archivo JSON
     *
     * @param fileName Nombre del archivo
     * @param fileRoute Ruta canonica del archivo
     * @return {@code LinkedList<String>} con la division de cada objeto del JSON
     */
    public LinkedList<String> getObjects(String fileName, String fileRoute) {
        String JSON = getData(fileRoute);
        if (!fileName.equals("Users.txt")) {
            Pattern pattern = Pattern.compile(RegexPattern.OBJECT.getPattern());
            Matcher matcher = pattern.matcher(JSON);
            objetos = getBegins(matcher, JSON, 0, 0);
        } else {
            Pattern pattern = Pattern.compile(RegexPattern.MULTI_OBJECTS.getPattern());
            Matcher matcher = pattern.matcher(JSON);
            objetos = getBegins(matcher, JSON);
        }
        return objetos;
    }

    /**
     * Metodo que se encarga de regresar a partir de un objeto de el JSON, un objeto a Java de tipo {@link Nodo}
     *
     * @param dirtyJSON Objeto individual del JSON
     * @return nodo {@link Nodo} de tipo {@link User},{@link Post} o {@link Comment} dependiendo de su primer parametro
     */
    public Nodo cleanData(String dirtyJSON) {
        Pattern pattern = Pattern.compile(RegexPattern.FIRST_PARAMETER.getPattern());
        Matcher matcher = pattern.matcher(dirtyJSON);
        LinkedList<String> code = getBegins(matcher, dirtyJSON, 1, -1);
        String identifier = code.get(0);
        pattern = Pattern.compile(RegexPattern.INSIDE_DATA.getPattern());
        matcher = pattern.matcher(dirtyJSON);
        LinkedList info = getKeyInfo(matcher, dirtyJSON);
        if (identifier.equals("userId") || identifier.equals("postId")) {
            if (identifier.equals("userId")) {
                return Post.cleanInfo(info);
            } else {
                return Comment.cleanInfo(info);
            }
        } else {
            return cleanDataInsideData(info);
        }
    }

    /**
     * Metodo que se encarga de obtener con indices de inicio y fin de una coincidencia de la Expresion regular, las cadenas que las forman para Objetos Simples como Post
     *
     * @param radar Matcher que se encarga de buscar las coincidencias de la Expresion Regular
     * @param JSON Cadena de texto con el JSON a analizar
     * @param fix_start Cantidad numerica para recortar caracteres hacia adelantes
     * @param fix_end Cantidad numerica para recortar caracteres hacia atras
     * @return separated_objetcs {@code LinkedList<String>} donde contiene cada {@code Substring} de las coincidencias, en la mayoria de los casos son objetos individuales
     */
    public LinkedList<String> getBegins(Matcher radar, String JSON, int fix_start, int fix_end) {
        LinkedList<String> separated_objects = new LinkedList();
        int i = 0;
        int inicio = 0;
        int fin = 0;
        while (radar.find()) {
            if (i == 0) {
                inicio = radar.start();
                i++;
            } else {
                fin = radar.end();
                i = 0;
                separated_objects.add(JSON.substring(inicio + fix_start, fin + fix_end));
            }
        }
        return separated_objects;
    }

    /**
     * Metodo que se encarga de obtener con indices de inicio y fin de una coincidencia de la Expresion regular, las cadenas que las forman para Objetos Complejos como User
     *
     * @param radar Matcher que se encarga de buscar las coincidencias de la Expresion Regular
     * @param JSON Cadena de texto con el JSON a analizar
     * @return separated_objetcs {@code LinkedList<String>} donde contiene cada {@code Substring} de las coincidencias, en la mayoria de los casos son objetos individuales
     */
    public LinkedList<String> getBegins(Matcher radar, String JSON) {
        LinkedList<String> separated_objects = new LinkedList();
        int i = 0;
        int inicio = 0;
        int fin = 0;
        while (radar.find()) {
            if (i == 0) {
                inicio = radar.end();
                i++;
            } else {
                if (i == 4) {
                    fin = radar.end();
                    i = 0;
                    separated_objects.add(JSON.substring(inicio, fin));
                } else {
                    i++;
                }
            }
        }
        return separated_objects;
    }

    /**
     * Metodo que se encarga de extraer los pares ordenados "Key,Data" del JSON (Excluyendo a los nombres de Objetos Complejos)
     * @param radar Matcher que se encarga de buscar las coincidencias de la Expresion Regular
     * @param JSON Cadena que representa un objeto individual de tipo JSON
     * @return info {@code LinkedList<String>} que contiene los pares "Key,Data" de cada objeto individual 
     */
    public LinkedList<String> getKeyInfo(Matcher radar, String JSON) {
        LinkedList<String> info = new LinkedList();
        int count = 0;
        while (radar.find()) {
            if (count % 2 != 0) {
                String cadena = JSON.substring(radar.start(), radar.end());
                if (cadena.equals("street") || cadena.equals("lat") || cadena.equals("lng") || cadena.equals("name")) {
                    count--;
                } else {
                    info.add(JSON.substring(radar.start(), radar.end()));
                }
            }
            count++;
        }
        return info;
    }

    /**
     * Metodo que se encarga de crear una cadena a partir de un archivo de texto plano con formato JSON
     * @param fileName Nombre del archivo
     * @return sb Cadena que representa al JSON
     */
    public String getData(String fileName) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("NO SE");
        }
        return sb.toString();
    }

    /**
     * Metodo que se encarga a partir de toda su informacion, crear un objeto de tipo {@link User} y su composicion
     * @param info Pares "Key,Data" que conforman al Objeto Complejo
     * @return user Usuario que tiene sus componentes conectados
     */
    public Nodo cleanDataInsideData(LinkedList<String> info) {
        User user = User.createUser(Integer.parseInt(info.get(0)), info.get(2), info.get(3));
        user.addPersona(info);
        return user;
    }
}
