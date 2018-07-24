package synch;

public class Caller implements Runnable {
    String title;
    Output output;
    Thread main;

    public Caller(Output out, String srcTitle) {
        title = srcTitle;
        output = out;
        main = new Thread(this, title);
        main.start();
    }

    @Override
    public void run() {
        output.out(title);
    }
}
