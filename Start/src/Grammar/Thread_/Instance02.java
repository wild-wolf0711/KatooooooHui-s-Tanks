package Grammar.Thread_;


public class Instance02 {
    public static void main(String[] args) {
        Instance04 instance04 = new Instance04();
        Thread thread = new Thread(instance04);
        thread.start();
    }
}

class Instance03 {
}

class Instance04 extends Instance03 implements Runnable{

    @Override
    public void run() {
        int i = 0;
        while(true){
            System.out.println("第" + i++ + "次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(i == 10)
                break;
        }
    }
}
