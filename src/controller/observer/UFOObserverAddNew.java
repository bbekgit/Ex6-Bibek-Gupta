package controller.observer;

import controller.Main;
import controller.InputEvent;

public class UFOObserverAddNew implements Observer {
    @Override
    public void eventReceived() {
        System.out.println("UFO died");
        // Main.addUFOWithListener(100,200  );

        InputEvent event = new InputEvent();
        event.event=new UFOCreateEvent("UFO",100,100);
        event.type=InputEvent.UFO_CREATE;
        Main.playerInputEventQueue.queue.add(event);
    }
}
