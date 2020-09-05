package Coupons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TradeMenu extends JFrame implements ActionListener {
    /**
     * This is the first screen after clicking trade in the main menu
     */
    final int WIDTH = 400;
    final int HEIGHT = 600;
    public TradeMenu(){
        this.setBounds(0, 0, WIDTH, HEIGHT);
        JPanel mainPanel = new JPanel();
        JPanel friendTradePanel = new JPanel();
        JPanel randomTradePanel = new JPanel();
        mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
        this.add(mainPanel);

        BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS);
        mainPanel.setLayout(layout);

        JButton friendTradeButton = new JButton("Friend Swap");
        JButton randomTradeButton = new JButton("Random Swap");

        friendTradeButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
        randomTradeButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
        friendTradeButton.setOpaque(true);
        randomTradeButton.setOpaque(true);


        friendTradeButton.setForeground(new Color(145, 0, 7));
        friendTradeButton.setBackground(new Color(0xDC0A00));
        randomTradeButton.setForeground(new Color(145, 0, 7));
        randomTradeButton.setBackground(new Color(0xDC0A00));

        friendTradePanel.add(friendTradeButton);
        randomTradePanel.add(randomTradeButton);

        mainPanel.add(friendTradePanel);
        mainPanel.add(randomTradePanel);

        randomTradeButton.addActionListener(this);
        friendTradeButton.addActionListener(this);
        this.setTitle("Trade");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TradeMenu();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();
        if(button.getText().equals("Friend Swap")){
            Trader traderOne = new Trader("Jerry");
            Coupon coupon1 = new Coupon("Free Slurpie");
            Coupon coupon2 = new Coupon("Free Drink");
            Coupon coupon3 = new Coupon("Free HotDog");
            /*
            Adding Coupons to trader1 and trader2's lists to be added to the menu in the constructor of TradeScreen
             */
            Trader.traderEarnsCoupon(traderOne, coupon1);
            Trader.traderOffersCoupon(traderOne, coupon1);
            Trader.traderEarnsCoupon(traderOne, coupon2);
            Trader.traderOffersCoupon(traderOne, coupon2);
            Trader traderTwo = new Trader("Larry");
            Trader.traderEarnsCoupon(traderTwo, coupon3);
            Trader.traderOffersCoupon(traderTwo, coupon3);
            this.dispose();
            new TradeScreen(traderOne, traderTwo);
        }
        //else new RandomTradeScreen
    }
}
