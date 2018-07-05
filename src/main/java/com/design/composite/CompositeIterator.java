package com.design.composite;

import java.util.Iterator;
import java.util.Stack;

/**
 * User: yli
 * Date: 2017/7/17
 * Time: 14:38
 * 递归遍历
 */
public class CompositeIterator implements Iterator {
    Stack stack = new Stack();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    public boolean hasNext() {
        if(stack.empty()){
            return false;
        } else {
            Iterator iterator = (Iterator) stack.peek();
            if(!iterator.hasNext()){
                stack.pop();
                return hasNext();
            }else {
                return true;
            }
        }
    }

    public Object next() {
       if(hasNext()){
           Iterator iterator = (Iterator) stack.peek();
           MenuComponent component = (MenuComponent) iterator.next();
//           if(component instanceof Menu){
               stack.push(component.createIterator());
//           }
           return component;
       }else {
           return null;
       }
    }
}
