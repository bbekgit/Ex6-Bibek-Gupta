package view;

import controller.Main;
import controller.KeyEventListener;
import controller.MouseEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    public MyCanvas canvas;

    public void init() {

        setSize(700, 500);
        setLocation(200, 100);
        setTitle("Game Engine");


        canvas = new MyCanvas();
        var cp = getContentPane();
        cp.add(BorderLayout.CENTER, canvas);

        MouseEventListener listener = new MouseEventListener();
        canvas.addMouseListener(listener);
        canvas.addMouseMotionListener(listener);

        KeyEventListener keyEventListener = new KeyEventListener();
        canvas.addKeyListener(keyEventListener);
        canvas.setFocusable(true);


        JPanel panel = new JPanel();
        cp.add(BorderLayout.SOUTH, panel);

        JButton button = new JButton("Start");
        button.setFocusable(false);
        panel.add(button);


        //annoymous class
        /** button.addActionListener(new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
        System.out.println("Button Clicked");

        }
        }); */

        //Lamda class
        button.addActionListener(e ->

                {

                    if(!Main.running)
                    {
                        button.setText("Quit");
                        Main.running=true;
                    }
                    else
                    {

                        System.exit(0);
                    }


                }


        );


    }


}


