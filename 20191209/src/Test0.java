public class Test0 extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("启动线程");
        }
    }

    //jconsole
    public static void main(String[] args) {
        Test0 test = new Test0();
        test.start();
        while (true) {
            System.out.println("主线程");
        }
    }
}
