package Coupons;

import Coupons.PLAY.PlayMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    /**
     * The main menu you encounter when first entering the app.
     * Three buttons: Play, Trade, Redeem
     *
     */
    final int WIDTH = 400;
    final int HEIGHT = 600;
    public MainMenu(){
        this.setBounds(0, 0, WIDTH, HEIGHT);
        JPanel mainPanel = new JPanel();
        JPanel playPanel = new JPanel();
        JPanel tradePanel = new JPanel();
        JPanel redeemPanel = new JPanel();
        mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
        this.add(mainPanel);
        BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS);
        mainPanel.setLayout(layout);

        JButton tradeButton = new JButton("TRADE");
        JButton playButton = new JButton("PLAY");
        JButton redeemButton = new JButton("REDEEM");
        playButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 75));
        tradeButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 75));
        redeemButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 75));
        playButton.setBounds(WIDTH/3, HEIGHT/4, WIDTH, HEIGHT/3);
        redeemButton.setBounds(WIDTH/3, 2*HEIGHT/4, WIDTH, HEIGHT/3);
        tradeButton.setBounds(WIDTH/3, 3*HEIGHT/4, WIDTH, HEIGHT/3);
        //        playButton.setMinimumSize(new Dimension(WIDTH, HEIGHT/3));
//        tradeButton.setMinimumSize(new Dimension(WIDTH, HEIGHT/3));
//        redeemButton.setMinimumSize(new Dimension(WIDTH, HEIGHT/3));

        playButton.setOpaque(true);
        tradeButton.setOpaque(true);
        redeemButton.setOpaque(true);
        playButton.setForeground(new Color(145, 0, 7));
        playButton.setBackground(new Color(0xDC0A00));
        tradeButton.setForeground(new Color(145, 0, 7));
        tradeButton.setBackground(new Color(0xDC0A00));
        redeemButton.setForeground(new Color(145, 0, 7));
        redeemButton.setBackground(new Color(0xDC0A00));

        playPanel.add(playButton);
        tradePanel.add(tradeButton);
        redeemPanel.add(redeemButton);

        mainPanel.add(playPanel);
        mainPanel.add(tradePanel);
        mainPanel.add(redeemPanel);

        tradeButton.addActionListener(this);
        playButton.addActionListener(this);
        redeemButton.addActionListener(this);
        this.setTitle("Main Menu");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    JButton button = (JButton) actionEvent.getSource();
    if(button.getText().equals("TRADE")){
        this.dispose();
        new TradeMenu();
    }
    else if(button.getText().equals("PLAY")){
        this.dispose();
        new PlayMenu();
        }
        // else
    }
}
