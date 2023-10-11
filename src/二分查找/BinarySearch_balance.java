package 二分查找;

public class BinarySearch_balance {
    public static Integer binarySerch(Integer[] arr, Integer target) {
        Integer i = 0;
        Integer j = arr.length;
        while (1 < j-i) {
            Integer m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        if (target==arr[i]){
            return i;
        }
        return -1;
    }
}
