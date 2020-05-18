package ch1.ch2.threadLocal;

public class UseThreadLocal {

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public ThreadLocal<Integer> getThreadLocal() {
        return threadLocal;
    }

    public void setThreadLocal(ThreadLocal<Integer> threadLocal) {
        this.threadLocal = threadLocal;
    }
}

class UseThreadLocalDemoThread extends Thread{
    UseThreadLocal useThreadLocal = new UseThreadLocal();

    Integer id;

    public UseThreadLocalDemoThread(Integer id) {
        this.id = id;
    }

    @Override
    public void run() {
        ThreadLocal threadLocal = useThreadLocal.getThreadLocal();
        Integer s = (Integer) threadLocal.get();
        System.out.println("id = "+id);
        threadLocal.set(s+id);
        System.out.println("set = "+threadLocal.get());
    }
}

class Run{

    public static void main(String[] args) throws InterruptedException {
        UseThreadLocal local= new UseThreadLocal();
        for (int i = 0; i <3 ; i++) {
            new UseThreadLocalDemoThread(i).start();
//            Thread.sleep(500L);
        }

    }
}