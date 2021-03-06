package cn.enjoy.jvm.stack;

/**
 *  -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations -XX:-UserTLAB
 */
public class StackAlloc {

    private static class User{
        public int id = 0;
        public String name = "";
    }

    public static void alloc(){
        User user = new User();
        user.id = 5;
        user.name = "mark";
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println((e - b) + "ms");
    }

}
