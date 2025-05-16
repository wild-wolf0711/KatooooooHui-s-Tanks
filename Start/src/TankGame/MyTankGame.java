package TankGame;


import javax.swing.*;

public class MyTankGame extends JFrame {
    MyPanel mp;

    public static void main(String[] args) {
        MyTankGame myTankGame = new MyTankGame();
    }

    public MyTankGame(){
        mp = new MyPanel();

        //启动一个重绘线程
        new Thread(mp).start();

        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(MyPanel.PANEL_WIDTH,MyPanel.PANEL_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
