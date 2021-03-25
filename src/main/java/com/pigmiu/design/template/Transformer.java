package com.pigmiu.design.template;

/**
 * User: yli
 * Date: 2017/7/11
 * Time: 16:20
 * 数组比较,变形的模板模式
 */
public class Transformer implements Comparable{
    private String name;
    private int height;

    public Transformer(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString(){
        return name + "height" + height;
    }

    public int compareTo(Object o) {
        Transformer transformer = (Transformer)o;
        if (this.height > transformer.height){
            return 1;
        }else {
            return -1;
        }
    }
}
