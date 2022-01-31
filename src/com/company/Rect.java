package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Rect extends JPanel {

    private int width, height;
    private int x,y;
    private Color color;
    public Rect(){
        Random rng = new Random();
        width = rng.nextInt(50)+10;
        height = rng.nextInt(50)+10;
        x = rng.nextInt(Kanwa.WIDTH-width);
        y = rng.nextInt(Kanwa.HEIGHT-height);
        color=new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(color);
        g2d.fillRect(x,y,width , height);
    }
}