package ch1.ch2;

public class Demo004 {
    private volatile static boolean falg;
    private static Integer number;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThreadDemo004();
        thread.start();
        Thread.sleep(1000L);
        falg=true;
        Thread.sleep(1000L);
        System.out.println("main end");

    }

    public static boolean isFalg() {
        return falg;
    }

    public static void setFalg(boolean falg) {
        Demo004.falg = falg;
    }

    public static Integer getNumber() {
        return number;
    }

    public static void setNumber(Integer number) {
        Demo004.number = number;
    }
}

class MyThreadDemo004 extends Thread{
    @Override
    public void run() {
        while(!Demo004.isFalg()){

        }
        System.out.println("线程run执行完毕");
    }
}