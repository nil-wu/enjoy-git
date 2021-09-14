package cn.enjoy.pool;

import java.util.Random;

public class TestMyThreadPool {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool2 t = new MyThreadPool2(3, 0);

        t.execute(new MyTask("testA"));
        t.execute(new MyTask("testB"));
        t.execute(new MyTask("testC"));
        t.execute(new MyTask("testD"));
        t.execute(new MyTask("testE"));
        System.out.println(t);
        Thread.sleep(10000);
        t.destory();
        System.out.println(t);

    }

    static class MyTask implements Runnable {
        private String name;
        private Random r = new Random();

        public MyTask(String name) {
            this.name = name;
        }

        public String getName(){
            return name;
        }

        @Override
        public void run() {

        }
    }

}
