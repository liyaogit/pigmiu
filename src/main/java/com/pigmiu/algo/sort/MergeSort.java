package com.pigmiu.algo.sort;

import java.util.Arrays;

/**
 * @Auther: yli
 * @Date: 2018/12/29 15:56
 * @Description:归并排序
 * 时间复杂度分析:1、我们在分析一个算法、一段代码的时间复杂度的时候，也只关注执行次数最多的那一段就可以了
 * 最好、最坏、平均时间复杂度均是O(n*logN)
 * 空间复杂度O(n),不是原地排序算法
 * 是一个稳定的排序算法
 */
public class MergeSort {

    /**
     * @param sort 原数组
     * @Description: 递归排序
     */
    public static int[] mergeSort(int[] sort){
        if (sort == null) return new int[0];

        if (sort.length==1) return sort;

        int mid = sort.length/2;
        int[] left = Arrays.copyOfRange(sort, 0 , mid);
        int[] right = Arrays.copyOfRange(sort, mid, sort.length);
        left = mergeSort(left);
        right = mergeSort(right);

        int[] merge = merge(left, right);
        return merge;

    }

    /**
     * @Description: 合并两个已经完成排序的数组，从小到大
     */
    public static int[] merge(int[] a, int[] b){
        if (a == null) a = new int[0];
        if (b == null) b = new int[0];
        int[] mergedOne = new int[a.length + b.length];
        int mi = 0, ai = 0, bi = 0;
        //轮流从两个数组取出最小值,放入合并后的数组中
        while (ai < a.length && bi < b.length){
            if (a[ai] < b[bi]){
                mergedOne[mi] = a[ai];
                ai ++;
            }else {
                mergedOne[mi] = b[bi];
                bi ++;
            }
            mi ++;
        }

        //将某个数组中的剩余元素放入合并后的数组
        if (ai < a.length){
            for (int i = ai; i < a.length; i ++){
                mergedOne[mi] = a[i];
                mi ++;
            }
        }else {
            for (int i = bi; i < b.length; i ++){
                mergedOne[mi] =b[bi];
                mi ++;
            }
        }

        return mergedOne;
    }
}
