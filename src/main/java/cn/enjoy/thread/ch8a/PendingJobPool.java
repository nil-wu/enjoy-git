package cn.enjoy.thread.ch8a;

import cn.enjoy.thread.ch8a.vo.JobInfo;

import java.util.concurrent.*;

public class PendingJobPool {

    //保守估计
    private static final int THREAD_COUNTS = Runtime.getRuntime().availableProcessors();

    //阻塞队列的饱和策略，缺省是抛出异常
    private static BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<>(5000);

    //自定义线程池，固定大小，有界队列
    private static ExecutorService taskExecutor = new ThreadPoolExecutor(THREAD_COUNTS, THREAD_COUNTS, 60,
            TimeUnit.SECONDS, taskQueue);

    //job的存放容器
    private static ConcurrentHashMap<String,JobInfo<?>> jobInfoMap = new ConcurrentHashMap<>();

    private static class PendingTask<T, R> implements Runnable {

        private JobInfo<R> jobInfo;
        private T processData;

        public PendingTask(JobInfo<R> jobInfo, T processData) {
            super();
            this.jobInfo = jobInfo;
            this.processData = processData;
        }

        @Override
        public void run() {
            R r = null;
        }
    }

    public <T, R> void putTask(String jobName, T t) {

    }

}
