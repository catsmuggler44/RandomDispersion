import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;

public class Square extends JButton {
    private int x;
    private int y;
    Game game;

    int state = 0;
    int capacity = 10;
    static boolean clicked = false;
    public Square(int X, int Y, Game gamee){
        this.x = X;
        this.y = Y;
        this.setSize(50, 50);
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
        // this.setText(this.state+"");
        float color = (float)state / (float)capacity;
        // System.out.println(color);
        // System.out.println(value + " state" + state +"   cap" + capacity);
        // System.out.println(color);
        // int color = state * 10;
        
        this.setBackground(new Color(color, color, color));
        game.frame.repaint();
    }

    void PathingAlgorithm(){
        this.state++;
        
        if (this.state < capacity && game.running){
            updateSquare();
            Square sq = null;
            while (sq == null){
                Random r = new Random();
                sq = this.game.getSquareAt(r.nextInt(-1, 2) + this.x, r.nextInt(-1 ,2) + this.y);
            }
            
            sq.PathingAlgorithm();    
            
            // sleep
        } else {
            game.running = false;
        }
    }

}
