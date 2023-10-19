package 动态数组.力扣;

import java.util.*;

public class 只出现一次的数字 {
    public static void main(String[] args) {
        int[] nums=new int[]{43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {

        List<Integer> list=new ArrayList<>(nums.length);
        Arrays.stream(nums).sorted().forEach(list::add);
        System.out.println(list);

        while (list.size() > 1 ){
            if (list.get(0).equals(list.get(1)) && list.get(1).equals(list.get(2))){
                list.remove(0);
                list.remove(0);
                list.remove(0);
            }
            if (list.size()>1 && !list.get(0).equals(list.get(1))){
                break;
            }
        }
        return list.get(0);
    }
}
