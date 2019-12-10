public class ThreadFields {
    public static void main(String[] args){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getId());
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println(thread.getState());
        System.out.println(thread.isDaemon());
        System.out.println(thread.isAlive());
        System.out.println(thread.isInterrupted());
    }
}
