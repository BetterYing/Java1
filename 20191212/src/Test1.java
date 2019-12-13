public class Test1 {
    private static long n = 0;

    private static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                synchronized (Test1.class){
                    n++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread();
            t.start();
            threads[i] = t;
        }

        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }
        System.out.println(n);
    }
}
