package 二分查找;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{1,2,3,4,4,4,4,5,6,7,8,9};

        System.out.println(BinarySearch_base.binarySerch(arr,10));  //基础版

        System.out.println(BinarySearch_modify.binarySerch(arr,5));//修改版

        System.out.println(BinarySearch_balance.binarySerch(arr,7));//平衡版

        System.out.println(Arrays.binarySearch(arr,1));              // 调用库函数版

        System.out.println(BinarySearch_left_right.left(arr, 4));  //查询最左边的数据

        System.out.println(BinarySearch_left_right.right(arr, 4));  //查询最右边的数据
    }
    public int[] searchRange(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int left=-1;
        int right=-1;
        int[] arr=new int[2];

        while (i<=j){
            Integer m=(i+j)>>>1;
            if (target<nums[m]){
                j=m-1;
            }else if (target>nums[m]){
                i=m+1;
            }else {
                left=m;
                j=m-1;
            }
        }

        i=0;
        j=nums.length-1;

        while (i<=j){
            Integer m=(i+j)>>>1;
            if (target<nums[m]){
                j=m-1;
            }else if (target>nums[m]){
                i=m+1;
            }else {
                right=m;
                i=m+1;
            }
        }
        arr[0]=left;
        arr[1]=right;
        return arr;
    }
}
