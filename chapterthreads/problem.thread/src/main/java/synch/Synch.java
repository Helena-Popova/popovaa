package synch;

public class Synch {

    public static void main(String[] args) {
        Output output = new Output();
        Caller caller1 = new Caller(output, "Добро пожаловать ");
        Caller caller2 = new Caller(output, "в синхрониированный ");
        Caller caller3 = new Caller(output, "мир");
    }
}
