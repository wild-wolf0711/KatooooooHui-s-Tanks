package Grammar.Paint;


import javax.swing.*;
import java.awt.*;

public class Draw extends JFrame{
    MyPanel mp;

    public static void main(String[] args) {
        new Draw();
    }

    public Draw(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(100,250,100,50);
        g.drawOval(200,250,100,50);
        g.drawOval(150,0,100,300);
    }
}
