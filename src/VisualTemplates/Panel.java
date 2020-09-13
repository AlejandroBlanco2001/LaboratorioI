/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisualTemplates;

import Arbol.Arbol;
import Arbol.Nodo;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public class Panel extends JPanel {

    private int radio = 15;
    private int espacioVertical = 50;
    private Arbol arbol;
    private HashMap<Nodo, Point> coordenadas;
    private LinkedList<Nodo> hijos;

    public Panel(Arbol arbol) {
        this.arbol = arbol;
        this.coordenadas = new HashMap<Nodo, Point>();
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (arbol != null && arbol.raiz != null) {
            dibujar(g, arbol.raiz, getWidth() / 2, 30, getWidth() / 5);
        }
    }

    private void dibujar(Graphics g, Nodo Raiz, int x, int y, int espacioH) {
        g.drawOval(x - radio, y - radio, 2 * radio, 2 * radio);

        LinkedList<Nodo> hijos = Raiz.getHijos();
        Nodo padre = Raiz;
        coordenadas.put(Raiz, new Point(x, y));

        if (hijos != null) {
            for (Nodo hijo : hijos) {
                Point punto = coordenadas.get(padre);
                dibujarLinea(g, x - espacioH, y + espacioVertical, punto.x, punto.y);

                dibujar(g, hijo, x - espacioH, y + espacioVertical, espacioH / hijos.size());
                x += espacioH;

            }
        }
    }

    private void dibujarLinea(Graphics g, int x1, int y1, int x2, int y2) {
        double d = Math.sqrt(espacioVertical * espacioVertical + (x2 - x1) * (x2 - x1));
        int xx1 = (int) (x1 - radio * (x1 - x2) / d);
        int yy1 = (int) (y1 - radio * (y1 - y2) / d);
        int xx2 = (int) (x2 + radio * (x1 - x2) / d);
        int yy2 = (int) (y2 + radio * (y1 - y2) / d);

        g.drawLine(xx1, yy1, xx2, yy2);

    }

}
