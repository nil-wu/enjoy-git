package cn.enjoy.thread.ch8a.vo;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class JobInfo<R> {

    //区分唯一的工作
    private final String jobName;

    //工作的任务个数
    private final int jobLength;

    private AtomicInteger successCount;
    private AtomicInteger taskProcesserCount;
    private LinkedBlockingDeque<TaskResult<R>> taskDetailQueue;//那结果从头拿，放结果从尾部放

    private final long expireTime;

    private final ITaskProcesser<?, ?> taskProcesser;

    public JobInfo(String jobName, int jobLength,  LinkedBlockingDeque<TaskResult<R>> taskDetailQueue, long expireTime, ITaskProcesser<?, ?> taskProcesser) {
        super();
        this.jobName = jobName;
        this.jobLength = jobLength;
        this.successCount = new AtomicInteger(0);
        this.taskProcesserCount = new AtomicInteger(0);
        this.taskDetailQueue = taskDetailQueue;
        this.expireTime = expireTime;
        this.taskProcesser = taskProcesser;
    }

    public int getSuccessCount() {
        return successCount.get();
    }

    public int getTaskProcesserCount() {
        return taskProcesserCount.get();
    }

    public List<TaskResult<R>> getTaskDetail(){
        List<TaskResult<R>> taskList = new LinkedList<>();
        TaskResult<R> taskResult;
        while ((taskResult = taskDetailQueue.pollFirst()) != null) {
            taskList.add(taskResult);
        }
        return taskList;
    }

    //从业务应用角度来说，保证最终一致性即可，不需要对方法加锁
    public void addTaskResult(TaskResult<R> result) {
        if (TaskResultType.Success.equals(result.getResultType())) {
            successCount.incrementAndGet();
        }
        taskDetailQueue.addLast(result);
        taskProcesserCount.incrementAndGet();
    }

}
