package task.third;

public class Produser {

    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        synchronized (monitor) {
            monitor.wait();
        }
    }
}
