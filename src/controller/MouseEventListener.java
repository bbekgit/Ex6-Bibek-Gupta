package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventListener extends MouseAdapter {


    @Override
    public void mousePressed(MouseEvent e){

        InputEvent inputEvent= new InputEvent();
        inputEvent.event=e;
        inputEvent.type= InputEvent.MOUSE_PRESSED;
        Main.playerInputEventQueue.queue.add(inputEvent);



        //System.out.println("Co-ordinates are x:"+ e.getX()+" "+" y: "+e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e ){
        InputEvent inputEvent= new InputEvent();
        inputEvent.event=e;
        inputEvent.type=inputEvent.MOUSE_MOVED;
        Main.playerInputEventQueue.queue.add(inputEvent);

        //System.out.println("Co-ordinates are "+ "x:"+e.getX()+" y:"+e.getY());
    }



}
