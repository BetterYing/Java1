import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {
    private static class Worker extends Thread {
        private BlockingQueue<Runnable> queue;
        Worker (BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                Runnable commend = null;
                try {
                    commend = queue.take();
                    commend.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int current;
    private int core;
    private BlockingQueue<Runnable> queue;
    private List<Worker> workerList;

    public MyThreadPool (int core,BlockingQueue<Runnable> queue) {
        this.current = 0;
        this.core = core;
        this.queue = queue;
        this.workerList = new ArrayList<>();
    }

    public void execute (Runnable commend) {
        if (current < core) {
            //雇人
            Worker worker = new Worker(queue);
            //工人加入花名册
            workerList.add(worker);
            //让工人行动
            worker.start();
            current++;
        }
        queue.add(commend);
    }

    public void shutDown () throws InterruptedException {
        //挨个通知大家下岗了
        for (Worker worker : workerList) {
            worker.interrupt();
        }
        //等待大家真的下岗（先通知，效率比较高
        for (Worker worker : workerList) {
            worker.join();
        }
    }

}
