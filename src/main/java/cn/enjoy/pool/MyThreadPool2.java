package cn.enjoy.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool2 {

    // 线程池中默认线程的个数为5
    private static int WORK_NUM = 5;

    //外部调用者传递任务的速度，要远远大于任务执行的时间
    // 队伍默认任务个数为100
    private static int TASK_COUNT = 100;

    //工作线程组
    private WorkThread[] workThreads;

    //任务队列，作为一个缓冲 阻塞队列
    private final BlockingQueue<Runnable> taskQueue;
    private final int worker_num;//用户在构造这个池，希望的启动的线程数

    public MyThreadPool2() {
        this(WORK_NUM, TASK_COUNT);
    }

    //创建线程池，work_num为线程池中工作线程的个数
    public MyThreadPool2(int work_num,int taskCount){
        if(work_num<=0) work_num = WORK_NUM;
        if(taskCount<=0) taskCount = TASK_COUNT;
        this.worker_num = work_num;
        taskQueue = new ArrayBlockingQueue<Runnable>(taskCount);

        workThreads = new WorkThread[work_num];
        for (int i = 0; i < work_num; i++) {
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
    }

    //执行任务，其实只是把任务加入任务队列，什么时候执行有线程池管理器决定
    public void execute(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //销毁线程池，刚方法保证在所有任务都完成的情况下才销毁所有线程，否则等待任务完成才销毁
    public void destory(){
        //工作线程停止工作，且置为null
        System.out.println("ready close pool....");

        for (int i = 0; i < worker_num; i++) {
            workThreads[i].stopWorker();
            workThreads[i] = null; // help gc 帮助gc
        }

        taskQueue.clear();
    }

    @Override
    public String toString() {
        return "MyThreadPool2{" +
                "taskQueue的个数=" + taskQueue.size() +
                ", worker_num=" + worker_num +
                '}';
    }

    /**
     * 内部类，工作线程
     */
    private class WorkThread extends Thread{
        @Override
        public void run(){
            Runnable r = null;
            while (!isInterrupted()) {
                try {
                    r = taskQueue.take();//如果taskQueue没有数据，那么这里是阻塞，而不是无限循环取
                    if (r != null) {
                        System.out.println(getId() + " ready exec : " + r);
                        r.run();//注意这里不是start，实际启动一个线程是要用start方法的，用run是直接在自己线程上按对象的方式调用方法
                    }
                    r = null;// help gc 帮助进行gc
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void stopWorker(){
            interrupt();
        }
    }

}
