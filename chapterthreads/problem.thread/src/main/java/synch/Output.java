package synch;

public class Output {

    /**
     * вот тут надо вставить synchronized
     * @param msg
     */
    public synchronized void out(String msg) {
        System.out.print("{" + msg.substring(0, msg.length() / 2));
        try {
            Thread.sleep(300);
        } catch (InterruptedException io) {
            System.out.println(io.getMessage());
        }
        System.out.println(msg.substring(msg.length() / 2) + "}");
    }
}
