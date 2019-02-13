package com.algo.search;

/**
 * @Auther: yli
 * @Date: 2019/1/22 13:57
 * @Description:二分查找
 * 时间复杂度O(logN)
 * 应用场景:数组(需随机访问),需有足够的连续空间
 * 针对有序数据
 * 如果比较操作比较耗时,使用二分查找比顺序遍历有优势
 */
public class BinarySearch {

    /**
     * 二分查找循环写法
     */
    public int bSearch(int[] a, int n, int value){
        int low = 0, high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);  //防止low和high过大，和溢出。位运算效率更高
            if (value == a[mid]){
                return mid + 1;
            }else if (value < a[mid]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找循环写法
     */
    public int bSearchInternally(int[] a, int low, int high, int value){
        if (low > high) return -1;
        int mid = (low + high)/2;
        if (value == a[mid]){
            return mid + 1;
        }else if (value < a[mid]){
            high = mid - 1;
        }else {
            low = mid + 1;
        }
        return bSearchInternally(a, low, high, value);
    }

    /**
     * 二分查找变体1:对于有重复元素,查找第一个值等于给定值的元素
     */
    public int bSearch1(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (value < a[mid]){
                high = mid - 1;
            }else if (value > a[mid]){
                low = mid + 1;
            }else {
                if (mid == 0 || a[mid - 1] != value){
                    return mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找变体2:对于有重复元素,查找最后一个值等于给定值的元素
     */
    public int bSearch2(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (value < a[mid]){
                high = mid - 1;
            }else if (value > a[mid]){
                low = mid + 1;
            }else {
                if (mid == 0 || a[mid + 1] != value){
                    return mid + 1;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    /**
     * 二分查找变体3:查找第一个大于等于给定值的元素
     */
    public int bSearch3(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            //如果小于指定值
            if (a[mid] < value){
                low = mid + 1;
            }else {
                //大于等于指定值,并且前面一个元素小于指定值。则当前元素是第一个大于等于指定值的元素
                if (mid == 0 || a[mid - 1] < value){
                    return mid + 1;
                }else {
                    //否则不是第一个大于等于指定值的元素
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找变体4:查找最后一个小于等于给定值的元素
     */
    public int bSearch4(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value){
                if (mid == n - 1 || a[mid + 1] > value){
                    return mid + 1;
                }else {
                    low = mid + 1;
                }
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] a = {1, 3, 4, 55, 65, 74, 89, 97};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.bSearch(a, a.length, 55);
        System.out.println(index);
        //递归二分法测试
        int index1 = binarySearch.bSearchInternally(a, 0, a.length - 1, 55);
        System.out.println(index1);

        int[] b = {1, 3, 3, 5, 5, 7, 8, 9};
        int b1 = binarySearch.bSearch1(b, b.length, 3);
        System.out.println("第一个等于指定值元素的位置" + b1);

        int b2 = binarySearch.bSearch2(b, b.length, 3);
        System.out.println("最后一个等于指定值元素的位置" + b2);

        int b3 = binarySearch.bSearch3(b, b.length, 6);
        System.out.println("第一个大于等于指定值元素的位置" + b3);

        int b4 = binarySearch.bSearch4(b, b.length, 6);
        System.out.println("最后一个小于等于指定值元素的位置" + b4);

    }
}
