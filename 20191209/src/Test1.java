public class Test1 {
    private static final long count = 100_0000_0000L;

    private static class MyThread extends Thread {
        @Override
        public void run() {
            long b = 0;
            for (long i = 0; i < count; i++) {
                b += i;
            }
        }
    }

    private static void mutiThread() throws InterruptedException {
        long begin = System.currentTimeMillis();
        MyThread thread = new MyThread();
        thread.start();
        long a = 0;
        for (long i = 0; i < count; i++) {
            a += i;
        }
        thread.join();

        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    private static void oneThread() {
        long begin = System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i < count; i++) {
            a += i;
        }
        long b = 0;
        for (long i = 0; i < count; i++) {
            b += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    public static void main(String[] args) throws InterruptedException {
        mutiThread();
        oneThread();
    }

}
