package cn.enjoy.jvm.stack;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/**
 * -Xms10m -Xmx10m -XX:+PrintGC
 */
public class TestSoftRef {

    public static class User{
        public int id = 0;
        public String name = "";

        public User(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        User user = new User(1, "Mark");
        SoftReference<User> userSoft = new SoftReference<>(user);//软引用
//        WeakReference<User> userSoft = new WeakReference<>(user);//弱引用
        user = null;

        System.out.println(userSoft.get());
        System.gc();
        System.out.println("AfterGc");
        System.out.println(userSoft.get());//垃圾回收的时候不会回收软引用
        LinkedList<byte[]> list = new LinkedList<>();

        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("****************" + userSoft.get());
                list.add(new byte[1024 * 1024 * 1]);
            }
        } catch (Throwable e) {
            System.out.println("***************"+userSoft.get());//oom时会先回收软引用
        }
    }
}
