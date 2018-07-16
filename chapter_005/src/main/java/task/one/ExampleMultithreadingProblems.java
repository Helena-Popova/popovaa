package task.one;


import lombok.Data;
import lombok.Getter;

@Data
public class ExampleMultithreadingProblems {
    private long count = 0;

    @Data
    public static class ThreadExample extends Thread {
        private ExampleMultithreadingProblems emp;

        public ThreadExample(ExampleMultithreadingProblems exP) {
            this.emp = exP;
        }

        @Override
        public void run() {
            synchronized (this.emp) {
                emp.setCount(emp.getCount() + 1);
            }
        }

    }

    /**
     * Если закомитить обе строки thread1.join(); и thread2.join(); - то будет выводиться 0,
     * если  только thread2.join(); - то инногда будет выводиться 1 , инногда 2,
     * если только thread1.join(); -  то будет быводиться 2,
     * так как основной поток будет ждать выполнения второго потока
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExampleMultithreadingProblems problems = new ExampleMultithreadingProblems();
        Thread thread1 = new ThreadExample(problems);
        Thread thread2 = new ThreadExample(problems);

        thread1.start();
        thread2.start();
        thread1.join();
        //thread2.join();
        System.out.println(problems.getCount());
    }


}
