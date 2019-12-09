public class Test extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("启动线程");
        }
    }

    //jconsole
    public static void main(String[] args) {
        Test test = new Test();
        test.start();
        while (true) {
            System.out.println("主线程");
        }
    }
}
