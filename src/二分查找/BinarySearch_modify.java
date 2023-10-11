package 二分查找;

public class BinarySearch_modify {
    public static Integer binarySerch(Integer[] arr, Integer target) {
        Integer i = 0;
        Integer j = arr.length;
        while (i <= j) {
            Integer m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m;
            } else if (target > arr[m]) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
