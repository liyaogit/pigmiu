package com.design.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: yli
 * Date: 2017/7/11
 * Time: 15:23
 */
public class Coffee extends CaffeineBeverage{
    @Override
    public void brew() {
        System.out.println("扔咖啡");
    }

    @Override
    public void addCondiments() {
        System.out.println("加糖和牛奶");
    }

    @Override
    public boolean needCondiments() {
        String answer = getUserInput();
        if(answer.toLowerCase().startsWith("y")){
            return true;
        }else {
            return false;
        }
    }

    private String getUserInput(){
        String answer = null;
        System.out.println("要加点糖和牛奶吗?(y/n)");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer==null ? "no" : answer;
    }
}
