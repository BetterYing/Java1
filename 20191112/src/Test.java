import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 class Student implements Comparable<Student> {
    private String name;
    private String clas;
    private double score;
    public Student(String name, String clas, double score) {
         this.name = name;
         this.clas = clas;
         this.score = score;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
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
                ", clas='" + clas + '\'' +
                ", score=" + score +
                '}';
    }
    public int compareTo(Student o) {
        //return this.name.compareTo(o.name);
        return (int)(this.score - o.score);
    }
 }

public class Test {
     public static void main1(String[] args){
         List<Integer> list = new ArrayList<>();
         list.add(1);
         list.add(39);
         list.add(17);
         list.add(99);
         list.add(58);
         list.add(90);
         System.out.println(list);
         Collections.sort(list);
         System.out.println(list);
     }

    public static void main(String[] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student("gai","roc",90.9));
        list.add(new Student("qibai","roc",93.6));
        list.add(new Student("babai","roc",68.5));
        list.add(new Student("jiubai","roc",89.1));
        list.add(new Student("yiqian","roc",78.3));
        for (Student s : list){
            System.out.println(s);
        }
        System.out.println("=============");
        Collections.sort(list);
        for (Student s : list){
            System.out.println(s);
        }

    }



}
