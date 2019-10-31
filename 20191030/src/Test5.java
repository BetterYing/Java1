import java.util.Arrays;

class Student implements Comparable<Student>{
    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        //return this.age - o.age;
        //return this.name.compareTo(o.name);
        return (int)(this.score - o.score);
    }
}


public class Test5 {
    public static void main(String[] args) {
        Student[] student = new Student[3];
        student[0] = new Student("zhangsan",23,33.6);
        student[1] = new Student("lisi",18,59.8);
        student[2] = new Student("wangwu",29,88.7);
        System.out.println(Arrays.toString(student));
        Arrays.sort(student);
        System.out.println(Arrays.toString(student));
    }
}
