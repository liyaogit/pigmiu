package com.pigmiu.design.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * User: yli
 * Date: 2017/6/15
 * Time: 16:00
 */
public class IteratorAdapter implements Enumeration {
    Iterator iterator;

    public IteratorAdapter(Iterator iterator) {
        this.iterator = iterator;
    }

    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    public Object nextElement() {
        return iterator.next();
    }
}
