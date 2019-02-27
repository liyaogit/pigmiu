package com.algo.recursion;

import java.util.ArrayList;

/**
 * @Auther: yli
 * @Date: 2018/12/19 17:19
 * @Description:迭代算法，主要包含递归操作
 * 写递归代码方法:1、写出递归公式 2、找到终止条件 3、转化为代码
 * 缺点:堆栈溢出、重复计算、空间复杂度高
 */
public class Iteration {


    /**
     * @param total 整数值
     * @param result 初始组合
     * @Description: 算出一个整数的所有因数组合
     * 比如8：1*8， 2*4， 2*2*2
     */
    public static void recursion(long total, ArrayList<Long> result){

        if (total == 1){
            if (!result.contains(1L)) result.add(1L);
            System.out.println(result);
            return;
        }else {
            for(long i = 1; i <= total; i ++){
                if (i==1 && result.contains(1L)){
                    continue;
                }
                ArrayList<Long> newList = (ArrayList<Long>)(result.clone());
                newList.add(Long.valueOf(i));
                if(total%i !=0){
                   continue;
                }
                recursion(total/i, newList);
            }
        }
    }



}
