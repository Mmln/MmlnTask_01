package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void execute() {
        Account acc = new Account("Andy");
        acc.putCurrencies(CurTypes.RUB, BigDecimal.valueOf(100));
        String savedAccount = acc.toString();
        acc.putCurrencies(CurTypes.RUB, BigDecimal.valueOf(200));
        acc.undo();
        Assert.assertEquals(savedAccount,acc.toString());
    }
}