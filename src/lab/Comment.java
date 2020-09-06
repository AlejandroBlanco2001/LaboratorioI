/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.util.LinkedList;

/**
 *
 * @author alexz
 */
public class Comment {

    private final int userId;
    private final int id;
    private String title;
    private String body;

    private static String temporaryData[] = new String[4];

    private Comment(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public static Comment cleanInfo(LinkedList<String> separatedData) {
        int a = 0;
        for (String i : separatedData) {
            temporaryData[a] = i;
            a++;
        }
        int userIdTemp = Integer.parseInt(temporaryData[0]);
        int idTemp = Integer.parseInt(temporaryData[1]);
        String tittleT = temporaryData[2];
        String bodyT = temporaryData[3];
        return new Comment(userIdTemp,idTemp,tittleT,bodyT);
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
    
    

}
