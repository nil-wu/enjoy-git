package cn.enjoy.jvm;

public class Stack {

    private Object[] elements;
    private int size = 0;//指示器，指示当前栈顶的位置

    private static final int Cap = 16;

    public Stack(){
        elements = new Object[Cap];
    }

    //入栈
    public void push(Object e) {
        elements[size] = e;
        size++;
    }

    //出栈
    public Object pop(){
        size = size -1 ;
        Object o = elements[size];
        elements[size] = null;//重点，没有这个会内存泄漏
        return o;
    }

}
