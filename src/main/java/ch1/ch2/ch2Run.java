package ch1.ch2;

public class ch2Run {

    public static void main(String[] args) throws InterruptedException {
        SynTest test = new SynTest();

        Count count1 = new Count(test);
        Count count2 = new Count(test);
        Thread thread1 = new Thread(count1);
        Thread thread2 = new Thread(count2);
        thread1.start();
        thread2.start();

        Thread.sleep(1000L);
        System.out.println(test.getCount());

    }

}
