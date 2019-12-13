public class YieldDemon {
    private static class MyThread extends Thread {
        private static  String name;
        private static  String messgae;

        public MyThread(String name,String message) {
            super(name);
            this.messgae = message;
        }

        @Override
        public void run() {
            System.out.println( MyThread.currentThread().getName() + " " + messgae);
        }
    }


    private static class MyThread2 extends Thread {
        private static  String name;
        private static  String messgae;

        public MyThread2(String name,String message) {
            super(name);
            this.messgae = message;
        }

        @Override
        public void run() {
            System.out.println(MyThread2.currentThread().getName() + " " + messgae);
        }
    }

    public static void main(String[] args){
        MyThread myThread = new MyThread("自私的","在唱歌");
        MyThread2 myThread2 = new MyThread2("无私的","也在唱歌");
        myThread.start();
        myThread2.start();
    }
}
