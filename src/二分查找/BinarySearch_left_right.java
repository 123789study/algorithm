package 二分查找;

public class BinarySearch_left_right {
    public static Integer left(Integer[] nums,Integer target){
        int i=0;
        int j=nums.length-1;
        int candidate=-1;

        while (i<=j){
            Integer m=(i+j)>>>1;
            if (target<nums[m]){
                j=m-1;
            }else if (target>nums[m]){
                i=m+1;
            }else {
                candidate=m;
                j=m-1;
            }
        }
        return candidate;
    }
    public static Integer right(Integer[] nums,Integer target){
        int i=0;
        int j=nums.length-1;
        int candidate=-1;

        while (i<=j){
            Integer m=(i+j)>>>1;
            if (target<nums[m]){
                j=m-1;
            }else if (target>nums[m]){
                i=m+1;
            }else {
                candidate=m;
                i=m+1;
            }
        }
        return candidate;
    }
}
