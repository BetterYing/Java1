public class Test {
    public static void main(String[] args) {
        String str = "leetcode";
        String s = reverseString(str);
        System.out.println(s);
    }
    public static String reverseString(String s) {
        if (s == null && s.length() == 0){
            return null;
        }
        String arr="aieouAIEOU";
        char[] str = s.toCharArray();
        int i = 0;
        int j = str.length - 1;
        while(i < j) {
            if (arr.indexOf(str[i]) == -1) {
                i++;
            } else if (arr.indexOf(str[j]) == -1) {
                j--;
            } else {
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(str);//public static String valueOf(char data[])
    }




    
    public static void main5(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abcdef");
        String s = stringBuffer.toString();
        System.out.println(s);
    }

    public static void main4(String[] args) {
        String str = "abc def";
        String[] str1 = str.split(" ");
        for (int i = 0; i < str1.length; i++) {

        }
        /*StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(stringBuffer);*/
        StringBuffer stringBuffer = new StringBuffer();
        String str2  = stringBuffer.toString();
        stringBuffer.append(str2);
        System.out.println(stringBuffer);
    }

    public static void main2(String[] args) {
        String str = "hello world bit";
        String[] str1 = str.split(" ");
        for (String s : str1) {
            String str2 = s;
            System.out.println(str2);
        }

    }
    public static void fun(StringBuffer temp) {
        temp.append("\n").append("www.bit.com.cn");
    }


    public static void main1(String[] args) {
        String str = "hello world hello bit";
        String[] result = str.split(" ");
        for (String s : result) {
            System.out.println(s);
        }

    }
}
