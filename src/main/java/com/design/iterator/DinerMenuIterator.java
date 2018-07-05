package com.design.iterator;

import java.util.Iterator;

/**
 * User: yli
 * Date: 2017/7/14
 * Time: 16:49
 */
public class DinerMenuIterator implements Iterator{
    MenuItem[] items;
    int position = 0;
    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    public boolean hasNext() {
        if (position >= items.length || items[position] ==null){
            return false;
        }else {
            return true;
        }
    }

    public Object next() {
        MenuItem item = items[position];
        position ++;
        return item;
    }

    public void remove() {
        if(position<0){
            throw new IllegalStateException("啥都没有怎么删");
        }
        if (items[position-1]!=null){
            for(int i = position-1; i<items.length-1; i++){
                items[i]=items[i+1];
            }
            items[items.length-1] = null;
        }
    }
}
