package model.ufo;

import controller.Main;

public class UFOAnimFlying implements UFOAnimStrategy {

    UFO context;

    public UFOAnimFlying(UFO context){
        this.context=context;
    }


    @Override
    public void animate() {
        if(context.location.x>= Main.win.canvas.width){
            context.movingRight=false;

        }else if(context.location.x<=0){
            context.movingRight=true;
        }
        if(context.movingRight)context.location.x+=context.UNIT_MOVE;
        else context.location.x -=context.UNIT_MOVE;
    }
}
