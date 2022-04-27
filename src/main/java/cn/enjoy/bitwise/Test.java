package cn.enjoy.bitwise;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {

//        System.out.println(new BigDecimal(21001).divide(new BigDecimal(105000)).subtract(new BigDecimal(0.2)).setScale(2) );
        System.out.println(new BigDecimal(21001).divide(new BigDecimal(105000)).compareTo(new BigDecimal(0.2)));



    }

}
