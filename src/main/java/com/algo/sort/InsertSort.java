package com.algo.sort;

/**
 * @Auther: yli
 * @Date: 2019/1/13 14:06
 * @Description:插入排序
 * 是原地排序
 * 是稳定的排序算法
 * 时间复杂度O(n2)
 * 优点:插入数据移位操作k,冒泡的交换执行操作3K
 */
public class InsertSort {

    public void insertSort(int[] a, int n){
        if (n < 1) return;
        for (int i = 1; i < n; i++){
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--){
                if (a[j] > value){
                    a[j+1] = a[j];  //数据移动
                }else {
                    break; //break后,j--不执行
                }
            }
            a[j + 1] = value; //插入数据
        }
    }

    private void printArray(int[] a){
        for (int item : a){
            System.out.println(item+",");
        }
    }

    public static void main(String[] args){
        InsertSort sort = new InsertSort();
        int[] a = {3,1,2};
        sort.insertSort(a, 3);
        sort.printArray(a);

    }
}
