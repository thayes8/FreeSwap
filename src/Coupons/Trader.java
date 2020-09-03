package Coupons;

import java.util.ArrayList;

public class Trader {
    String name;
    ArrayList<Coupon> allCoupons;
    ArrayList<Coupon> couponToTrade;
    public Trader(String name){
        this.name = name;
        this.allCoupons = new ArrayList<>();
        this.couponToTrade = new ArrayList<>();
    }
    public static void traderEarnsCoupon(Trader trader, Coupon coupon){
        trader.allCoupons.add(coupon);
    }
    public static void traderOffersCoupon(Trader trader, Coupon coupon){
        trader.couponToTrade.add(coupon);
    }
    public static ArrayList<Coupon> showCoupons(Trader trader){
        for(Coupon coupon: trader.couponToTrade){
            System.out.println(coupon);
        }
        return trader.couponToTrade;
    }
}
