package Coupons.Breakout;


import Coupons.MainMenu;
import Coupons.comp127graphics.*;
import Coupons.comp127graphics.ui.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static Coupons.Breakout.BrickHandler.*;

/**
 * Breakout, but hear me out, with exponentially growing lag and glitches when the ball is set too fast.
 * The ball is not fond of the paddles corners...Need to implement tests for those.
 * by Tommy Hayes
 *
 */
public class BreakoutGame {

    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    public ArrayList<Brick> brickList = new ArrayList<>();
    public Ball ball;
    public Coupons.comp127graphics.CanvasWindow canvas;
    private Paddle paddle;
    private int turns;
    private static int score = 0;
    private GraphicsText label;


    /**
     * User gets 3 turns before the game ends.
     * Constructs the canvas and all objects.
     * Animates the ball and paddle at once on the canvas.
     * Starts the game by requiring a click that calls run()
     */
    public BreakoutGame() {
        turns = 3;
        canvas = new Coupons.comp127graphics.CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        label = new GraphicsText("Score: " + score);
        label.setCenter(40, 20);
        canvas.add(label);
        new BrickHandler(canvas, brickList);
        paddle = new Paddle(canvas);
        ball = new Ball(0, 600, 0);
        canvas.add(paddle);
        canvas.add(ball);
        canvas.animate(() ->{
            ball.objectBounce(canvas, brickList, score, label);
            Point p = MouseInfo.getPointerInfo().getLocation();
            Coupons.comp127graphics.Point newP = new Coupons.comp127graphics.Point(p.getX(), p.getY());
            paddle.setCenter(newP.getX(), 700); });
        canvas.onClick(event -> {
             run();
        });

    }

    /**
     * Sets the velocities.
     * Checks whether or not the game is over and to reset
     * the screen after a lost life following a click by the player.
     */
    public void run(){
        if(ball.getyVelocity() == 0) {
            ball.setxVelocity(70);
            ball.setyVelocity(-70);
        }
        if(turns < 1 || brickList.isEmpty()){
            canvas.removeAll();
            newGamePopup();
            resetScreen();
            new BrickHandler(canvas, brickList);
            turns = 3;

        }
        if(ball.getY() + 20 >= CANVAS_HEIGHT) {
            turns -= 1;
            resetScreen();
            canvas.onClick(event -> run());
        }
    }
    //newGamePopup();
//    }

    /**
     * removes a ball out of bounds and resets the paddle. Makes a new ball and starts initializes velocity to zero
     */
    public void resetScreen(){
        if(ball != null) {
            canvas.remove(paddle);
            canvas.remove(ball);
        }
        paddle = new Paddle(canvas);
        ball = new Ball(0, 600, 0);
        canvas.add(paddle);
        canvas.add(ball);
        ball.setyVelocity(0);
        ball.setxVelocity(0);
    }

    /**
     * Creates a popup window when the game ends asking if the user would like to play again.
     */
    public void newGamePopup() {
        CanvasWindow popupWindow = new CanvasWindow("Game Over", 200, 100);
        Button button = new Coupons.comp127graphics.ui.Button("New Game?");
        GraphicsText scoreLabel = new GraphicsText("Score: " + score);
        scoreLabel.setCenter(100, 5);
        Button returnToMainMenu = new Button("Return to Main menu");
        returnToMainMenu.setCenter(100, 70);
        popupWindow.add(returnToMainMenu);
        returnToMainMenu.onClick(() -> {
            new MainMenu();
            JFrame frame = canvas.getWindowFrame();
            frame.dispose();
        });
        button.setCenter(100, 50);
        popupWindow.add(button);
        popupWindow.add(scoreLabel);
        button.onClick(() -> {
            turns = 3;
            score = 0;
            BreakoutGame game = new BreakoutGame();
            game.run();
        });
    }
    public static int setScore(){
        score+=1;
        return score;
    }
    public static void setVisible(BreakoutGame game, boolean truOrFals){
        JFrame frame = game.canvas.getWindowFrame();
        frame.setVisible(truOrFals);
    }



    public static void main(String[] args){
        BreakoutGame game = new BreakoutGame();
        //game.run();
    }

}
