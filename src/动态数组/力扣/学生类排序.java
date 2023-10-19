package 动态数组.力扣;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 学生类排序 {
    public static void main(String[] args) {
        People[] peoples=new People[10];
        for (int i = 0; i < peoples.length; i++) {
            peoples[i]=new People();
            peoples[i].setHeight(i+1);
        }
       List list=Arrays.stream(peoples).sorted((o1, o2)->{
           double temp=o1.getHeight()- o2.getHeight();
               if (temp>0){
                   return 1;
               }else if (temp<0){
                   return -1;
               }else {
                   return 0;
               }
           }
    ).collect(Collectors.toList());
        for (Object o : list) {
            System.out.println(o);
        }
    }
}

class People{
    private String name;
    private LocalDateTime dateTime;
    private String gender;
    private double height;
    private double weight;



    public People() {
    }

    public People(String name, LocalDateTime dateTime, String gender, double height, double weight) {
        this.name = name;
        this.dateTime = dateTime;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return dateTime
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * 设置
     * @param dateTime
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * 设置
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * 获取
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * 设置
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        return "People{name = " + name + ", dateTime = " + dateTime + ", gender = " + gender + ", height = " + height + ", weight = " + weight + "}";
    }
}