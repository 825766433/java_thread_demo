package ch1.ch2;

public class Count extends Thread {

    private SynTest synTest;

    public Count(SynTest synTest) {
        this.synTest = synTest;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synTest.incCount();
        }
    }

}
