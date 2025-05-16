package Grammar.Thread_;


public class Instance01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();

        for(int i = 0;i < 80;i++) {
            System.out.println("主线程进行" + Thread.currentThread().getName());
            System.out.println("主线程第i次" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Cat extends Thread{
    @Override
    public void run() {
        while(true) {
            int cnt = 0;
            System.out.println(Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            cnt++;
            if(cnt == 80)
                break;
        }
    }
}
