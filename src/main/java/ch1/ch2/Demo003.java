package ch1.ch2;

public class Demo003 {

    public static void main(String[] args) {
        Thread thread = new MyDeme003Thread(0);
        for (int i = 0; i < 5; i++) {
            new Thread(thread).start();
        }

    }


}

class MyDeme003Thread extends Thread {
    private Integer integer;

    public MyDeme003Thread(Integer integer) {
        this.integer = integer;
    }

    @Override
    public void run() {
        synchronized (integer) {
            integer++;
            System.out.println(Thread.currentThread().getName() + "--@" + System.identityHashCode(integer));

            System.out.println(integer);
        }
    }

}