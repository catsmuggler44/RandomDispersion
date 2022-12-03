import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JButton;

public class Square extends JButton {
    private int x;
    private int y;
    Game game;

    int state = 0;
    int capacity = 100;
    static boolean clicked = false;
    public Square(int X, int Y, Game gamee){
        this.x = X;
        this.y = Y;
        this.setSize(25, 25);
        this.game = gamee;
    }

    void clicked(){
        if (!clicked){
            clicked = !clicked;
            this.PathingAlgorithm();
            // this.setBackground(new Color(255, 0, 0));
        }
        // this.state++;
        // this.updateSquare();
    }

    void updateSquare(){
        System.out.println("bong2");
        this.setText(this.state+"");
        double value = (double)state / (double)capacity * 255;
        System.out.println(value + " state" + state +"   cap" + capacity);
        int color = (int) value;
        // System.out.println(color);
        // int color = state * 10;
        this.setBackground((new Color(255 - color, 255 - color, 255 - color)));
        game.frame.repaint();
    }

    void PathingAlgorithm(){
        this.state++;
        
        if (this.state <= capacity){
            updateSquare();
            Square sq = null;
            while (sq == null){
                Random r = new Random();
                sq = this.game.getSquareAt(r.nextInt(-1, 2) + this.x, r.nextInt(-1 ,2) + this.y);
            }
            System.out.println("bong1");
            sq.PathingAlgorithm();
            // sleep
        }
    }

}
