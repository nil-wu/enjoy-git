package cn.enjoy.thread.ch8a.vo;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class JobInfo<R> {

    //区分唯一的工作
    private final String jobName;

    //工作的任务个数
    private final int jobLength;

    private AtomicInteger successCount;
    private AtomicInteger taskProcesserCount;
    private LinkedBlockingDeque<TaskResult<R>> taskDetailQueue;

    private final long expireTime;

    private final ITaskProcesser<?, ?> taskProcesser;

}
