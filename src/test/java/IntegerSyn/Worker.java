package IntegerSyn;

public class Worker implements Runnable {

    private Integer i;
    private  Object object = new Object();

    public Worker(Integer i) {
        this.i = i;
    }

    public void run() {
        synchronized (this){
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"---"+System.identityHashCode(i)+"---"+i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
