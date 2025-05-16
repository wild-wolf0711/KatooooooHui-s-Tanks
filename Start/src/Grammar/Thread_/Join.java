package Grammar.Thread_;


public class Join {
    public static void main(String[] args) throws InterruptedException{
        Dog dog = new Dog();
        dog.start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + i);
            if(i == 4)
                dog.join();
        }
    }
}

class Dog extends Thread{
    @Override
    public void run() {
        int cnt = 0;
        while(true){
            System.out.println("大狗大狗叫叫叫");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(++cnt == 50)
                break;
        }
    }
}
