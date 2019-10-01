package model;

import controller.Main;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import static controller.Main.gameData;

public class Shooter extends GameFigure {
    public final int BASE_SIZE=20;
    public final int BARREL_LEN=20;
    public Rectangle2D.Float base;
    public Line2D.Float barrel;
    public static final int UNIT_MOVE=10;
    public Shooter(int x,int y){


        super(x,y);
        base = new Rectangle2D.Float(x-BASE_SIZE/2,y-BASE_SIZE/2,BASE_SIZE,BASE_SIZE);
        barrel=new Line2D.Float(x,y,x,y-BARREL_LEN);

    }

    @Override
    public void render(Graphics2D g2) {

        g2.setColor(Color.YELLOW);
        g2.setStroke(new BasicStroke(7));  //thickness
        g2.draw(barrel);
        g2.draw(base );


    }

    @Override
    public void update() {
        MousePointer mp = (MousePointer) Main.gameData.fixedObject.get(Main.INDEX_MOUSE_POINTER);
        float tx= mp.location.x;     //pointer x position
        float ty=mp.location.y;         //pointer y position
        double rad= Math.atan2(ty-super.location.y,tx-super.location.x);    //the angle
        float barrel_y= (float)(BARREL_LEN*Math.sin(rad));  //length of the hat or bahu
        float barrel_x=(float)(BARREL_LEN*Math.cos(rad));

        barrel.x1=super.location.x;
        barrel.y1=super.location.y;
        barrel.x2=barrel_x+super.location.x;
        barrel.y2=barrel_y+super.location.y;

        base.x=location.x-BASE_SIZE/2;
        base.y=location.y-BASE_SIZE/2;
    }

    @Override
    public int getCollisionRadius() {
        return BASE_SIZE/2;
    }
}
