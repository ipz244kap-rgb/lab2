final class Authenticator {
    private static Authenticator uniqueInstance;
    private static final Object syncLock = new Object();

    private Authenticator() {
    }

    public static Authenticator getInstance() {
        synchronized (syncLock) {
            if (uniqueInstance == null) {
                System.out.println("Створено унікальний екземпляр Authenticator");
                uniqueInstance = new Authenticator();
            }
            return uniqueInstance;
        }
    }
}

public class task3 {
    static void testSingleton() {
        Authenticator.getInstance();
    }

    public static void main(String[] args) throws InterruptedException {
        Authenticator.getInstance();
        Authenticator.getInstance();

        Thread threadA = new Thread(task3::testSingleton);
        Thread threadB = new Thread(task3::testSingleton);

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
    }
}