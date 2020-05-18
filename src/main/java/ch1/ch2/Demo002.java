package ch1.ch2;

public class Demo002 {

    public static void main(String[] args) throws InterruptedException {
        MyThreadDemo002 thread = new MyThreadDemo002();
        thread.start();
//        MyThreadDemo002 thread2 = new MyThreadDemo002();
        Thread.sleep(5000L);
        thread.start();
    }

}

class MyThreadDemo002 extends Thread{
    public MyThreadDemo002() {
        System.out.println("MyThreadDemo002()");
    }

    @Override
    public void run() {
        synchronized ("11"){
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run()");
        }

    }
}
