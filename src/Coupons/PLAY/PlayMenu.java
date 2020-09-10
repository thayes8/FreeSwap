package Coupons.PLAY;

import Coupons.Breakout.BreakoutGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMenu extends JFrame implements ActionListener {
    /**
     * First Menu after clicking Play in MainMenu.
     * User chooses which game to play by clicking a picture with a label
     */
    final int WIDTH = 400;
    final int HEIGHT = 600;
    public static JButton button;
    public BreakoutGame game;
    public PlayMenu(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel onePanel = new JPanel();
        this.setBounds(0, 0, WIDTH, HEIGHT);
        JButton playBreakout = new JButton("Play Breakout");

        playBreakout.setOpaque(true);
        playBreakout.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));
        playBreakout.setForeground(new Color(145, 0, 7));
        playBreakout.setBackground(new Color(0xDC0A00));

        playBreakout.addActionListener(this);

        onePanel.add(playBreakout);
        mainPanel.add(onePanel);

        this.add(mainPanel);
        this.setTitle("Select a Game to Play");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        game = new BreakoutGame();
        BreakoutGame.setVisible(game, false);

    }

    public static void main(String[] args) {
        new PlayMenu();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        button = (JButton) actionEvent.getSource();
        if(button.getText().equals("Play Breakout")){
            this.dispose();
            BreakoutGame.setVisible(game, true);
//            game.resetScreen();
        }



    }
}
