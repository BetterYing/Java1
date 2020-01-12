package task;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FileScanTask {

    private final ExecutorService poll = Executors.newFixedThreadPool(4);

    //private static volatile int COUNT;
    private final AtomicInteger count = new AtomicInteger();

    private final CountDownLatch latch = new CountDownLatch(1);

    private FileScanCallBack callBack;

    public FileScanTask(FileScanCallBack callBack) {
        this.callBack = callBack;
    }

    /**
     * 启动根目录的扫描
     * @param root
     */
    public void startScan(File root){
//        synchronized (this) {
//            COUNT++;
//        }
        count.incrementAndGet();

        poll.execute(new Runnable() {
            @Override
            public void run() {
                list(root);
            }
        });
    }

    public void waitFinish() throws InterruptedException {
//        try {
////            synchronized (this) {
////                this.wait();
////            }
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
        //等待
        try {
            latch.await();
        }finally {
            //中断所有线程
            poll.shutdown(); //调用每个线程的interrupt()中断
            // POLL.shutdownNow();//调用每个线程的stop()关闭
        }
    }

    public void list (File dir) {
        if (!Thread.interrupted()) {
            try {
                callBack.execute(dir);
                //System.out.println(dir.getPath());
                if (dir.isDirectory()) {
                    File[] children = dir.listFiles();
                    if (children != null && children.length > 0) {
                        for (File child : children) {
                            //启动子线程执行文件夹的扫描任务
                            if (child.isDirectory()) {
//                            synchronized (this) {
//                                COUNT++;
//                            }
                                count.incrementAndGet();
                                poll.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        list(child);
                                    }
                                });
                            } else {
                                callBack.execute(child);
                                //System.out.println(child.getPath());
                            }
                        }
                    }
                }
            } finally {
//            synchronized (this) {
//                COUNT--;
//                if (COUNT == 0) {
//                    this.notifyAll();
//                }
//            }
                //所有线程执行完毕
                if (count.decrementAndGet() == 0) {
                    //通知
                    latch.countDown();
                }
            }
        }
    }

}
