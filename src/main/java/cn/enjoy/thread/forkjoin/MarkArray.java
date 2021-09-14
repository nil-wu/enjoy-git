package cn.enjoy.thread.forkjoin;

import java.util.Random;

/**
 * 产生整型数组
 */
public class MarkArray {

    public static final int ARRAY_LENGTH = 40000000;

    public static int[] makeArray(){
        Random r = new Random();
        int[] result =  new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            result[i] = r.nextInt(ARRAY_LENGTH * 3);
        }
        return result;
    }

}
