package ch1.Demo001.DiffInstance;

public class DiffInstance {
    private static Object object = new Object();

    public DiffInstance() {
        System.out.println("DiffInstance()");
    }

    synchronized static void  Instance() throws InterruptedException {
//        synchronized (object){
            Thread.sleep(3000L);
            System.out.println("Instance().running");
//        }

    }
//
    synchronized static void Instance2() throws InterruptedException {
//        synchronized (object) {
            Thread.sleep(3000L);
            System.out.println("Instance2().running");
//        }
    }

    public static void main(String[] args) {
        InstanceSys instanceSys = new InstanceSys(new DiffInstance());
        Instance2Sys instanceSy2 = new Instance2Sys(new DiffInstance());
        Thread thread1 = new Thread(instanceSys);
        Thread thread2 = new Thread(instanceSy2);

        thread1.start();
        thread2.start();

    }

}

class InstanceSys implements Runnable {
    private DiffInstance diffInstance;

    public InstanceSys(DiffInstance diffInstance) {
        this.diffInstance = diffInstance;
    }

    public void run() {
        System.out.println("InstanceSys.run()");
        try {
            diffInstance.Instance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Instance2Sys implements Runnable {
    private DiffInstance diffInstance;

    public Instance2Sys(DiffInstance diffInstance) {
        this.diffInstance = diffInstance;
    }

    public void run() {
        System.out.println("Instance2Sys.run()");
        try {
            diffInstance.Instance2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}