package view;

import controller.Main;

import javax.swing.*;
import java.awt.*;

public class MyCanvas extends JPanel {


    public int width,height;

    public void render(){

        width = getSize().width;
        height = getSize().height;

        //create offscreen double buffer
        Image doubleBufferImage= createImage(width,height);
        if(doubleBufferImage==null){
            System.out.println("Critical error: doubleBufferImage is null");
            System.exit(1);

        }

        //Off screen rendering means next screen writing

        Graphics2D g2OffScreenImage = (Graphics2D) doubleBufferImage.getGraphics();
        if(g2OffScreenImage==null){
            System.out.println("Critical Error: g2OffScreen is null");
            System.exit(1);

        }

        //initialize the image buffer
        g2OffScreenImage.setBackground(Color.BLACK);
        g2OffScreenImage.clearRect(0,0,width,height);

        //render all game data
        for(var fig: Main.gameData.fixedObject){
            fig.render(g2OffScreenImage);
        }
        for(var fig: Main.gameData.enemyObject){
            fig.render(g2OffScreenImage);
        }
        for(var fig: Main.gameData.friendObject){
            fig.render(g2OffScreenImage);
        }



        //use active rendering to put the buffer image on the screen.

        Graphics gOnScreen;
        gOnScreen = this.getGraphics();
        if(gOnScreen!=null){
            //copy off screen image to onscreen
            gOnScreen.drawImage(doubleBufferImage,0,0,null);

        }

        Toolkit.getDefaultToolkit().sync();

        if(gOnScreen!=null){
            gOnScreen.dispose();
        }




    }
}
