package cn.enjoy.bitwise;

public class IntToBinary {

    public static void main(String[] args) throws Exception{
//        int data = 3456890;
//        System.out.println("the 4 is " + Integer.toBinaryString(data));

        //位与 &（1&1=1  1&0=0  0&0=0）
        System.out.println("the 4 is " + Integer.toBinaryString(4));
        System.out.println("the 6 is " + Integer.toBinaryString(6));
        System.out.println("the 4&6 is " + Integer.toBinaryString(4 & 6));

        //位或｜（1｜1=1  1｜0=1  0｜0=0）
        System.out.println("the 4｜6 is "  + Integer.toBinaryString(4|6));

        //位非～（～1=0  ～0=1）
        System.out.println("the ～4 is " + Integer.toBinaryString(~4));

        //位异或^（1^1=0  1^0=1  0^0=0）
        System.out.println("the 4^6 is " + Integer.toBinaryString(4^6));

        //第31位=0，为正数，第31位=1，为负数 （补码和反码）
        //有符号左移<<（正数低位补0，负数低位补1）  , 有符号右移>>（正数高位补0，负数高位补1）
        //有符号左移<<（低位补0）, 无符号右移>>>（高位补0）

        //取模 a % (2^n)等价于a&（2^n-1）
        System.out.println("the 345 % 16 is " + (345 % 16) + " or " + (345 & (16 - 1)));

        //位运算比取余速度快很多，所以很多时候用位运算取代乘法/除法/取模操作

    }


}
