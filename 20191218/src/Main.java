import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y1,y2,y3,y4;
        float a,b,c;
        while(sc.hasNext()) {
            y1 = sc.nextInt();
            y2 = sc.nextInt();
            y3 = sc.nextInt();
            y4 = sc.nextInt();
            a = (y1 + y3) / 2f;
            b = (y3 - y1) / 2f;
            c = (y4 - y2) / 2f;
            if (a - ((y1 + y3) / 2) != 0) {
                System.out.print("No");
                return;
            }
            if ((b - ((y3 - y1) / 2) != 0) || (b != ((y2 + y4) / 2))) {
                System.out.print("No");
                return;
            }
            if ((c - ((y4 - y2) / 2)) != 0) {
                System.out.print("No");
                return;
            }
            System.out.print((int) a + " " + (int)b + " " + (int)c);
        }
    }
}
