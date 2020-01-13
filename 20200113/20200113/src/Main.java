import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            change1(str1);
            change2(str2);
        }
    }
    public static void change1(String str) {
        String[] data = str.split("\\.");
        data[0] = Integer.toBinaryString(Integer.parseInt(data[0]));
        data[1] = Integer.toBinaryString(Integer.parseInt(data[1]));
        data[2] = Integer.toBinaryString(Integer.parseInt(data[2]));
        data[3] = Integer.toBinaryString(Integer.parseInt(data[3]));

        while (data[0].length() < 8) {
            data[0] = "0" + data[0];
        }
        while (data[1].length() < 8) {
            data[1] = "0" + data[1];
        }
        while (data[2].length() < 8) {
            data[2] = "0" + data[2];
        }
        while (data[3].length() < 8) {
            data[3] = "0" + data[3];
        }

        long sum = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length(); j++) {
                sum = sum * 2 + (data[i].charAt(j) - '0');
            }
        }
        System.out.println(sum);
    }

    public static void change2(String str) {
        long data2 = Long.parseLong(str);
        String bina = Long.toBinaryString(data2);
        String[] data = new String[4];
        data[0] = bina.substring(0,bina.length() - 3 * 8);
        data[1] = bina.substring(data[0].length(),data[0].length() + 8);
        data[2] = bina.substring(data[0].length() + data[1].length(),data[0].length() + data[1].length() + 8);
        data[3] = bina.substring(bina.length() - 8,bina.length());

        System.out.print(Integer.valueOf(data[0],2) + ".");
        System.out.print(Integer.valueOf(data[1],2) + ".");
        System.out.print(Integer.valueOf(data[2],2) + ".");
        System.out.println(Integer.valueOf(data[3],2));

    }





}
