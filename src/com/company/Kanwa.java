package com.company;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Kanwa extends JPanel implements KeyListener {
    private ArrayList<Circle> circles = new ArrayList<>();
    private ArrayList<Rect> rectangles = new ArrayList<>();

    private Frame frame;
    public static int WIDTH = 580, HEIGHT = 380;
    public Kanwa(Frame frame){
        setFocusable(true);
        this.frame = frame;
        requestFocusInWindow();
        setBounds(0, 0, WIDTH, HEIGHT);
        setLayout(null);
        requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'o'){
            Circle c = new Circle();
            circles.add(c);
            add(c);
            frame.repaint();
        }
        else if(e.getKeyChar()=='k'){
            Rect r = new Rect();
            rectangles.add(r);
            add(r);
            frame.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        for(Circle c : circles){
            c.paint(g);
        }
        for(Rect r : rectangles){
            r.paint(g);
        }
    }
}