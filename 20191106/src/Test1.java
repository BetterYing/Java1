public class Test1 {

    public static void main(String[] args){
        String str1 = "  hello world  ";
        String ret = str1.trim();//去掉字符串左右空格，保留中间空格
        System.out.println(ret);

        String ret1 = ret.toUpperCase();//将字符串全部转为大写
        System.out.println(ret1);

        String ret2 = ret1.toLowerCase();//将字符串全部转为小写
        System.out.println(ret2);

        String str = ret1.concat(str1);//将字符串拼接（将str1拼接到ret1后面）
        System.out.println(str);// HELLO WORLD  hello world

        String s = "";
        boolean tmp = s.isEmpty();//判断字符串是否为空，但是不是null。
        System.out.println(tmp);//true
    }

    public static void main6(String[] args){
        String str1 = "hello,world";
        String ret = str1.substring(4);
        System.out.println(ret);//o,world

        String ret1 = str1.substring(2,6);//截取区间[2,6)
        System.out.println(ret1);//llo,
    }

    public static void main5(String[] args){
        String str1 = "hello,wor,ld";
        String[] ret = str1.split(",");
        for(String s: ret) {
            System.out.println(s);
        }

        String[] ret1 = str1.split(",",2);
        for(String s: ret1) {
            System.out.println(s);
        }
    }

    public static void main4(String[] args){
        String str1 = "hello,world";
//        String ret = str1.replace("l","y");//用“y”替换字符串中的所有“l”
//        System.out.println(ret);//heyyo,woryd

        String ret1 = str1.replaceAll("o","sy");//替换所有内容
        System.out.println(ret1);//hellsy,wsyrld

//        String ret2 = str1.replaceFirst("l","s");//用“s”替换第一个出现的“l”
//        System.out.println(ret2);//heslo,world
    }


    public static void main3(String[] args) {
        String str1 = "hello,world";

        System.out.println(str1.contains("w"));//true  contains底层调用indexOf的方法。

        int tmp = str1.indexOf("s");//找不到返回-1
        int ret = str1.indexOf("w",2);//从2号下标开始查找
        System.out.println(tmp);//-1
        System.out.println(ret);//6

        int tmp1 = str1.lastIndexOf("w");
        int ret1 = str1.lastIndexOf("w",5);
        System.out.println(tmp1);//6  从后往前查找
        System.out.println(ret1);//-1 从指定位置往前查找

        boolean ret3 = str1.startsWith("w");
        boolean ret4 = str1.startsWith("w",6);
        System.out.println(ret3);//false,判断字符串是否以“w”开头。
        System.out.println(ret4);//true,判断字符串从指定位置是不是以“w”开头。

        System.out.println(str1.endsWith("o"));//false,判断字符串是否以“o”结尾。


    }


    public static void main2(String[] args) {
        String str1 = "abcdef";
        String str2 = new String("abcdef");
        System.out.println(str1 == str2);//false

        String str3 = new String("abcdef");
        System.out.println(str2 == str3);//false
        //如果两个字符串常量直接拼接+ 那么在编译期间就处理为拼接的结果
        String str4 = "ab"+"cdef";//
        System.out.println(str1 == str4);//true

        String str5 = "ab" + new String("cdef");
        System.out.println(str1 == str5);//false
        System.out.println(str1.equals(str5));//true

        String str6 = "ab";
        String str7 = "cdef";
        String str8 = str6+str7;
        System.out.println(str1 == str8);// false
        System.out.println(str1.equals(str8));//true

        String str9 = str6+"cdef";
        System.out.println(str1 == str9);//false

        String str10 = "hello" + 10;//"hello10"
        String str11 = "hello10";
        System.out.println(str10 == str11);//true
    }



    public static void main1(String[] args) {
        String str1 = "hhh";
        String str2 = "hhh";
        System.out.println(str1 == str2);//true

        String str3 = new String("hhh");
        System.out.println(str1 == str3);//false


    }

}
