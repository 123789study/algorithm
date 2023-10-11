package 二分查找;

class BinarySearch_base {

    public BinarySearch_base() {
    }

    public static Integer binarySerch(Integer[] nums, Integer target) {
        Integer i = 0;
        Integer j = nums.length - 1;
        while (i <= j) {
            Integer m = (i + j) >>> 1;
            if (target < nums[m]) {
                j = m - 1;
            } else if (target > nums[m]) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
