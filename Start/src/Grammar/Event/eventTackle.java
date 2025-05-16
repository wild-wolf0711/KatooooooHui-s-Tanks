package Grammar.Event;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class eventTackle extends JFrame{
    MyPanel mp;

    public static void main(String[] args) {
        new eventTackle();
    }

    public eventTackle(){
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener {
    private int circleX = 100;
    private int circleY = 100;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(circleX,circleY,30,30);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //处理键盘输入上下左右(wasd)
        switch (e.getKeyCode()){
            case KeyEvent.VK_W , KeyEvent.VK_UP :
                circleY -= 5;
                break;
            case KeyEvent.VK_A , KeyEvent.VK_LEFT:
                circleX -= 5;
                break;
            case KeyEvent.VK_D , KeyEvent.VK_RIGHT:
                circleX += 5;
                break;
            case KeyEvent.VK_S , KeyEvent.VK_DOWN:
                circleY += 5;
                break;
        }

        //重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
