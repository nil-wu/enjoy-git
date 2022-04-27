package cn.enjoy.container;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ItemVo<T> implements Delayed {

    private Long activeTime;//到期时间，单位毫秒
    private T date;

    //activeTime是个过期时长
    public ItemVo(Long activeTime, T date) {
        super();
//        this.activeTime = activeTime;
        //将传入的时长转换为超时的时刻
        this.activeTime = TimeUnit.NANOSECONDS.convert(activeTime, TimeUnit.MILLISECONDS) + System.nanoTime();
        this.date = date;
    }

    public Long getActiveTime() {
        return activeTime;
    }

    public T getDate() {
        return date;
    }

    //返回元素的剩余时间
    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    //按照剩余时间排序
    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
