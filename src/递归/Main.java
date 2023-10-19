package 递归;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person1[] per = new Person1[n];
        for (int i = 0; i < per.length; i++) {
            per[i] = new Person1(sc.next(), sc.nextInt());
        }

        String people = sc.next();
        for (Person1 k : per) {
            System.out.println(k);
        }

        int flag = 0;
        for (int i = 0; i < per.length; i++) {
            if (people.equals(per[i].getName())) {
                flag = 1;
                System.out.println("查询结果: \n" + per[i]);
                break;
            }
        }

        if (flag == 0) {
            System.out.println("not found");
        }
    }
}

class Person1 {
    private String name;
    private int age;

    public Person1() {
        this.name = null;
        this.age = 1;
    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
