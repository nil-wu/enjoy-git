package cn.enjoy.thread.forkjoin;

import cn.enjoy.thread.tools.SleepTools;

public class SumNormal {

    public static void main(String[] args) {
        int count = 0;
        int[] src = MarkArray.makeArray();

        long start = System.currentTimeMillis();
        for (int i = 0; i < src.length; i++) {
//            SleepTools.ms(1);
            count = count + src[i];
        }

        System.out.println("The count is " + count + " spend time:" + (System.currentTimeMillis() - start) + "ms");
        
    }

}
