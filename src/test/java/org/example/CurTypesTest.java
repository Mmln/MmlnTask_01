package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurTypesTest {

    @Test
    void values() {
        Assert.assertNotNull(CurTypes.USD.values());
    }

    @Test
    void valueOf() {
        Assert.assertEquals(CurTypes.USD,CurTypes.USD.valueOf("USD"));
    }
}