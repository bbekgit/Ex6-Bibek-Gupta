package controller;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEventListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e){

        InputEvent inputEvent = new InputEvent();
        inputEvent.event=e;
        inputEvent.type= InputEvent.KEY_PRESSED;
        Main.playerInputEventQueue.queue.add(inputEvent);



        // switch (e.getKeyCode()){
        //   case KeyEvent.VK_UP: System.out.println("Up key presseed"); break;
        //   case KeyEvent.VK_DOWN: System.out.println("Down key presseed"); break;
        //   case KeyEvent.VK_LEFT: System.out.println("Left key presseed");break;
        //  case KeyEvent.VK_RIGHT: System.out.println("Right key presseed");break;



    }
}

