package TankGame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable{
    //玩家以及敌人
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    static int enemyCnt = 3; //敌人数量

    //初始玩家坐标
    static final int INIT_HERO_X = 100;
    static final int INIT_HERO_Y = 100;

    //默认游戏区域大小
    static final int PANEL_WIDTH = 1000;
    static final int PANEL_HEIGHT = 750;

    //系统状态
    static int systemState = 1;


    public MyPanel() {
        //创建玩家
        hero = new Hero(INIT_HERO_X, INIT_HERO_Y);
        hero.setDirect(2);

        //创建敌人
        for (int i = 0; i < enemyCnt; i++) {

            int randomX = 0,randomY = 0;
            //用于随机生成敌人的坐标
            while(true){
                randomX = (int)(Math.random() * PANEL_WIDTH * 0.75);
                randomY = (int)(Math.random() * PANEL_HEIGHT * 0.75);

                //防止敌人出现在玩家位置
                if(Math.abs(randomX - INIT_HERO_Y) > 100 && Math.abs(randomY - INIT_HERO_Y) > 100)
                    break;
            }

            EnemyTank enemyTank = new EnemyTank(randomX, randomY);
            enemyTanks.add(enemyTank);
            new Thread(enemyTank).start();
        }

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //初始化游戏区域
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        //绘制玩家坦克
        if(hero.isLive())
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), hero.getType());

        //绘制玩家子弹
        for(Shot shot : hero.heroShots){
            if(shot.isLive())
                drawBullet(shot.getX(), shot.getY(), g);
        }

        //绘制三辆敌人的坦克
        for (int i = 0; i < enemyCnt; i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if(!enemyTank.isLive())
                continue;
            //坦克绘制
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), enemyTank.getType());

            //绘制敌人发射的子弹
            for (Shot shot : enemyTank.enemyShots) {
                if (shot.isLive())
                    drawBullet(shot.getX(), shot.getY(), g);
            }
        }

    }



    /**
     * @param x      坦克的左上角坐标
     * @param y      坦克的左上角坐标
     * @param g      画笔
     * @param direct 坦克方向(上下左右)
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        switch (type) {
            case 0: //敌人的坦克
                g.setColor(Color.CYAN);
                break;
            case 1: //玩家的坦克
                g.setColor(Color.YELLOW);
                break;
        }

        /* direct 方向如下:
         * 0 : 向上 , 1 : 向左 , 2 : 向下 , 3 : 向右*/
        int centerX;
        int centerY;
        switch (direct) {
            case 0, 2:
                g.fill3DRect(x, y, 10, 60, false);     // 绘制坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false); // 绘制坦克右边的轮子

                // 计算圆形中心点 (centerX, centerY)
                centerX = x + 20;
                centerY = y + 30;

                // 绘制坦克主体
                g.fill3DRect(x + 10, y + 10, 20, 40, false); // 车身

                // 绘制炮筒（从圆心出发）
                if (direct == 0) {
                    g.fill3DRect(centerX - 2, centerY - 25, 5, 25, true); // 炮管朝上
                } else {
                    g.fill3DRect(centerX - 2, centerY, 5, 25, true); // 炮管朝下
                }

                g.fillOval(centerX - 10, centerY - 10, 20, 20); // 圆形部分，中心点固定
                break;

            case 1, 3:
                g.fill3DRect(x, y + 10, 60, 10, false); // 绘制坦克上边的轮子
                g.fill3DRect(x, y + 40, 60, 10, false); // 绘制坦克下边的轮子

                // 计算圆形中心点 (centerX, centerY)
                centerX = x + 30;
                centerY = y + 30;

                // 绘制坦克主体
                g.fill3DRect(x + 10, y + 20, 40, 20, false); // 车身

                // 绘制炮筒（从圆心出发）
                if (direct == 3) {
                    g.fill3DRect(centerX, centerY - 2, 25, 5, true); // 炮管朝右
                } else {
                    g.fill3DRect(centerX - 25, centerY - 2, 25, 5, true); // 炮管朝左
                }

                g.fillOval(centerX - 10, centerY - 10, 20, 20); // 圆形部分，中心点固定
                break;
        }

    }



    /**
     * @param x 子弹的左上角坐标
     * @param y 子弹的左上角坐标
     * @param g 画笔
     */
    public void drawBullet(int x, int y, Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 5, 5);
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }



    private boolean isKeyAvailable = true;
    @Override
    public void keyPressed(KeyEvent e) {

        if(systemState == 0)
            return;


        Timer cooldownTimer = new Timer(500,e1 -> isKeyAvailable = true);
        cooldownTimer.setRepeats(false);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP:
                if(hero.isSafe(0))
                    return;
                if (hero.getDirect() == 0)
                    hero.moveUp();
                hero.setDirect(0);
                break;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT:
                if(hero.isSafe(1))
                    return;
                if (hero.getDirect() == 1)
                    hero.moveLeft();
                hero.setDirect(1);
                break;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT:
                if(hero.isSafe(3))
                    return;
                if (hero.getDirect() == 3)
                    hero.moveRight();
                hero.setDirect(3);
                break;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN:
                if(hero.isSafe(2))
                    return;
                if (hero.getDirect() == 2)
                    hero.moveDown();
                hero.setDirect(2);
                break;
        }


        if (e.getKeyCode() == KeyEvent.VK_J) {
            if(!isKeyAvailable) {
                return;
            }
            isKeyAvailable = false;
            cooldownTimer.restart();
            hero.shotBullet();
        }


        this.repaint();
    }



    @Override
    public void keyReleased(KeyEvent e) {

    }



    //重绘线程
    @Override
    public void run() {
        while(true){

            if(systemState == 0)
                break;

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //判断玩家还是否存活
            if(!hero.isLive()) {
                System.out.println("You Lost!");
                systemState = 0;
                break;
            }

            int deadCnt = 0;
            //判断所有敌人是否都死亡
            for(EnemyTank enemyTank : enemyTanks){
                if(enemyTank.isLive())
                    break;
                deadCnt++;
            }

            if(deadCnt == 3) {
                System.out.println("You Win!");
                systemState = 0;
                break;
            }

            //判断碰撞情况
            for(EnemyTank enemyTank : enemyTanks){
                if(!enemyTank.isLive())
                    continue;

                hero.isStrike(enemyTank);//判断坦克是否相撞

                //判断子弹是否相撞
                hero.isStrike(enemyTank.enemyShots);
                enemyTank.isStrike(hero.heroShots);

            }

            this.repaint();
        }
    }

}
