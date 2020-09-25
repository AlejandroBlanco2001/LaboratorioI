package VisualTemplates;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Clase abstracta que abstrae los comportamientos que todo JFrame debe tener
 *
 * @author alexz
 */
public abstract class TemplateVentana extends JFrame {

    /**
     * Constructor que se encarga de agregar el control por Mouse
     */
    public TemplateVentana() {
        addMouseListener();
        addMouseMotionListener();
        ImageIcon icon = new ImageIcon("Resources/icons/logoSS.png");
        Image iconI = icon.getImage();
        setIconImage(iconI);
    }

    private int posX, posY;

    /**
     * Metodo abstracto que se encarga de configurar toda la parte de GUI de cada JFrame
     */
    public abstract void setGUI();

    /**
     * Metodo abstracto que se encarga de configurar las fuentes a utilizar por cada JFrame
     */
    public abstract void setFonts();

    /**
     * Metodo abstracto que se encarga de configurar las imagenes e iconos a manejar por cada JFrame
     */
    public abstract void setImages();

    /**
     * Metodo que se encarga de guardar las posiciones cada vez que se ejecuta un click
     */
    public synchronized void addMouseListener() {
        super.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });
    }

    /**
     * Metodo que se encarga de asegurar que el JFrame pueda ser arrastable
     */
    public synchronized void addMouseMotionListener() {
        super.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                //Coloca el frame donde se encuentro el mouse mientras lo arrastras
                setLocation(e.getXOnScreen() - posX, e.getYOnScreen() - posY);
            }
        });
    }
}
