package Coupons.Breakout;


import Coupons.comp127graphics.*;

import java.awt.*;
import java.util.ArrayList;

public class BrickHandler {
    final static double width = 60;
    final static double height = 15;
    private static final int CANVAS_HEIGHT = 800;

    /**
     * Makes the bricks, adds to main canvas, stores each brick in the list
     * @param canvas
     * @param brickList
     */
    public BrickHandler(CanvasWindow canvas, ArrayList<Brick> brickList){
        for(int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Brick brick = new Brick(x * width, y * height + CANVAS_HEIGHT*.1, width, height, new Color(x * 20, y * 20, x*10 + y*10));
                brickList.add(brick);
                canvas.add(brick);
            }
        }
    }
}