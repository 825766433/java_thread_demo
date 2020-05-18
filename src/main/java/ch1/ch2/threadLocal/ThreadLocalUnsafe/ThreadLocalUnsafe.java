package ch1.ch2.threadLocal.ThreadLocalUnsafe;

public class ThreadLocalUnsafe extends Thread {

    public static Number number = new Number(0);
    //创建一个ThreadLocal
    ThreadLocal<Number> local = new ThreadLocal<>();

    @Override
    public void run() {
        //每个线程计数加一
        number.setNum(number.getNum()+1);
        //将其存储到ThreadLocal中
        local.set(number);

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //输出num值
        System.out.println(Thread.currentThread().getName()+"="+local.get().getNum());
    }
}

class Run{
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new ThreadLocalUnsafe().start();
        }
    }
}