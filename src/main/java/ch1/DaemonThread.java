package ch1;

public class DaemonThread {

    private static class UseThread extends Thread{

        @Override
        public void run() {
            try {
                while (!interrupted()){
                    System.out.println(Thread.currentThread().getName()
                            +"I am extends Thread");
                }
                System.out.println(Thread.currentThread().getName()
                        +"interrupt flag is "+ isInterrupted());
            } finally {
                System.out.println("..........finally");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new UseThread();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1000L);
        thread.interrupt();
        System.out.println();
        Thread.sleep(3000L);
    }

//    public static void main(String[] args) throws InterruptedException {
//        Thread.currentThread().interrupt();
//        System.out.println(Thread.currentThread().isInterrupted());
//        System.out.println(Thread.interrupted());
//
//    }

}
