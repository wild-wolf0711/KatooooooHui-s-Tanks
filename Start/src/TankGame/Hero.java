package TankGame;


import java.util.Vector;

public class Hero extends Tank{
    Vector<Shot> heroShots = new Vector<>();

    public Hero(int x,int y){
        super(x, y,1);
    }


    public Vector<Shot> getHeroShots() {
        return heroShots;
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
            heroShots.add(shot);
//            removeDeadBullets(heroShots);
            new Thread(shot).start();
        }


    }
}
