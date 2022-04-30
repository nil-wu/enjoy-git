package cn.enjoy.thread.ch8a;

import cn.enjoy.thread.ch8a.vo.ITaskProcesser;
import cn.enjoy.thread.ch8a.vo.JobInfo;
import cn.enjoy.thread.ch8a.vo.TaskResult;
import cn.enjoy.thread.ch8a.vo.TaskResultType;

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

    //注册Job
    public <R> void registerJob(String jobName, int jobLength, ITaskProcesser<?, ?> taskProcesser, long expireTime) {
        JobInfo<R> jobInfo = new JobInfo<>(jobName, jobLength, expireTime, taskProcesser);
        if (jobInfoMap.putIfAbsent(jobName, jobInfo) != null) {
            throw new RuntimeException(jobName + "已经注册了！");
        }
    }

    //对工作中的任务进行包装，提交给线程池使用，并处理任务的结果，写入缓存以供查询
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
            ITaskProcesser<T, R> taskProcesser = (ITaskProcesser<T, R>) jobInfo.getTaskProcesser();
            TaskResult<R> result = null;
            try {
                //调用业务人员实现的具体方法
                result = taskProcesser.taskExecute(processData);
                //要做检查，防止开发人员处理不当
                if (result == null) {
                    result = new TaskResult<R>(TaskResultType.Exception,r,"result is null");
                }
                if (result.getResultType() == null) {
                    if (result.getReason() == null) {
                        result = new TaskResult<R>(TaskResultType.Exception,r,"reason is null");
                    }else{
                        result = new TaskResult<R>(TaskResultType.Exception, r, "result is null,but reason :" + result.getReason());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = new TaskResult<R>(TaskResultType.Exception, r, e.getMessage());
            }finally {
                jobInfo.addTaskResult(result);
            }
        }
    }

    //健壮性，判空
    private <R> JobInfo<R> getJob(String jobName) {
        JobInfo<R> jobInfo = (JobInfo<R>) jobInfoMap.get(jobName);
        if (null == jobInfo) {
            throw new RuntimeException(jobName + "是个非法任务。");
        }
        return jobInfo;
    }

    //调用者提交工作中的任务
    public <T, R> void putTask(String jobName, T t) {
        JobInfo<R> jobInfo = getJob(jobName);
        PendingTask<T, R> task = new PendingTask<T, R>(jobInfo, t);
        taskExecutor.execute(task);
    }

}
