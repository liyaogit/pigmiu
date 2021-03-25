package com.pigmiu.algo.sort;

/**
 * @Auther: yli
 * @Date: 2019/1/13 15:42
 * @Description:选择排序:
 * 最好、最坏、平均时间复杂度都是O(n2)
 * 空间复杂度O(1)
 * 缺点:不是稳定的排序算法
 */
public class SelectSort {
    public void selectSort(int[] a, int n){
        if (n <= 1) return;
        for (int i = 0; i < n - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                if (a[j] < a[minIndex]){
                    minIndex = j;   //找出最小元素下标
                }
            }
            int tep = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tep;    //交换至已排序区间尾部
        }
    }

    private void printArray(int[] a){
        for (int item : a){
            System.out.println(item+",");
        }
    }

    public static void main(String[] args){
        SelectSort sort = new SelectSort();
        int[] a = {1,5,4,8,6,3,2,7};
        sort.selectSort(a, 8);
        sort.printArray(a);

    }
}
