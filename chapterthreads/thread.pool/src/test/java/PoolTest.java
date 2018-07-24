import org.junit.Test;

import static org.junit.Assert.*;

public class PoolTest {

    @Test
    public void threadPoolTest() throws InterruptedException {
        ThreadPool threadPool = new Pool();
        threadPool.work(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis() + Thread.currentThread().getName());
                }
            }
        });

        Thread.sleep(2000);

        threadPool.shutdown();

    }

}