package com.company;

import com.company.Circle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UI extends JFrame{

    private Kanwa kanwa = new Kanwa(this);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UI("Running Button").start();
        });
    }

    private void start() {
        setVisible(true);
    }

    public UI(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.setBounds(0, 0, 580, 380);
        setContentPane(panel);
        panel.setLayout(null);

        JButton RunningButton = new JButton("Run");
        JButton ResetButton = new JButton("Reset");
        Rectangle tempReset = new Rectangle();

        RunningButton.setBounds(20, 70, 100, 25);
        ResetButton.setBounds(130, 70, 100, 25);

        tempReset.x = ResetButton.getX() - ResetButton.getWidth();
        tempReset.y = ResetButton.getY() - ResetButton.getHeight();
        tempReset.width = 2 * ResetButton.getWidth();
        tempReset.height = 2 * ResetButton.getHeight();

        RunningButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (!e.isShiftDown()) {
                    var rec = panel.getBounds();
                    var random = new Random();
                    Rectangle newRec = new Rectangle();

                    do {
                        newRec.x = random.nextInt(rec.width - RunningButton.getWidth());
                        newRec.y = random.nextInt(rec.height - RunningButton.getHeight());
                    }
                    while (tempReset.contains(newRec.x, newRec.y));
                    newRec.width = RunningButton.getWidth();
                    newRec.height = RunningButton.getHeight();
                    RunningButton.setBounds(newRec);
                }
            }
        });
        add(RunningButton);
        ResetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                RunningButton.setLocation(20, 70);
            }
        });
        panel.add(ResetButton);

        panel.addKeyListener(kanwa);
        panel.add(kanwa);


    }
}

