class BankCard implements Runnable{
    private int balance = 1000;
    private boolean loop = true;

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized(this){
                if(!loop)
                    break;
                int money = (int)(Math.random()*100);
                if(balance < money) {
                    System.out.println(Thread.currentThread().getName() + "在取" + money + " 的时候余额不足了");
                    loop = false;
                    break;
                }
                balance -= money;
                System.out.println(Thread.currentThread().getName() + "取了" + money);
                System.out.println("余额还有" + balance);
            }
        }
    }
}

class code{
    public static void main(String[] args) {
        BankCard bankCard = new BankCard();
        Thread thread = new Thread(bankCard);
        Thread thread1 = new Thread(bankCard);
        thread.start();
        thread1.start();
    }
}