package Coupons;

import java.util.ArrayList;
import java.util.Scanner;

public class Trading {
    public static void trade(Trader trader1, Trader trader2){
        ArrayList<Coupon> traderOneOffers = new ArrayList<>();
        ArrayList<Coupon> traderTwoOffers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        for(Coupon coupon: trader1.couponToTrade){
            System.out.println(trader1.couponToTrade);
        }
    }
}
