package com.samsung.tools;

import java.math.BigDecimal;

public class SalaryCalculator
{
    public static void main(String[] args)
    {
        SalaryCalculator calculator = new SalaryCalculator();
        System.out.println(calculator.calculateSalary(new BigDecimal(0), new BigDecimal(0.1), 3));
        System.out.println(calculator.calculateSalary(new BigDecimal(1000), null, 0));
        System.out.println(calculator.calculateSalary(new BigDecimal(1000), null, 1));
        System.out.println(calculator.calculateSalary(null, null, -1));
    }
    
    int number = 0;
    
    private BigDecimal calculateSalary(final BigDecimal basicSalary, final BigDecimal radio, final int ageLimit)
    {
        if (basicSalary == null)
        {
            return BigDecimal.ZERO;
        }
        if (radio == null)
        {
            return basicSalary;
        }
        if (ageLimit <= 0)
        {
            return basicSalary;
        }
        if (number >= ageLimit)
        {
            return formatBigDecimal(basicSalary, 3);
        }
        number++;
        return calculateSalary(basicSalary.multiply(BigDecimal.valueOf(1).add(radio)), radio, ageLimit);
        
    }
    
    private BigDecimal formatBigDecimal(BigDecimal number, int newScale)
    {
        if (number == null)
        {
            return BigDecimal.ZERO;
        }
        return number.setScale(newScale, BigDecimal.ROUND_HALF_DOWN);
    }
    
}
