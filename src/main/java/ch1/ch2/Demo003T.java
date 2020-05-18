package ch1.ch2;

public class Demo003T {
    public static void main(String[] args) throws InterruptedException {
        Worker worker=new Worker(1);
        //Thread.sleep(50);
        for(int i=0;i<5;i++) {
            new Thread(worker).start();
        }
    }
}

class Worker implements Runnable{

    private Integer i;
    private Object o = new Object();

    public Worker(Integer i) {
        this.i=i;
    }

    public void run() {
        synchronized (o) {
            Thread thread=Thread.currentThread();
            System.out.println(thread.getName()+"--@"
                    +System.identityHashCode(i));
            i++;
            System.out.println(thread.getName()+"-------"+i+"-@"
                    +System.identityHashCode(i));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName()+"-------"+i+"--@"
                    +System.identityHashCode(i));
        }

    }

}