package cn.enjoy.jvm.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * -XX:MaxMetaspaceSize=3M
 */
public class MetaSpace {

    public static void main(String[] args) {
        /* java.lang.OutOfMemoryError  */
        List<Object> list = new LinkedList<>();
        int i = 0;
        while (true) {
            i++;
            if (i % 1000 == 0) {
                System.out.println("i=" + i);
            }
            list.add(new Object());
        }

//        /* java.lang.OutOfMemoryError: Java heap space */
//        String[] strings = new String[100000000];

    }
}
