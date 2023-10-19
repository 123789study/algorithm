package 动态数组.力扣;

public class 倍数求和 {
    public static void main(String[] args) {
        System.out.println(sumOfMultiples(7));
    }
    public static int sumOfMultiples(int n) {
        int[] arr=new int[n];
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%3==0||arr[i]%5==0||arr[i]%7==0){
                sum+=arr[i];
            }
        }
        return sum;
    }
}
