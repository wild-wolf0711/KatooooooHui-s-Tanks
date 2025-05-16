package TankGame;


import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{

    Vector<Shot> enemyShots = new Vector<>();
    private int moveCnt = 0;

    public EnemyTank(int x,int y){
        super(x, y,0);
    }


    //发射子弹并生成该子弹的线程
    public void shotBullet(){
        Shot shot = null;
        switch (direct){
            case 0:
                shot = new Shot(x + 17, y, 0);
                break;
            case 1:
                shot = new Shot(x, y + 27, 1);
                break;
            case 2:
                shot = new Shot(x + 17, y + 55, 2);
                break;
            case 3:
                shot = new Shot(x + 55, y + 27, 3);
        }

        synchronized (this) {
            enemyShots.add(shot);
            new Thread(shot).start();
        }

    }


    public int getRandomDirect(){
        return (int)(Math.random()*4);
    }


    //坦克随机移动
    public void move(){
        moveCnt++;
        setSpeed(5);
        int resDirect = getDirect();

        if(moveCnt % 5 == 0)
            resDirect = (int)(Math.random()*4);

        //判断此方向是否能继续移动
        if(isSafe(resDirect))
            return;

        //如果非同向，不移动，先转向
        if(resDirect != getDirect()){
            setDirect(resDirect);
            return;
        }

        //坦克移动
        switch (resDirect){
            case 0:
                y -= speed;
                setDirect(0);
                break;
            case 1:
                x -= speed;
                setDirect(1);
                break;
            case 2:
                y += speed;
                setDirect(2);
                break;
            case 3:
                x += speed;
                setDirect(3);
                break;
        }
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Vector<Shot> getEnemyShots() {
        return enemyShots;
    }


    //随机移动线程
    @Override
    public void run() {
        while(true){

            if(MyPanel.systemState == 0)
                break;

            if(!isLive())
                break;

            move();

            int randomSleep = (int)(Math.random()*500);
            try {
                Thread.sleep(randomSleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            shotBullet();
//            removeDeadBullets(enemyShots);
        }
    }
}
