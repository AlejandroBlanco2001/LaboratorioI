package Arbol;

import java.util.LinkedList;

/**
 *
 * @author alexz
 */
public class Post extends Nodo {

    private final int userId;
    private final int id;
    private String title;
    private String body;

    private static String temporaryData[] = new String[4];  
    
    private Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
        hijos = new LinkedList();
    }

    public static Post cleanInfo(LinkedList<String> separatedData) {
        int a = 0;
        for (String i : separatedData) {
            temporaryData[a] = i;
            a++;
        }
        int userIdTemp = Integer.parseInt(temporaryData[0]);
        int idTemp = Integer.parseInt(temporaryData[1]);
        String tittleT = temporaryData[2];
        String bodyT = temporaryData[3];
        return new Post(userIdTemp,idTemp,tittleT,bodyT);
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public static String[] getTemporaryData() {
        return temporaryData;
    }
    
    public void setComments(Nodo comment){
        if(comment != null){
            hijos.add(comment);
        }
    }
    
    // TEST ONLY USE
    public void mostrarPost(){
        StringBuffer sb = new StringBuffer();
        sb.append("\t \n" + "ID del post:" + this.id).append("\t \n" + "ID del post del user" + this.userId).append("\t \n" + "Titulo del post" + this.title).append("\t \n" + "Contenido: " +this.body);
        System.out.println(sb.toString());
        for(Nodo nodo: hijos){
            Comment c = (Comment) nodo;
            c.mostrarComment();
        }
    }

    public LinkedList<Nodo> getComments() {
        return hijos;
    }
    
    
}
