package com.pigmiu.design.composite;

import java.util.Iterator;

/**
 * User: yli
 * Date: 2017/7/17
 * Time: 14:34
 * 加入空迭代器,可以避免代码中的if语句或者instanceof
 */
public class NullIterator implements Iterator {
    public boolean hasNext() {
        return false;
    }

    public Object next() {
        return null;
    }
}
