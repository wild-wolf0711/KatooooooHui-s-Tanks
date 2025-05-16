package Grammar.Thread_;


public class TicketSystem {
    public static void main(String[] args) {
//        SellTicket1 sellTicket1 = new SellTicket1();
//        SellTicket1 sellTicket2 = new SellTicket1();
//        SellTicket1 sellTicket3 = new SellTicket1();
//        sellTicket1.start();
//        sellTicket2.start();
//        sellTicket3.start();
        SellTicket2 sellTicket2 = new SellTicket2();
        new Thread(sellTicket2).start();
        new Thread(sellTicket2).start();
        new Thread(sellTicket2).start();

    }
}

class SellTicket1 extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        runSell();
    }

    synchronized void runSell(){
        while(true){
            if(ticket <= 0)
                break;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "卖了一张票");
            System.out.println("SellTicket1还剩余" + --ticket + "张票");
        }
    }
}

class SellTicket2 implements Runnable{
    private static int ticket = 50;

    @Override
    public void run() {
        while(true){

            if(ticket <= 0)
                break;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //多线程进行

            //单线程进入
            sellTicket();
        }
    }

    /*synchronized*/ void sellTicket(){
        synchronized (this){
            if (ticket == 0) //必须判断，否则会出现多线程分开进入导致超卖的情况
                return;
            ticket--;
            System.out.println(Thread.currentThread().getName() + "卖了一张票");
            System.out.println("SellTicket2还剩余" + ticket + "张票");
        }
    }
}
