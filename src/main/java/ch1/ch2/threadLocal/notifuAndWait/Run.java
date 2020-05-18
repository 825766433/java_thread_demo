package ch1.ch2.threadLocal.notifuAndWait;

public class Run {

    private static Express express = new Express(0,"北京");

    /*检查里程数变化的线程,不满足条件，线程一直等待*/
    static class CheckKm extends Thread{
        @Override
        public void run() {
            express.waitKm();
        }
    }

    /*检查地点变化的线程,不满足条件，线程一直等待*/
    static class CheckSite extends Thread{
        @Override
        public void run() {
            express.waitSite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<3;i++){
            new CheckSite().start();
        }
        for(int i=0;i<3;i++){
            new CheckKm().start();
        }

        //原因：改变了km，其中三个线程执行完毕了，所以后面再notifyall，那三个已经执行完毕了
        //就不会继续等待了，也就是里面的run方法已经执行完毕，就被GC了
        Thread.sleep(2000);
        express.changeKm();//快递地点变化
        Thread.sleep(2000);
        System.out.println();
        System.out.println();
        System.out.println();
        express.changeKm2();//快递地点变化
        Thread.sleep(2000);
        System.out.println();
        System.out.println();
        System.out.println();
        express.changeKm();//快递地点变化
    }

}
