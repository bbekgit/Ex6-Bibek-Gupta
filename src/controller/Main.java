package controller;

import controller.observer.UFOObserverAddNew;
import model.*;
import model.ufo.UFO;
import view.MyWindow;

import javax.swing.*;
import java.awt.*;

public class Main {


    public static MyWindow win;
    public static GameData gameData;
    public static boolean running;
    public static int FPS = 20;
    public static PlayerInputEventQueue playerInputEventQueue;
    public static int INDEX_MOUSE_POINTER = 0;
    public static int INDEX_SHOOTER = 1;

    public static void main(String[] args) {

        win = new MyWindow();
        win.init();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);


        gameData = new GameData();
        playerInputEventQueue = new PlayerInputEventQueue();


        startScreen();
        initGame();
        gameLoop();


    }

    static void startScreen() {

        Font font = new Font("Courier new", Font.BOLD, 40);
        gameData.fixedObject.add(new Text("Press the start button", 100, 200, Color.yellow, font));

        while (!running) {

            Main.win.canvas.render();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    static void initGame() {

        gameData.clear();

        gameData.fixedObject.add(new MousePointer(50, 50));

        int x = Main.win.getWidth() / 2;
        int y = Main.win.getHeight() - 100;
        gameData.fixedObject.add(new Shooter(x, y));



        addUFOWithListener(100,100);




    }
    public static void addUFOWithListener(int x,int y){
        var ufo=new UFO(x,y);
        ufo.attachListener(new UFOObserverAddNew());
        gameData.enemyObject.add(ufo);



    }


    //gameloop
    static void gameLoop() {
        running = true;
        while (running) {


            long startTime = System.currentTimeMillis();

            playerInputEventQueue.process();
            processCollision();
            gameData.update();
            win.canvas.render();
            long stopTime = System.currentTimeMillis();

            long timeSpent = stopTime - startTime;

            long sleepTime = (long) (700.0 / FPS - timeSpent);

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    static void processCollision() {

        var shooter = (Shooter) Main.gameData.fixedObject.get(INDEX_SHOOTER);
        for (var enemy : Main.gameData.enemyObject) {
            if (shooter.collideWith(enemy)) {
                ++shooter.hitCount;
                ++enemy.hitCount;

            }

        }
        for (var friend : Main.gameData.friendObject) {
            for (var enemy : Main.gameData.enemyObject) {
                if (friend.collideWith(enemy)) {

                    ++friend.hitCount;
                    ++enemy.hitCount;
                }
            }
        }


    }


}
