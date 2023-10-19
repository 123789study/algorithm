import java.text.DecimalFormat;
import java.util.*;

abstract class Person {
    String name;
    int age;
    boolean gender;

    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String toString() {
        return name + "-" + age + "-" + gender;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        if (name != null ? !name.equals(person.name) : person.name != null) {
            return false;
        }
        return age == person.age && gender == person.gender;
    }
}

class Student extends Person {
    String stuNo;
    String clazz;

    public Student(String name, int age, boolean gender, String stuNo, String clazz) {
        super(name, age, gender);
        this.stuNo = stuNo;
        this.clazz = clazz;
    }

    public String toString() {
        return "Student:" + super.toString() + "-" + stuNo + "-" + clazz;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Student student = (Student) obj;
        if (stuNo != null ? !stuNo.equals(student.stuNo) : student.stuNo != null) {
            return false;
        }
        return clazz != null ? clazz.equals(student.clazz) : student.clazz == null;
    }
}

class Company {
    String name;

    public Company(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Company company = (Company) obj;
        return name != null ? name.equals(company.name) : company.name == null;
    }
}

class Employee extends Person {
    Company company;
    double salary;

    DecimalFormat df = new DecimalFormat("#.#");

    public Employee(String name, int age, boolean gender, double salary, Company company) {
        super(name, age, gender);
        this.salary = salary;
        this.company = company;
    }

    public String toString() {

        return "Employee:" + super.toString() + "-" + company + "-" + salary;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Employee employee = (Employee) obj;
        if (company != null ? !company.equals(employee.company) : employee.company != null) {
            return false;
        }
        return Double.compare(Double.parseDouble(df.format(employee.salary)), Double.parseDouble(df.format(salary))) == 0;
    }
}

public class Main {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        List<Student> stuList = new ArrayList<>();
        List<Employee> empList = new ArrayList<>();

        Scanner sc=new Scanner(System.in);

        while (true) {
            String input = sc.next();

            if (input.equalsIgnoreCase("s")) {
                personList.add(new Student(sc.next(),sc.nextInt(),sc.nextBoolean(),sc.next(),sc.next()));
            }
            else if (input.equalsIgnoreCase("e")) {
                personList.add(new Employee(sc.next(),sc.nextInt(),sc.nextBoolean(),sc.nextDouble(),
                        new Company(sc.next())));
            }
            else {
                break;
            }
        }

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int num1=o1.name.compareTo(o2.name);
                int num2=Integer.compare(o1.age,o2.age);
               return num1!=0?num1:num2;
            }
        });
        for (Person person : personList) {
            System.out.println(person.toString());
        }


        for (Person person : personList) {
            if (person instanceof Student) {
                if (!stuList.contains((Student) person)) {
                    stuList.add((Student) person);
                }
            } else if (person instanceof Employee) {
                if (!empList.contains((Employee) person)) {
                    empList.add((Employee) person);
                }
            }
        }

        System.out.println("stuList");
        for (Student student : stuList) {
            System.out.println(student.toString());
        }

        System.out.println("empList");
        for (Employee employee : empList) {
            System.out.println(employee.toString());
        }
    }
}