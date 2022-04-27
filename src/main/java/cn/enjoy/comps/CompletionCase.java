package cn.enjoy.comps;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletionCase {
    private final int POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private final int TOTAL_TASK = Runtime.getRuntime().availableProcessors() * 10;

    public void testByQueue() throws Exception{
        long start = System.currentTimeMillis();
        AtomicInteger count = new AtomicInteger(0);

        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);
        //容器存放提交给线程池的任务，list或者map都可以
        LinkedBlockingDeque<Future<Integer>> queue = new LinkedBlockingDeque<Future<Integer>>();

        //向里面扔任务
        for (int i = 0; i < TOTAL_TASK; i++) {
            Future<Integer> future = pool.submit(new WorkTask("ExecTask" + i));
            queue.add(future);
        }

        //检查任务池任务执行结果
        for (int i = 0; i < TOTAL_TASK; i++) {
            Integer sleptTime = queue.take().get();
            System.out.println(" sleptTime "+sleptTime+" ms ...");
            count.addAndGet(sleptTime);
        }

        pool.shutdown();
        System.out.println("-------------------- tasks sleep time " + count.get() + "ms,and spend time " + (System.currentTimeMillis() - start) + " ms");
        
    }

    public static void main(String[] args) throws Exception {
        CompletionCase completionCase = new CompletionCase();
        completionCase.testByQueue();
    }


}
