package Coupons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The essential screen where the players engage in the trade.
 *
 */
public class TradeScreen extends JFrame implements ActionListener {
    Trader trader1;
    Trader trader2;
    JPanel onePanel;
    JPanel labelPanel;
    JPanel twoPanel;
    JPanel labelPanelTwo;
    JPanel bigPanel;
    JMenu itemsToTrade;
    JMenu itemsToTrade2;
    final int WIDTH = 400;
    final int HEIGHT = 700;
//    int labelHeightCounter1 = 0;
//    int labelHeightCounter2 = 0;
//    ArrayList<JMenuItem> oneSelectedCoupons = new ArrayList<>();
//    ArrayList<JMenuItem> twoSelectedCoupons = new ArrayList<>();

    /**
     *
     * @param traderOne Player 1
     * @param traderTwo Player 2
     */
    public TradeScreen(Trader traderOne, Trader traderTwo){
        this.trader1 = traderOne;
        this.trader2 = traderTwo;
        this.setBounds(0, 0, WIDTH, HEIGHT);
        bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.PAGE_AXIS));
        this.add(bigPanel);
        onePanel = new JPanel();
        onePanel.setLayout(new BoxLayout(onePanel, BoxLayout.PAGE_AXIS));

        JPanel menuPanel  = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));

        bigPanel.add(menuPanel);
        JButton button = new JButton("Return to main menu");
        menuPanel.add(button);

        button.setOpaque(true);
        button.setForeground(new Color(145, 0, 7));
        button.setBackground(new Color(244, 0, 70));
        MainMenu menu = new MainMenu();
        menu.setVisible(false);
        button.addActionListener(actionEvent -> {
            this.dispose();
            menu.setVisible(true);
        });

        JMenuBar menuBar = new JMenuBar();
        itemsToTrade = new JMenu("Trader 1 Offers: ");
        itemsToTrade.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));

        menuBar.setBackground(new Color(171, 12, 123));
        menuBar.setForeground(new Color(145, 0, 7));
        menuBar.setOpaque(true);

        for(Coupon coupon: traderOne.couponToTrade){
            JMenuItem item = new JMenuItem(coupon.savings);
            item.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
            item.setForeground(new Color(145, 0, 7));
            itemsToTrade.add(item);
            item.addActionListener(this);
        }
        menuBar.add(itemsToTrade);
        onePanel.add(menuBar);

        labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
        onePanel.add(labelPanel);

        JButton oneAcceptTrade = new JButton("Accept Trade");
        onePanel.add(oneAcceptTrade);
        oneAcceptTrade.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        bigPanel.add(onePanel);

        twoPanel = new JPanel();
        twoPanel.setLayout(new BoxLayout(twoPanel, BoxLayout.PAGE_AXIS));
        JMenuBar menuBar2 = new JMenuBar();
        menuBar2.setForeground(new Color(145, 0, 7));
        itemsToTrade2 = new JMenu("Trader 2 Offers: ");
        itemsToTrade2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        for(Coupon coupon: traderTwo.couponToTrade){
            JMenuItem item = new JMenuItem(coupon.savings);
            item.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
            item.setOpaque(true);
            item.setForeground(new Color(145, 0, 7));
            itemsToTrade2.add(item);
            item.addActionListener(this);
        }
        menuBar2.add(itemsToTrade2);



        twoPanel.add(menuBar2);

        labelPanelTwo = new JPanel();
        labelPanelTwo.setLayout(new BoxLayout(labelPanelTwo, BoxLayout.PAGE_AXIS));
        twoPanel.add(labelPanelTwo);

        JButton twoAcceptTrade = new JButton("Accept Trade");
        twoPanel.add(twoAcceptTrade);
        twoAcceptTrade.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
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
            labelPanel.add(label);
//            label.setBounds(0, labelHeightCounter1, 10, 10);
//            labelHeightCounter1+=20;
//            this.setVisible(true);
            itemsToTrade.remove(item);
        }
        else{
            labelPanelTwo.add(label);
//            label.setBounds(0, labelHeightCounter2, 10, 10);
//            labelHeightCounter2+=20;
//            this.setVisible(true);
            itemsToTrade2.remove(item);
        }
        label.setForeground(new Color(145, 0, 7));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));


   }

}
