package TankGame;


import java.util.Vector;

public class Shot implements Runnable{
    private int x; //子弹坐标
    private int y; // 子弹坐标
    private int direct;
    private int speed = 10;
    private boolean live = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }



    //用于判断子弹是否撞上碰撞箱
    public boolean isStrike(int x1,int y1, int x2, int y2){
        if(y + 5 > y1 && y + 5 < y2 && ((x > x1 && x < x2) || (x + 5 > x1 && x + 5 < x2)))
            return true;
        if(y > y1 && y < y2 && ((x > x1 && x < x2) || (x + 5 > x1 && x + 5 < x2)))
            return true;
        if(x + 5 > x1 && x + 5 < x2 && ((y > y1 && y < y2) || (y + 5 > y1 && y + 5 < y2)))
            return true;
        if(x > x1 && x < x2 && ((y > y1 && y < y2) || (y + 5 > y1 && y + 5 < y2)))
            return true;
        return false;
    }


    //子弹移动线程
    @Override
    public void run() {
        while(true){

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(x <= 0 || y <= 0 || y >= MyPanel.PANEL_HEIGHT || x >= MyPanel.PANEL_WIDTH) {
                live = false;
                break;
            }

            /* direct 方向如下:
             * 0 : 向上 , 1 : 向左 , 2 : 向下 , 3 : 向右*/
            switch(direct){
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x -= speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x += speed;
                    break;
            }
            //小球移动

        }
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
