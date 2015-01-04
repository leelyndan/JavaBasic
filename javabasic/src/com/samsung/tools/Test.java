package com.samsung.tools;

import java.math.BigDecimal;

public class Test
{
    public static void main(String[] args)
    {
        BigDecimal ten = BigDecimal.TEN;
        BigDecimal bigDecimal = new BigDecimal("0.3");
        System.out.println(ten.divide(bigDecimal)); 
    }
    
}
