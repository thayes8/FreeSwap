package Coupons;

/**
 * Coupon Constructor w/ savings String description/label
 */
public class Coupon{
    String savings;
    public Coupon(String deal){
        this.savings = deal;
    }
    public String getSavings(){
        return savings;
    }
}
