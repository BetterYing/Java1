public class HowThreadDie2 {
    private static class Worker extends Thread{
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                System.out.println("挖煤");
                try {
                    Thread.sleep(50 * 1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(3 * 1000);
        System.out.println("媳妇生了");
        worker.join();
        System.out.println("他回家了");
    }
}
