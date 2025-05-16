package TankGame;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Tank {
    protected int x;
    protected int y;
    protected int direct;
    protected int type;
    protected int speed = 5;
    protected boolean live = true;


    public Tank(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }


    //用于判断坦克在-direct-方向上能否继续移动
    public boolean isSafe(int direct){
        int up_allowedError = 10;
        int left_allowedError = 10;
        int down_allowedError = 80;
        int right_allowedError = 70;

        switch(direct){
            case 0:
                if(y - up_allowedError - speed < 0)
                    return true;
                break;
            case 1:
                if(x - left_allowedError - speed < 0)
                    return true;
                break;
            case 2:
                if(y + down_allowedError + speed > MyPanel.PANEL_HEIGHT)
                    return true;
                break;
            case 3:
                if(x + right_allowedError + speed > MyPanel.PANEL_WIDTH)
                    return true;
                break;
        }

        return false;
    }



    //用于得到一个储存坦克对角点的HashMap
    public HashMap<Integer,Integer> getCollisionBox(){
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(x,y);
        if(direct == 0 || direct == 2)
            map.put(x + 40, y + 60);
        else
            map.put(x + 60, y + 40);

        return map;
    }



    //用于判断子弹是否撞上了坦克
    public boolean isStrike(Vector<Shot> shots){
        HashMap<Integer,Integer> map = getCollisionBox();
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        int px = 0,py = 0;
        for(Map.Entry<Integer,Integer> entry : set){
            if(entry.getKey() != x) {
                px = entry.getKey();
                py = entry.getValue();
            }
        }

        int flag = 0;
        for(Shot shot : shots){
            if(!shot.isLive())
                continue;
            if(shot.isStrike(x,y,px,py)) {
                shot.setLive(false);
                live = false;
                flag = 1;
            }
        }

        return flag == 1;
    }


    public boolean isStrike(Tank tank){
        HashMap<Integer,Integer> map = getCollisionBox();
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        int px = 0,py = 0;
        for(Map.Entry<Integer,Integer> entry : set){
            if(entry.getKey() != x) {
                px = entry.getKey();
                py = entry.getValue();
            }
        }

        HashMap<Integer,Integer> map2 = tank.getCollisionBox();
        Set<Map.Entry<Integer,Integer>> set2 = map2.entrySet();
        int px2 = 0,py2 = 0;
        for(Map.Entry<Integer,Integer> entry : set2){
            if(entry.getKey() != tank.getX()) {
                px2 = entry.getKey();
                py2 = entry.getValue();
            }
        }

        if(tank.getX() > px || py2 < y || px2 < x || tank.getY() > py)
            return false;

        live = false;
        tank.setLive(false);

        return true;
    }



    //移除死亡的子弹
    public void removeDeadBullets(Vector<Shot> shots){
        for(Shot shot : shots){
            if(!shot.isLive())
                shots.remove(shot);
        }
    }


    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void moveUp(){
        y -= speed;
    }

    public void moveDown(){
        y += speed;
    }

    public void moveLeft(){
        x -= speed;
    }

    public void moveRight(){
        x += speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
