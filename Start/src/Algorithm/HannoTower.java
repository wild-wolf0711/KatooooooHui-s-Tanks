package Algorithm;

public class HannoTower {

    public void move(int num,char a,char b,char c){
        if(num == 1)
            System.out.println(a + "->" + c);
        else{
            move(num-1,a,c,b);
            System.out.println(a + "->" + c);
            move(num-1,b,a,c);
        }
    }

    public static void main(String[] args){
        HannoTower t = new HannoTower();
        t.move(3,'a','b','c');
    }

}

