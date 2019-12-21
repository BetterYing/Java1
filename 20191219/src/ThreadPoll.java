import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ThreadPoll {
    private class Worker extends Thread {
        private BlockingQueue<Runnable> blockingQueue;

        public Worker(BlockingQueue<Runnable> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {

        }
    }

    private BlockingQueue<Runnable> blockingQueue;
    private int core;
    private int current;
    private List<Worker> workerList;

    public ThreadPoll(BlockingQueue<Runnable> blockingQueue, int core) {
        this.blockingQueue = blockingQueue;
        this.core = core;
        this.current = 0;
        this.workerList = new ArrayList<>();
    }

    private void put (Runnable commend) {
        if (current < core) {
            Worker worker = new Worker(blockingQueue);
            workerList.add(worker);
            worker.start();
            current++;
        } else {
            blockingQueue.add(commend);
        }
    }

    private void shutDown() throws InterruptedException {
        for (Worker worker : workerList) {
            worker.interrupt();
        }
        for (Worker worker : workerList) {
            worker.join();
        }
    }

}
