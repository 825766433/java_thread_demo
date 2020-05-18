package ch1.ch2;

public class Demo001 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new wuxianxunhuan());
        thread.start();
        Thread.sleep(500L);
    }

}

class wuxianxunhuan implements Runnable {

    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
            if(i==100){
                Thread.yield();
            }
        }
    }
}