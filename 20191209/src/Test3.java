public class Test3 {
    private static final long count = 1_0000_0000L;
    private static class MyThread extends Thread {
        @Override
        public void run() {
            long a;
            long sum = 0;
            for (long i = 0; i < count; i++) {
                a = i * i;
                sum += a;
            }
            System.out.println(sum);
        }
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            long a;
            long sum = 0;
            for (long i = 0; i < count; i++) {
                a = i * i;
                sum += a;
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args){
        MyThread mythread = new MyThread();
        mythread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        MyThread myThread1 = new MyThread();
        Thread thread1 = new Thread(myThread1);
        thread1.start();

    }
}
