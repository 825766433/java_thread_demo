package IntegerSyn;

public class TestIntegerSyn {

    public static void main(String[] args) {

        Worker worker = new Worker(1);
        for (int i = 0; i < 5; i++) {
            new Thread(worker).start();
        }

    }

}
