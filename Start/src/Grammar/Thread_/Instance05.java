package Grammar.Thread_;


public class Instance05 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }
}

class T1 extends Thread{
    @Override
    public void run() {
        int cnt = 0;
        while(true){
            System.out.println("hello,world" + cnt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(++cnt == 10)
                break;
        }
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        int cnt = 0;
        while(true){
            System.out.println("hi" + cnt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(++cnt == 5)
                break;
        }
    }
}
