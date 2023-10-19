package 动态数组.力扣;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 只出现一次数字 {
    public static void main(String[] args) {
        int[] nums=new int[]{2,2,1};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        List<Integer> list=new ArrayList<>(nums.length);
        Arrays.stream(nums).sorted().forEach(list::add);

        while (list.size() > 1 ){
            if (list.get(0).equals(list.get(1))){
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
