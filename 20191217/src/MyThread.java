public class MyThread {
    private static class Mythread extends Thread {
        @Override
        public void run() {
            System.out.println("这里是线程运行起来的代码");
        }
    }

    public static void main1(String[] args) {
        Mythread t = new Mythread();
        t.start();
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "这里是线程运行的代码");

        }
    }

    public static void main2(String[] args) {
        //使用匿名类创建Thread子类对象
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("匿名创建的子类对象");
            }
        };

        //使用匿名类创建Runnable子类对象
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名类");
            }
        });

        //使用lambda表达式创建runnable子类对象
        Thread t3 = new Thread(() -> System.out.println("匿名类")); //与t相同
        Thread t4 = new Thread(() -> System.out.println("也是匿名类创建"));//与t1相同

        t.start();
        t1.start();
        t3.start();
        t4.start();
    }

    public static void main(String[] args){
        Thread t1 = new Thread();
        Thread t2 = new Thread(new MyRunnable());
        Thread t3 = new Thread("这是我的名字");
        t3.start();
        Thread t4 = new Thread(new MyRunnable(),"这是我的名字");
        t4.start();
    }



}
