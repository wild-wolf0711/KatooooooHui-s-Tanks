package Grammar.Thread_;


public class DeadThreadDemo {
    public static void main(String[] args) {
        ClassicDeadThread classicDeadThread = new ClassicDeadThread(1);
        ClassicDeadThread classicDeadThread1 = new ClassicDeadThread(2);
        classicDeadThread.start();
        classicDeadThread1.start();
    }
}

class ClassicDeadThread extends Thread{
    static final Object o1 = new Object();
    static final Object o2 = new Object();
    int op;

    ClassicDeadThread(int op){
        this.op = op;
    }

    @Override
    public void run() {

        //一旦o1和o2被不同的对象拿到后,就会进入BLOCKED状态产生"死锁"现象
        if(op == 1){
            synchronized(o1){
                System.out.println(Thread.currentThread().getName() + "进入o1");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName() + "进入o2");
                }
            }
        }else{
            synchronized(o2){
                System.out.println(Thread.currentThread().getName() + "进入o2");
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName() + "进入o1");
                }
            }
        }

    }
}
