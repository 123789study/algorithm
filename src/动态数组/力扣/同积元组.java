package 动态数组.力扣;

import java.util.*;

public class 同积元组 {
    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{1, 2, 3, 4, 6, 12}));
    }

    public static int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = nums[i] * nums[j];
                cnt.put(key, cnt.getOrDefault(key, 0) + 1);
            }
        }
        int ans = 0;
        for (Integer v : cnt.values()) {
            ans += (v - 1) * v * 4;
        }
        return ans;
    }

}
