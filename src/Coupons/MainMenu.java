package Coupons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    /**
     * The main menu you encounter when first entering the app.
     * Three buttons: Play, Trade, Redeem
     *
     */
    final int WIDTH = 400;
    final int HEIGHT = 700;
    public MainMenu(){
        this.setBounds(0, 0, WIDTH, HEIGHT);
        JPanel mainPanel = new JPanel();
        this.add(mainPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        JButton tradeButton = new JButton("Trade");

        tradeButton.addActionListener(this);
        mainPanel.add(tradeButton);


        this.setTitle("Main Menu");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
