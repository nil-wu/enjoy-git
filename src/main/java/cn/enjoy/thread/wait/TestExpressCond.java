package cn.enjoy.thread.wait;

public class TestExpressCond {

    private static ExpressCond express = new ExpressCond(0, Express.CITY);

    private static class CheckKm extends Thread{

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getId()+" km线程启动");
            express.waitKm();
        }
    }

    private static class CheckSite extends Thread{

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getId()+" site线程启动");
            express.waitSite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {//三个线程
            new CheckSite().start();
        }
        for (int i = 0; i < 3; i++) {
            new CheckKm().start();
        }
        Thread.sleep(1000);//保证上面6个线程都能启动起来
        express.changeKm();//快递地点变化
        express.changeSite();

    }

}
