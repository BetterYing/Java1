import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> courses = new ArrayList<>();
        courses.add("C 语言");
        courses.add("Java SE");
        courses.add("Java Web");
        courses.add("Java EE");
        courses.add("C语言");
        System.out.println(courses);

        System.out.println(courses.get(0));

        courses.set(0,"计算机基础");
        System.out.println(courses);

        List<String> subCourses = courses.subList(1,3);//截取
        System.out.println(subCourses);

        List<String> list2 = new ArrayList<>();
        list2.add("计算机网络");
        list2.add("C++");
        System.out.println(list2);
//
//        courses.addAll(list2);
//        System.out.println(courses);
//        System.out.println("===========");
//        String str = courses.remove(0);
//        System.out.println(str);
//        System.out.println(courses);
//        list2.remove("计算机网络");
//        System.out.println(list2);
//        System.out.println(list2);
//        System.out.println(courses);//没有删除courses内的计算机网络
//        courses.remove("计算机网络");
//        System.out.println(courses);
//        System.out.println(list2);//只能移除自己的内容
//
//        String str1 = courses.get(0);
//        System.out.println(str1);
//        courses.set(1,"嵌入式");
//        System.out.println(courses);
//        int index = courses.indexOf("C语言");
//        System.out.println(index);//C语言的下标

        subCourses.set(0,"大物");
        System.out.println(subCourses);
        System.out.println(courses);

        List<String> otherList = new ArrayList<>(subCourses);
        System.out.println(otherList);

        //List<String> linkedList = new List<String>(subCourses);
        ArrayList<String> courses1 = (ArrayList<String>) otherList;
        System.out.println(courses1);

    }

    public static void main1(String[] args) {
        int i = 10;
        //装箱操作
        //新建一个 Integer 类型对象，将 i 的值放入对象的某个属性中
        Integer ii = Integer.valueOf(i);
        Integer ij = new Integer(i);

        //拆箱操作
        //将 Integer 对象中的值取出，放到一个基本数据类型中
        int j = ii.intValue();
        System.out.println(ij);
        System.out.println(j);

    }
}
