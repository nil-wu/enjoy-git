package cn.enjoy.thread.ch8a.vo;

public interface ITaskProcesser<T,R> {

    /**
     *
     * @param data 调用方法需要使用的业务数据
     * @return 方法执行后业务方法的结果
     */
    TaskResult<R> taskExecute(T data);

}
