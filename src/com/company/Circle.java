package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Circle extends JPanel {

    private int size;
    private int x,y;
    private Color color;
    public Circle(){
        Random rng = new Random();
        size = rng.nextInt(50)+10;
        x = rng.nextInt(Kanwa.WIDTH-size);
        y = rng.nextInt(Kanwa.HEIGHT-size);
        color=new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(color);
        g2d.fillOval(x,y,size , size);
    }
}
