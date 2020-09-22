package VisualTemplates;

import Arbol.Comment;
import Arbol.Nodo;
import Arbol.Post;
import Arbol.User;
import Prinicipal.ListaEnlazada;
import Prinicipal.Ventana;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

/**
 * Clase que se encarga de dibujar graficamente el Arbol
 *
 * @author Alex
 */
public class Panel extends JPanel {

    private ListaEnlazada<Shape> nodos = new ListaEnlazada();
    private ListaEnlazada<InfoFigura> nodosID = new ListaEnlazada();
    private final int radio = 15;
    private final int espacioVertical = 130;
    private Nodo raiz;
    private boolean isRoot = true;

    public Panel(Nodo raiz) {
        this.raiz = raiz;
    }

    public void setDimension(Dimension d) {
        setSize(d);
        setPreferredSize(d);
    }

    public class InfoFigura {

        private int id;
        private String type;

        public InfoFigura(int id, String type) {
            this.id = id;
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public String getType() {
            return type;
        }
    }

    /**
     * Metodo que dibuja sobre los {@code Graphics} del Panel el Arbol, dando la vista comprmida y la extendida
     *
     * @param g Graficos del Panel
     */
    @Override
    public void paintComponent(Graphics g) {
        nodos.clear();
        nodosID.clear();
        super.paintComponent(g);
        if (raiz != null) {
            if (getWidth() < 900) {
                dibujar(g, raiz, 100, 30, getWidth() / 10);
            } else {
                dibujar(g, raiz, 3350, 15, 3000);
            }
        }
    }

    /**
     * Metodo privado que se encarga de dibujar cada {@link Nodo} del Arbol
     *
     * @param g Grafico del Panel
     * @param Raiz Raiz del arbol a graficar
     * @param x Posicion en el eje X del primer Nodo
     * @param y Posicion en el eje Y del primer Nodo
     * @param espacioH Cantidad de espacio horizontal que habrá entre nodos
     */
    private void dibujar(Graphics g, Nodo Raiz, int x, int y, int espacioH) {
        int id = 0;
        String type = "";
        if (isRoot) {
            g.setColor(Ventana.menu);
            isRoot = !isRoot;
        } else if (Raiz instanceof User) {
            User u = (User) Raiz;
            id = u.getID();
            type = "User";
            g.setColor(Ventana.bigMenuThings);
        } else if (Raiz instanceof Post) {
            Post post = (Post) Raiz;
            id = post.getId();
            type = "Post";
            g.setColor(Ventana.post2);
        } else if (Raiz instanceof Comment) {
            Comment c = (Comment) Raiz;
            id = c.getId();
            type = "Comment";
            g.setColor(Ventana.post3);
        }
        g.fillOval(x - radio, y - radio, 2 * radio, 2 * radio);
        g.setColor(Color.BLACK);
        nodos.add(new Ellipse2D.Double(x - radio, y - radio, 2 * radio, 2 * radio));
        nodosID.add(new InfoFigura(id,type));
        g.drawOval(x - radio, y - radio, 2 * radio, 2 * radio);
        g.setColor(Color.white);
        g.drawString(String.valueOf(id), x - 5, y + 5);
        g.setColor(Color.BLACK);
        ListaEnlazada<Nodo> hijos = Raiz.getHijos();
        Point coordsPadre = new Point(x, y);
        if (hijos != null) {
            for (Object h : hijos) {
                Nodo hijo = (Nodo) h;
                dibujarLinea(g, x - espacioH, y + espacioVertical, coordsPadre.x, coordsPadre.y);
                dibujar(g, hijo, x - espacioH, y + espacioVertical, espacioH / hijos.size());
                x += espacioH;
            }
        }
    }

    /**
     * Metodo que dibuja las aristas que unen los diferentes {@link Nodo} del arbol
     *
     * @param g Grafico del Panel
     * @param x1 Posicion en el eje X del Nodo Hijo
     * @param y1 Posicion en el eje Y del Nodo Hijo
     * @param x2 Posicion en el eje X del Nodo Padre
     * @param y2 Posicion en el eje Y del Nodo Padre
     */
    private void dibujarLinea(Graphics g, int x1, int y1, int x2, int y2) {
        double d = Math.sqrt(espacioVertical * espacioVertical + (x2 - x1) * (x2 - x1));
        int xx1 = (int) (x1 - radio * (x1 - x2) / d);
        int yy1 = (int) (y1 - radio * (y1 - y2) / d);
        int xx2 = (int) (x2 + radio * (x1 - x2) / d);
        int yy2 = (int) (y2 + radio * (y1 - y2) / d);
        g.drawLine(xx1, yy1, xx2, yy2);

    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
        paintComponent(this.getGraphics());
    }

    public ListaEnlazada<Shape> getNodos() {
        return nodos;
    }

    public ListaEnlazada<InfoFigura> getNodosID() {
        return nodosID;
    }
    
    

}
