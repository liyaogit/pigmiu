package com.base;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CollectionTest {

    @Test
    public void setFormat(){
        Set<String> set = new HashSet<String>();
        set.add("1");

        Assert.assertTrue(set.contains("1"));

    }
}
