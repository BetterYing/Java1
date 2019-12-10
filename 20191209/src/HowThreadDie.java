public class HowThreadDie {
    private static class Worker extends Thread{
        private boolean running = true;

        public void quit () {
            running = false;
        }
        @Override
        public void run() {
            while (running) {
                System.out.println("挖煤");
                try {
                    Thread.sleep(20 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(10 * 1000);
        System.out.println("媳妇生了");
        worker.quit();
        worker.join();
        System.out.println("他回家了");

    }
}
