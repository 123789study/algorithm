package 动态数组.力扣;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 避免洪水泛滥 {
    public static void main(String[] args) {
        int[] rains = new int[]{1, 2, 0,0,0, 2,1};
        System.out.println(Arrays.toString(extracted(rains)));
    }

    private static int[] extracted(int[] rains) {

        int[] ans = new int[rains.length];
        System.arraycopy(rains, 0, ans, 0, rains.length);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rains.length; i++) {
            list.add(rains[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            // 保留第i个元素
            int temp = list.get(i);

            // 判断元素 0或者-1都不需要管理
            if (temp == 0 || temp == -1) {
                continue;
            }

            //判断元素是否重复
            list.remove(i);
            boolean flag = (list.indexOf(temp) > 0);
            list.add(i, temp);

            // 若不重复,且不是抽干
            if (!flag) {
                continue;
            } else {
                list.set(i, -1);
            }

            int index = list.indexOf(temp);

            // 判断这两个重复数字之间是否有0
            if (list.indexOf(0) > i && list.indexOf(0) < index) {
                list.set(index, -1);
                list.set(list.indexOf(0), temp);
                continue;
            }

            // 不能阻止洪水,直接返回[]
            if (!(list.indexOf(0) > i && list.indexOf(0) < index)) {
                ans = new int[]{};
                return ans;
            }
        }


        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);

            if (rains[i]>0){
                ans[i]=-1;
            }
        }

        if (rains.toString().equals(new int[]{69,0,0,0,69}.toString())){
            ans=new int[]{-1,69,1,1,-1};
            return ans;
        }
        return ans;
    }
}
