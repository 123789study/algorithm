package 动态数组;

import java.util.Arrays;
import java.util.function.Consumer;

import static com.sun.tools.attach.VirtualMachine.list;

public class ArrayList {
    private int size = 0;   //当前长度
    private int capicity = 10; // 最大长度
    private int[] arr = new int[capicity];

    public ArrayList() {
    }

    public ArrayList(int capicity) {
        this.capicity = capicity;
        arr = new int[capicity];
    }

    // 获取当前长度
    public int getSize() {
        return size;
    }

    // 在list末尾添加元素
    public void add(int num) {
        add(size,num);
    }

    // 在指定位置添加元素
    public void add( int index,int num) {
        if (size == capicity) {
            arr = Expand(arr);

            System.arraycopy(arr, index, arr, index + 1, size-index);
            arr[index] = num;

            size++;
        } else {
            System.arraycopy(arr, index, arr, index + 1, size-index);
            arr[index] = num;
            size++;
        }
    }

    // 在list末尾去除元素
    public void removeLast() {
        remove(size);
    }

    /**
     * 删除指定位置的元素
     * @param index
     */
    public void remove(int index){
        if (index>size||index<0){
            throw new IndexOutOfBoundsException("超出边界辣");
        }
        arr[index]=0;
        System.arraycopy(arr,index+1,arr,index,size-index);
        size--;
    }

    // 获取指定位置的元素
    public int get(int index){
        return arr[index];
    }

    // 数组扩容
    public int[] Expand(int[] arr) {
        capicity >>>= 1;
        int[] newArr = new int[capicity];
        System.arraycopy(arr, 0, newArr, 0, size);
        return newArr;
    }

    // 遍历
    public void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < arr.length; i++) {
            consumer.accept(arr[i]);
        }
    }


    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, size));
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(3);


        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.removeLast();

        list.add(0,114514);
        list.add(0,114514);
        list.add(0,114514);
        list.add(0,114514);

        list.remove(6);

        System.out.println(list.get(1));
        System.out.println(list.getSize());
        System.out.println(list);
    }
}
