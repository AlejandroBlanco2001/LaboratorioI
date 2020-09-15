/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisualTemplates;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author alexz
 */
public abstract class TemplateVentana extends JFrame {

    public TemplateVentana(){
        addMouseListener(); 
        addMouseMotionListener();
    }
    
    private int posX, posY;

    public abstract void setGUI();

    public abstract void setFonts();

    public abstract void setImages();

    public synchronized void addMouseListener() {
        super.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });
    }

    public synchronized void addMouseMotionListener() {
        super.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                //Coloca el frame donde se encuentro el mouse mientras lo arrastras
                setLocation(e.getXOnScreen() - posX, e.getYOnScreen() - posY);
            }
        });
    }

}
