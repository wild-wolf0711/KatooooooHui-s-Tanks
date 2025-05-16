package Grammar.Thread_;


public class ThreadState {
    public static void main(String[] args) throws InterruptedException {

        Dog1 dog1 = new Dog1();
        dog1.start();

        do{
            System.out.println(dog1.getState());
            Thread.sleep(100);
        }while(dog1.getState() != Thread.State.TERMINATED);

        System.out.println(dog1.getState());
    }
}

class Dog1 extends Thread{
    @Override
    public void run() {
        int cnt = 0;
        while(true){
            System.out.println("大狗大狗叫叫叫");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(++cnt == 10)
                break;
        }
    }
}
