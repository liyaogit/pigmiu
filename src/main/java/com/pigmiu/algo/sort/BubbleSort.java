package com.pigmiu.algo.sort;

/**
 * @Auther: yli
 * @Date: 2019/1/12 14:37
 * @Description:冒泡排序
 * 是原地排序算法,空间复杂度为O(1)
 * 是稳定的排序算法,相同大小的数据排序前后不会改变位置
 * 时间复杂度O(n2)
 */
public class BubbleSort {

    public void bubbleSort(int[] a, int n){
        int count = 0;
        if (a == null || a.length <= 1) return;
        for (int i = 0; i < n - 1; i++){
            boolean swap = false;   //提前退出冒泡循环的标志位
            for (int j = 0; j < n - i - 1; j++){
                if (a[j] > a[j+1]){  //数据交换,只需要常量级的空间,空间复杂度O(1)
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swap = true;
                }
                ++count;
            }
            if (!swap){
                break;
            }

        }
        System.out.println("遍历次数" + count);

    }

    private void printArray(int[] a){
        for (int item : a){
            System.out.println(item+",");
        }
    }

    public static void main(String[] args){
        BubbleSort sort = new BubbleSort();
        int[] a = {4,5,1,8,6,3,2,7};
        sort.bubbleSort(a, 8);
        sort.printArray(a);

    }
}
