package cn.enjoy.thread.ch8a.vo;

/**
 * 类说明：方法本身运行是否正确的结果类型
 */
public enum  TaskResultType {

    Success,Failure,Exception;
    //方法返回了业务人员需要的结果
    //方法返回了业务人员不需要的结果
    //方法执行抛出了Exception

}


