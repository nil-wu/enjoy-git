package cn.enjoy.thread.ch8a.vo;

/**
 * 类说明：任务处理返回结果实体类
 * @param <R>
 */
public class TaskResult<R> {

    private final TaskResultType resultType;
    private final R returnValue;//方法的业务结果数据
    private final String reason;//这里放方法失败的原因

    public TaskResultType getResultType() {
        return resultType;
    }

    public R getReturnValue() {
        return returnValue;
    }

    public String getReason() {
        return reason;
    }

    public TaskResult(TaskResultType resultType, R returnValue, String reason) {
        super();
        this.resultType = resultType;
        this.returnValue = returnValue;
        this.reason = reason;
    }

    public TaskResult(TaskResultType resultType, R returnValue) {
        this.resultType = resultType;
        this.returnValue = returnValue;
        this.reason = "Success";
    }
}
