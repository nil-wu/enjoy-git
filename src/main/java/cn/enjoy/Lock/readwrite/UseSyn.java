package cn.enjoy.Lock.readwrite;

import cn.enjoy.thread.tools.SleepTools;

/**
 * 类说明：用内置锁实现商品服务接口
 */
public class UseSyn implements GoodsService {

    private GoodsInfo goodsInfo;

    public UseSyn(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    @Override
    public GoodsInfo getNum() {
        SleepTools.ms(5);
        return this.goodsInfo;
    }

    @Override
    public void setNum(int number) {
        SleepTools.ms(5);
        goodsInfo.changeNumber(number);
    }
}
