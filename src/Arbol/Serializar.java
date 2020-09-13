/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;


/**
 *
 * @author 57301
 */
public class Serializar implements Serializable {
    public static void serializando(Arbol arbol){    
           
     try{   
            
      ObjectOutputStream Datos_Salida=new ObjectOutputStream(new FileOutputStream("C:\\Users\\57301\\Desktop\\Arbol.txt"));
      Datos_Salida.writeObject(arbol);
      Datos_Salida.close();
      
     }catch(IOException e){
              
     }
}
//    public static void deserializando(Arbol arbol){
//     try{   
//            
//      ObjectOutputStream Datos_Entrada=new ObjectOutputStream(new FileOutputStream("C:\\Users\\57301\\Desktop\\Arbol.txt"));
//      Datos_Entrada.readObject();
//      Datos_Salida.close();
//      
//     }catch(IOException e){
//              
//     }
    
    }
 
