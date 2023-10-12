package 链表;

import java.util.function.Consumer;

public class SimpleLinkedListWithSentry {
    private class Node {
        int value;
        Node next = null;

        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }


    }

    private Node head=new Node(114514,null);
    private int size = 0; //链表长度

    // 获取链表长度
    public int getSize() {
        return size;
    }

    // 在链表首部添加数据
    public void addFrist(int value) {
        head = new Node(value, head);
        size++;
    }

    // 在链表尾部添加数据
    public void addLast(int value) {
        Node p=get(size);
        p.next = new Node(value, null);
        size++;
    }

    // 获取第i个位置的数据
    public Node get(int index){
        Node temp=head;
        for (int i = 1; i <= index - 1; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // 在链表指定位置添加数据,链表第一个数据1开始
    public void insert(int index, int value) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("超出范围辣");
        }
        Node temp = head;
        Node NewNode = new Node(value, null);

        // 获得插入节点的前一个节点
        temp=get(index-1);

        if (index == 1) {
            addFrist(value);
        } else {
            NewNode.next = temp.next;
            temp.next = NewNode;
            size++;
        }
    }

    // 删除第一个元素
    public void removeFirst(){
        Node temp=get(2);
        head=temp;
        size--;
    }

    // 在链表指定位置删除数据
    public void remove(int index){
        Node temp=get(index-1);
        if (index==1){
            removeFirst();
        }else {
            temp.next=temp.next.next;
            size--;
        }
    }

    // 遍历
    public void loop(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }
}
class NewMain {
    public static void main(String[] args) throws Exception {
        SimpleLinkedListWithSentry s = new SimpleLinkedListWithSentry();
        s.addFrist(1);
        s.addFrist(2);
        s.addFrist(3);

        s.insert(1, 10);
        s.insert(2, 20);

        s.addLast(6);
        s.addLast(5);
        s.addLast(4);

        s.remove(2);
        s.remove(2);

        s.loop(value -> System.out.print(value + " "));

        System.out.println();
        System.out.println(s.getSize());
    }
}
