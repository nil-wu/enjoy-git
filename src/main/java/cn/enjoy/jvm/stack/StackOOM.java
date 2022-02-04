package cn.enjoy.jvm.stack;

/**
 * -Xss256k
 */
public class StackOOM {

    private int stackLength = 1;
    private void diGui(){
        stackLength++;
        diGui();
    }

    public static void main(String[] args) {
        StackOOM oom = new StackOOM();
        try {
            oom.diGui();
        } catch (Throwable e) {
            System.out.println("stackLength = " + oom.stackLength);
            e.printStackTrace();
        }

    }

}
