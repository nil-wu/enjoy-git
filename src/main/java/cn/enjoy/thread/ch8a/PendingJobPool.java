package cn.enjoy.thread.ch8a;

import cn.enjoy.thread.ch8a.vo.JobInfo;

import java.util.concurrent.*;

public class PendingJobPool {

    //保守估计为cpu的核心数，如果线程数设置过大，有可能导致性能下降比较厉害（保守的最坏结果就是慢一点）
    private static final int THREAD_COUNTS = Runtime.getRuntime().availableProcessors();

    //阻塞队列的饱和策略，缺省是抛出异常
    private static BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<>(5000);

    //自定义线程池：固定大小，有界队列
    //如果用fix，虽然线程数是固定的，但是队列却是无界队列，所以这里不用fix，而是自定义
    //catch会让线程数暴增
    private static ExecutorService taskExecutor = new ThreadPoolExecutor(THREAD_COUNTS, THREAD_COUNTS, 60,
            TimeUnit.SECONDS, taskQueue);

    //job的存放容器
    private static ConcurrentHashMap<String,JobInfo<?>> jobInfoMap = new ConcurrentHashMap<>();

    //单例模式
    // 构造方法私有化
    private PendingJobPool() {
    }
    private static class JobPoolHolder{
        public static PendingJobPool pool = new PendingJobPool();
    }
    public PendingJobPool getInstance(){
        return JobPoolHolder.pool;
    }

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
