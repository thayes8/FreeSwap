package Coupons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TradeMenu extends JFrame implements ActionListener {
    /**
     * This is the first screen after clicking trade in the main menu
     */
    public TradeMenu(){
        this.setBounds(0, 0, WIDTH, HEIGHT);
        JPanel mainPanel = new JPanel();
        JPanel friendTradePanel = new JPanel();
        JPanel randomTradePanel = new JPanel();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
