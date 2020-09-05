package Coupons.Breakout;

import Coupons.comp127graphics.Rectangle;

import Coupons.comp127graphics.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class Paddle extends Rectangle {
    final int currentY = 700;
    private double currentX = 300;

    Paddle(CanvasWindow canvas){
        super(300, 700, 70, 10);
        super.setFillColor(new Color(200, 48, 16));
        super.setFilled(true);
    }
}
