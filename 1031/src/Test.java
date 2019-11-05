//剑指offer中的题

public class Test {
    public static void main(String[] args) {
        System.out.println(func(3));
    }

    public static void main1(String[] args) {
        int[][] arr = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        int[] tmp = findVal(arr,4,4,23);
        System.out.println(tmp[0] + " " + tmp[1]);
    }

    public static int func(int n) {
        int[] arr = new int[n];
        for (int i = 0;i < arr.length;i++) {
            arr[i] = 1;
        }
        int count = 0;//报数
        while(n > 1) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    count++;
                    if (count == 3) {
                        arr[i] = 0;
                        count = 0;
                        n--;
                    }
                }
            }
        }
        for (int i = 0;i < arr.length;i++) {
            if (arr[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int[] findVal(int[][] array,int row,int col,int num) {
        int i = 0;
        int j = col - 1;
        int[] tmp = new int[2];
        while (i < row && j >= 0) {
            if (array[i][j] > num) {
                j--;
            } else if (array[i][j] < num) {
                i++;
            } else {
                tmp[0] = i;
                tmp[1] = j;
                return tmp;
            }
        }
        return null;//没有找到，返回空，会产生空指针异常。
    }
}
