package Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Arbol.Comment;
import Arbol.Post;
import Arbol.User;

/**
 *
 * @author alexz
 */

public class Parser {

    private static Parser parser;
    private LinkedList<String> objetos;

    private Parser() {
        objetos = new LinkedList();
    }

    public static Parser getParser() {
        if (Parser.parser == null) {
            Parser.parser = new Parser();
        }
        return Parser.parser;
    }

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

    public Object cleanData(String dirtyJSON) {
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

    // TEST ONLY USE
    public void printBegins(Matcher radar) {
        while (radar.find()) {
            System.out.println("Found match at: " + radar.start() + " to " + radar.end());
        }
    }

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

    public LinkedList<String> getKeyInfo(Matcher radar, String JSON) {
        LinkedList<String> info = new LinkedList();
        int count = 0;
        while (radar.find()) {
            if (count % 2 != 0) {
                String cadena = JSON.substring(radar.start(),radar.end());
                if(cadena.equals("street") || cadena.equals("lat") || cadena.equals("lng") || cadena.equals("name")){
                    count--;
                }else{
                    info.add(JSON.substring(radar.start(), radar.end()));
                }
            }
            count++;
        }
        return info;
    }

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

    public Object cleanDataInsideData(LinkedList<String> info) {
        User user = User.createUser(Integer.parseInt(info.get(0)), info.get(2), info.get(3));
        user.addPersona(info);
        return user;
    }
}
