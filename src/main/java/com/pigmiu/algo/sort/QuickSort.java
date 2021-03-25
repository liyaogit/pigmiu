package com.pigmiu.algo.sort;

/**
 * @Auther: yli
 * @Date: 2019/1/15 11:42
 * @Description:快速排序
 * 是原地排序算法
 * 时间复杂度最好O(N*logN),最坏O(n2),平均复杂度O(N*logN)
 * 因为涉及到交换,不是一个稳定排序算法
 */
public class QuickSort {
    public void quickSort(int[] a, int n){
       quickSortInter(a, 0, n-1);

    }


    private void quickSortInter(int[] a, int p, int r){
        if (p >= r) return;
        int q = partition(a, p, r);
        quickSortInter(a, p, q-1);
        quickSortInter(a, q+1, r);
    }

    private int partition(int[] a, int p, int r){
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++){
            if (a[j] < pivot){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                ++i;
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        System.out.println("i=" + i);
        return i;
    }

    private void printArray(int[] a){
        for (int item : a){
            System.out.println(item+",");
        }
    }

    public static void main(String[] args){
        QuickSort sort = new QuickSort();
        int[] a = {1,5,4,8,6,3,2,7};
        sort.quickSort(a, 8);
        sort.printArray(a);

    }
}
