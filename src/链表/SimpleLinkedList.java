package 链表;

import java.util.function.Consumer;

public class SimpleLinkedList {
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

    private Node head;
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
    public Node addLast(int value) {
        if (head == null) {
            return null;
        }

        Node p;
        for (p = head; p.next != null; p = p.next) {
        }
        p.next = new Node(value, null);
        return p;
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
        for (int i = 1; i < index - 1; i++) {
            temp = temp.next;
        }
        if (index == 1) {
            addFrist(value);
        } else {
            NewNode.next = temp.next;
            temp.next = NewNode;
        }
        size++;
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

class Main {
    public static void main(String[] args) throws Exception {
        SimpleLinkedList s = new SimpleLinkedList();
        s.addFrist(1);
        s.addFrist(2);
        s.addFrist(3);
        s.insert(1, 10);
        s.insert(2, 20);
        s.addLast(6);
        s.addLast(5);
        s.addLast(4);

        s.loop(value -> System.out.print(value + " "));

        System.out.println();
        System.out.println(s.getSize());
    }
}

