package org.example;

import java.math.BigDecimal;

public class Main
{
    public static void main( String[] args )
    {
        System.out.println("MmlnTask_01 started...");

        //Account acc1 = new Account(); not compiled
        Account acc = new Account("Andy");
        //acc.putCurrency(CurTypes.RUB, BigDecimal.valueOf(-100)); -- throw the error
        //System.out.println(acc);
        acc.putCurrencies(CurTypes.RUB, BigDecimal.valueOf(100));
        System.out.println(acc);
        acc.putCurrencies(CurTypes.RUB, BigDecimal.valueOf(200));
        System.out.println(acc);
        acc.putCurrencies(CurTypes.USD, BigDecimal.valueOf(50));
        System.out.println(acc);

        acc.undo();
        System.out.println(acc);
        acc.undo();
        System.out.println(acc);
        acc.undo();
        System.out.println(acc);
        acc.undo();
        System.out.println(acc);

        System.out.println("MmlnTask_01 finished...");
    }
}
