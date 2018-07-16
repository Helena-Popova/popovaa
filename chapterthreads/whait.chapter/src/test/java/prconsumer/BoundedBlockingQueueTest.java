package prconsumer;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 *  В тестах должны быть две нити. одна продюсер, другая пользователь.
 *
 * Через методы join добавиться последовательного выполнение программы.
 *
 *
 */
public class BoundedBlockingQueueTest {
    BoundedBlockingQueue<Integer> blockingQueue = new BoundedBlockingQueue<>(12);
    private Thread producer;
    private Thread consumer;

    @Before
    public void loadBefore() throws InterruptedException {
        producer = new Thread() {
            @Override
            public void run() {
                try {
                    int i = 0;
                    while (i < 10) {
                        blockingQueue.offer(i);
                        i++;
                    }
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        };

        consumer = new Thread() {
            @Override
            public void run() {
                try {
                    int i = 0;
                    while (i < 10) {
                        assertThat(blockingQueue.getRealSize(), is(10 - i));
                        assertThat(blockingQueue.poll(), is(i));
                        assertThat(blockingQueue.getRealSize(), is(9 - i));
                        i++;
                    }
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        };
    }

    @Test
    public void producerANDconsumerTest() throws InterruptedException {
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }


}