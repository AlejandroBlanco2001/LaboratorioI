/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.util.LinkedList;

/**
 *
 * @author alexz
 */
public class Comment extends Nodo {

    private final int postId;
    private final int id;
    private String name;
    private String body;
    private String email;

    private static String temporaryData[] = new String[5];

    private Comment(int postId, int id, String name, String body, String email) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.body = body;
        this.email = email;
    }

    public static Comment cleanInfo(LinkedList<String> separatedData) {
        int a = 0;
        for (String i : separatedData) {
            temporaryData[a] = i;
            a++;
        }
        int postIdTemp = Integer.parseInt(temporaryData[0]);
        int idTemp = Integer.parseInt(temporaryData[1]);
        String tittleT = temporaryData[2];
        String bodyT = temporaryData[4];
        String emailT = temporaryData[3];
        return new Comment(postIdTemp, idTemp, tittleT, bodyT, emailT);
    }

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public String getEmail() {
        return email;
    }

    public static String[] getTemporaryData() {
        return temporaryData;
    }

    public void mostrarComment() {
        StringBuffer sb = new StringBuffer();
        sb.append("\t \t \n " + "ID del comment" + this.id).append("\t \t \n" + "post del Comment id: " +this.postId).append("\t \t \n" + "Email del comentarista" + this.email).append("\t \t \n" + "Persona del comment" + this.name).append("\t \t \n" + "Cuerpo del comment:" + this.body);
        System.out.println(sb.toString());
    }
}
