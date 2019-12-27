import java.util.*;

public class Main1 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            getString(input);
        }
        scanner.close();
    }

    public static void getString(int input) {
        // 第一个数
        int curNum = input * (input - 1) + 1;
        StringBuffer sBuffer = new StringBuffer();

        for (int i = 0; i < input; i++) {
            if (i == input - 1) {
                sBuffer.append(curNum);
            } else {
                sBuffer.append(curNum + "+");
            }
            curNum += 2;
        }
        System.out.println(sBuffer);
    }
}