package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LoadableTest {

    @Test
    void load() {
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
}