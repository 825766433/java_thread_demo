package ch1;

import com.sun.org.apache.bcel.internal.generic.GOTO;

public class UseJoin {

    static class Goddess implements Runnable {
        private Thread thread;

        public Goddess(Thread thread) {
            this.thread = thread;
        }

        public Goddess() {
        }

        public void run() {
            System.out.println("Goddness开始排队打饭。。。");
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //打饭，休眠两秒
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Goddness打饭完成。。。");
        }
    }

    static class GoddessBoyFriend implements Runnable{

        public void run() {
            try {
                System.out.println("GoddnessBoyfriends开始打饭。。。");
                Thread.sleep(2000L);
                System.out.println("GoddnessBoyfriends打饭完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        GoddessBoyFriend goddessBoyFriend = new GoddessBoyFriend();
        Thread thread2 = new Thread(goddessBoyFriend);
//        Goddess goddess = new Goddess();
        Goddess goddess = new Goddess(thread2);
        Thread thread1 = new Thread(goddess);
        thread1.start();
        thread2.start();
        Thread.yield();
        System.out.println("lison开始打饭。。。");
        thread1.join();
        Thread.sleep(2000L);
        System.out.println("lison打饭完成。。。。");
    }

}
