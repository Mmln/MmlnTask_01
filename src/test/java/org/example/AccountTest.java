package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

class AccountTest {
    @Test
    void save() {
        Account acc = new Account("initName");
        acc.putCurrencies(CurTypes.USD, BigDecimal.valueOf(50));
        Loadable qs1 = acc.Save();
        String savedAcc = acc.toString();
        String savedName = acc.getName();
        acc.putCurrencies(CurTypes.USD, BigDecimal.valueOf(100));
        acc.setName("modifiedName");
        qs1.load();
        Assert.assertEquals(savedName, acc.getName());
        Assert.assertEquals(savedAcc, acc.toString());
    }

    @Test
    void undo() throws NothingToUndo {
        Account acc = new Account("initName");
        String oldName = acc.getName();
        acc.setName("modifiedName");
        acc.undo();
        Assert.assertEquals(oldName, acc.getName());
    }

    @Test
    void getName() {
        Account acc = new Account("initName");
        Assert.assertEquals("initName", acc.getName());
    }

    @Test
    void setName() {
        Account acc = new Account("initName");
        acc.setName("modifiedName");
        Assert.assertEquals("modifiedName", acc.getName());
    }

    @Test
    void getcurrencies() {
        Account acc1 = new Account("initName1");
        acc1.putCurrencies(CurTypes.USD, BigDecimal.valueOf(50));
        Account acc2 = new Account("initName2");
        acc2.putCurrencies(CurTypes.USD, BigDecimal.valueOf(50));
        Assert.assertEquals(acc1.getcurrencies(),acc2.getcurrencies());
    }

    @Test
    void putCurrencies() {
        Account acc1 = new Account("initName1");
        acc1.putCurrencies(CurTypes.USD, BigDecimal.valueOf(50));
        Account acc2 = new Account("initName1");
        acc2.putCurrencies(CurTypes.USD, BigDecimal.valueOf(50));
        Assert.assertEquals(acc1.toString(),acc2.toString());
    }

    @Test
    void testToString() {
        Account acc1 = new Account("initName1");
        acc1.putCurrencies(CurTypes.USD, BigDecimal.valueOf(50));
        Assert.assertNotNull(acc1.toString());
    }
}