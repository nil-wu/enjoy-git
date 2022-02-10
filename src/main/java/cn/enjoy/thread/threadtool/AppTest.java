package cn.enjoy.thread.threadtool;

import cn.enjoy.thread.tools.SleepTools;

import java.sql.Connection;
import java.util.Random;

public class AppTest {

    private static DBPoolSemaphore dbPool = new DBPoolSemaphore();

    private static class BusiThread extends Thread {

        @Override
        public void run(){
            Random r = new Random();
            long start = System.currentTimeMillis();
            try {
                Connection connect = dbPool.takeConnect();
                System.out.println("Thread_" + Thread.currentThread().getId()
                        + "_获取数据库连接共耗时【" + (System.currentTimeMillis() - start) + "】ms.");
                SleepTools.ms(100 + r.nextInt(100));//模拟业务操作，线程有连接查询数据
                dbPool.returnConnect(connect);

            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            BusiThread thread = new BusiThread();
            thread.start();

        }
    }

}
