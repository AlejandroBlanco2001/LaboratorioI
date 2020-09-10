/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alexz
 */
public class Lab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventana ventana = new Ventana();
        //ventana.setVisible(true);
        Parser p = Parser.getParser();
        LinkedList<String> tempo = p.getObjects("Comments.txt");
        System.out.println(tempo.size());
        for (String t : tempo) {
            Comment c = (Comment) p.cleanData(t);
            System.out.println("CREADOS");
        }
        tempo = p.getObjects("Posts.txt");
        for (String t : tempo) {
            Post po = (Post) p.cleanData(t);
            System.out.println("CREADO");
        }
        tempo = p.getObjects("Users.txt");
        for (String t : tempo) {
            User po = (User) p.cleanData(t);
            System.out.println(po.getID());
            System.out.println(po.getUsername());
            System.out.println("CREADO");
        }
    }
}
