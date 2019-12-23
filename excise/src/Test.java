//懒汉模式
public class Test {
    private static volatile Test instance = null;
    private Test() {
    }

    public static Test getInstance() {
        if (instance == null) {
            synchronized (Test.class) {
                if (instance == null) {
                    instance = new Test();
                }
            }
        }
        return instance;
    }
}
