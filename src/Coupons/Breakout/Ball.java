package Coupons.Breakout;


import Coupons.comp127graphics.*;

import java.awt.*;
import java.util.ArrayList;

public class Ball extends Ellipse {
    private double currentX = 300;
    private double currentY = 600;
    private int minX, minY, maxX;
    double xVelocity = 0;
    double yVelocity = 0;
    Ball(int minX, int maxX, int minY){
        super(0, 0, 20, 20);
        super.setStrokeColor(new Color(0, 0, 0, 241));
        super.setStroked(true);
        super.setFillColor(new Color(188, 33, 175));
        super.setFilled(true);
        super.setCenter(currentX, currentY);
        this.maxX = maxX;
        this.minX = minX;
        this.minY = minY;
    }

    /**
     * First, changes the ball's next coordinates
     * Then, sets the ball's new position based on these new coordinates
     * Finally, checks for wall hits for the next loop (adjusting velocity if necessary)
     *
     * @param dt time, multiplied to adjust the impact of velocity
     */
    public void updatePosition(double dt){
        currentX += xVelocity*dt;
        currentY += yVelocity*dt;
        super.setCenter(currentX, currentY);
        if(currentX <= minX || currentX + 20 >=maxX){
            xVelocity = xVelocity*-1;
        }if(currentY <= minY){
            yVelocity = yVelocity*-1;
        }
//        super.setCenter(currentX, currentY);
    }

    /**
     * Checks for collisions with objects and calls the balls, adjusts the proper velocity, and calls updatePosition()
     *
     * @param canvas takes in a canvas from the main constructor
     * @param brickArrayList modifies the arraylist holding the bricks
     */
    public void objectBounce(CanvasWindow canvas, ArrayList<Brick> brickArrayList, int score, GraphicsText label) {
        if (canvas.getElementAt(currentX -.001, currentY+10) != null) {
            if(brickArrayList.contains(canvas.getElementAt(currentX -.001, currentY+10))){
                canvas.remove(canvas.getElementAt(currentX -.001, currentY+10));
                brickArrayList.remove(canvas.getElementAt(currentX -.001, currentY+10));
                label.setText("Score: " + BreakoutGame.setScore());
            }
            xVelocity = xVelocity * -1;
            updatePosition(.1);
        }
        if(canvas.getElementAt(currentX + 20.001, currentY+10) != null){
            if(brickArrayList.contains(canvas.getElementAt(currentX +20.001, currentY+10))){
                canvas.remove(canvas.getElementAt(currentX +20.001, currentY+10));
                brickArrayList.remove(canvas.getElementAt(currentX +20.001, currentY+10));
                label.setText("Score: " + BreakoutGame.setScore());
            }
            xVelocity = xVelocity * -1;
            updatePosition(.1);
        }
        if (canvas.getElementAt(currentX+10, currentY - .001) != null) {
            if(brickArrayList.contains(canvas.getElementAt(currentX+10, currentY-.001))){
                canvas.remove(canvas.getElementAt(currentX +10, currentY-.001));
                brickArrayList.remove(canvas.getElementAt(currentX +10, currentY-.001));
                label.setText("Score: " + BreakoutGame.setScore());
            }yVelocity = yVelocity * -1;
            updatePosition(.1);
        }
        if(canvas.getElementAt(currentX +10, currentY + 20.001) != null){
            if(brickArrayList.contains(canvas.getElementAt(currentX +10, currentY+ 20.001))){
                canvas.remove(canvas.getElementAt(currentX+10, currentY+ 20.001));
                brickArrayList.remove(canvas.getElementAt(currentX +10, currentY+ 20.001));
                label.setText("Score: " + BreakoutGame.setScore());
            }
            yVelocity = yVelocity * -1;
            updatePosition(.1);
        }
        else{
            updatePosition(.1);
        }

    }
    public void setxVelocity(double speed){
        xVelocity = speed;
    }
    public void setyVelocity(double speed){
        yVelocity = speed;
    }
    public double getyVelocity(){
        return yVelocity;
    }
}
