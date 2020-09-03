package Coupons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TradeScreen extends JFrame implements ActionListener {
    Trader trader1;
    Trader trader2;
    JPanel onePanel;
    JPanel twoPanel;
    JPanel bigPanel;
    JMenu itemsToTrade;
    final int WIDTH = 400;
    final int HEIGHT = 700;
    int labelHeightCounter1 = 0;
    int labelHeightCounter2 = 0;
//    ArrayList<JMenuItem> oneSelectedCoupons = new ArrayList<>();
//    ArrayList<JMenuItem> twoSelectedCoupons = new ArrayList<>();
    public TradeScreen(Trader traderOne, Trader traderTwo){
        this.trader1 = traderOne;
        this.trader2 = traderTwo;
        this.setBounds(0, 0, WIDTH, HEIGHT);
        bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.PAGE_AXIS));
        this.add(bigPanel);
        onePanel = new JPanel();
        JMenuBar menuBar = new JMenuBar();
        itemsToTrade = new JMenu("itemsToTrade");

        //itemsToTrade.addActionListener(this);
        for(Coupon coupon: traderOne.couponToTrade){
            JMenuItem item = new JMenuItem(coupon.savings);
            itemsToTrade.add(item);
            item.addActionListener(this);
        }
        menuBar.add(itemsToTrade);
        onePanel.add(menuBar);
        bigPanel.add(onePanel);

        twoPanel = new JPanel();
        JMenuBar menuBar2 = new JMenuBar();
        JMenu itemsToTrade2 = new JMenu("itemsToTrade2");
        for(Coupon coupon: traderTwo.couponToTrade){
            JMenuItem item = new JMenuItem(coupon.savings);
            itemsToTrade2.add(item);
            item.addActionListener(this);
        }
        menuBar2.add(itemsToTrade2);
        twoPanel.add(menuBar2);
        bigPanel.add(twoPanel);

        this.setVisible(true);
        this.setTitle("Select Items to Trade");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Trader traderOne = new Trader("Jerry");
        Coupon coupon1 = new Coupon("Free Slurpie");
        Coupon coupon2 = new Coupon("Free Drink");
        Coupon coupon3 = new Coupon("Free HotDog");
        Trader.traderEarnsCoupon(traderOne, coupon1);
        Trader.traderOffersCoupon(traderOne, coupon1);
        Trader.traderEarnsCoupon(traderOne, coupon2);
        Trader.traderOffersCoupon(traderOne, coupon2);
        Trader traderTwo = new Trader("Larry");
        Trader.traderEarnsCoupon(traderTwo, coupon3);
        Trader.traderOffersCoupon(traderTwo, coupon3);
        new TradeScreen(traderOne, traderTwo);
    }

    /**
     * When you click on an item to trade,
     * @param actionEvent click on a menuItem.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
            JMenuItem item = (JMenuItem) actionEvent.getSource();
            JLabel label = new JLabel(item.getText());
            ArrayList<String> array = new ArrayList<>();
            for(Coupon coupon: trader1.couponToTrade){
                array.add(coupon.savings);
            }
            boolean is1 = false;
        for (String menuItem : array) {
            if(menuItem.equals(item.getText())){
                is1 = true;
                break;
            }
        }
        if (is1) {
            onePanel.add(label);
            label.setBounds(0, labelHeightCounter1, 10, 10);
            labelHeightCounter1+=20;
            this.setVisible(true);
        }
        else{
            twoPanel.add(label);
            label.setBounds(0, labelHeightCounter2, 10, 10);
            labelHeightCounter2+=20;
            this.setVisible(true);
        }

   }

}
