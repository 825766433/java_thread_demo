package ch1.ch2.threadLocal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalOOM {

    final static ThreadPoolExecutor poolExecutor
            = new ThreadPoolExecutor(100, 100,
            1,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());

    static class LocalVariable {
        private byte[] a = new byte[1024*1024*100];/*5M大小的数组*/
    }

    final static ThreadLocal<LocalVariable> localVariable
            = new ThreadLocal<>();



    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        /*5*5=25*/
        for (int i = 0; i < 500; ++i) {
            poolExecutor.execute(new Runnable() {
                public void run() {
                    localVariable.set(new LocalVariable());
//                    new LocalVariable();
                    System.out.println("use local varaible");
                    localVariable.remove();
                }
            });

            Thread.sleep(100);
        }
        System.out.println("pool execute over");
    }

}