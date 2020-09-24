package VisualTemplates;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
        try {
            setIconImage(ImageIO.read(TemplateVentana.class.getResource("/icons/logoSS.png")));
        } catch (IOException ex) {
            Logger.getLogger(Creators.class.getName()).log(Level.SEVERE, null, ex);
        }
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
