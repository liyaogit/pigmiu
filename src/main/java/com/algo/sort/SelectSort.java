package com.algo.sort;

/**
 * @Auther: yli
 * @Date: 2019/1/13 15:42
 * @Description:选择排序:
 * 缺点:不是稳定的排序算法
 */
public class SelectSort {
    public void selectSort(int[] a, int n){
        if (n < 1) return;
        for (int i = 0; i < n - 1; i++){
            int min = a[i];
            boolean flag = false;
            int index = i + 1;
            for (int j = i + 1; j < n; j++){
                if (a[j] < min){
                    min = a[j];    //找出最小元素
                    index = j;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
            int tep = a[i];
            a[i] = a[index];
            a[index] = tep;    //交换至已排序区间尾部
        }
    }

    private void printArray(int[] a){
        for (int item : a){
            System.out.println(item+",");
        }
    }

    public static void main(String[] args){
        SelectSort sort = new SelectSort();
        int[] a = {4,5,1,8,6,3,2,7};
        sort.selectSort(a, 8);
        sort.printArray(a);

    }
}
