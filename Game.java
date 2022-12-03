import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements ActionListener{
    Square map[][];
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    int width;
    int height;
    boolean running = true;
    public Game(int x, int y){
        this.width = x;
        this.height = y;
        this.map = new Square[y][x];
        panel.setLayout( new GridLayout(y,x));
        createMap(x, y);


        frame.add(panel);
        // frame.setSize(x,y);
        frame.setSize(x * 25, y * 25);
        frame.setVisible(true);
    }
    
    protected void createMap(int X, int Y){
        for (int y = 0; y < Y; y++){
            for (int x = 0; x < X; x++){
                Square sq = new Square(x, y, this);
                sq.addActionListener(this);
                sq.setOpaque(true);
                map[y][x] = sq;
                panel.add(sq);
            }
        }
    }

    public Square getSquareAt(int x, int y)
	{
		if (x < 0 || x >= this.width || y < 0 || y >= this.height)
			return null;

		return map[y][x];
	}

    public void actionPerformed(ActionEvent e)
	{
		// The button that has been pressed.
		Square sq = (Square)e.getSource();
		sq.clicked();
	}
}
