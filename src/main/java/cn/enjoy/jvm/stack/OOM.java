package cn.enjoy.jvm.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * Xms5m -Xmx5m -XX:+PrintGC
 */
public class OOM {

    public static void main(String[] args) {
        List<Object> list = new LinkedList<>();
        int i = 0;
        while (true) {
            i++;
            if (i % 1000 == 0) {
                System.out.println("i=" + i);
            }
            list.add(new Object());
        }
    }
}
