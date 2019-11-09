public class Test1{

    public static void main(String[] args) {
        String str = "hello world hello bit" ;
        char[] result = str.toCharArray() ; // 按照空格拆分
        int i = 0;
        int j = 0;
        int len = result.length;
        while (i < len) {
            if (result[i] == ' ' ){
                str = reverse(str,j,i - 1);
                j = i + 1;
            } else if (i == len -1) {
                str = reverse(str,j,i);
            }
            i++;
        }
        System.out.println(str);
        String[] str2 = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for(String s: str2) {
            sb.append(new StringBuilder(s).append(" "));
        }
        String str3 = sb.toString();
        str3 = reverse(str3,0,str3.length() - 1);
        str3 = str3.trim();
        System.out.println(str3);
    }
    public static String reverse(String str,int start,int end) {
        char[] value = str.toCharArray();
        while (start < end) {
            char tmp = value[start];
            value[start] = value[end];
            value[end] = tmp;
            start++;
            end--;
        }
        return String.copyValueOf(value);
    }

}