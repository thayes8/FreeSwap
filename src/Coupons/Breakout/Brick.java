package Coupons.Breakout;

import Coupons.comp127graphics.Rectangle;

import java.awt.*;
import java.util.ArrayList;


public class Brick extends Rectangle {

    public Brick(double x, double y, double width, double height, Color color){
        super(x, y, width, height);
        this.setFillColor(color);
        this.setFilled(true);
    }


}