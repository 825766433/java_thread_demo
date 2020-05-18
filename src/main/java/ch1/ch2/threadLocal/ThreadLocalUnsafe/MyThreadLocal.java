package ch1.ch2.threadLocal.ThreadLocalUnsafe;

public class MyThreadLocal {

    ThreadLocal<Number> value = new ThreadLocal<Number>();

    public ThreadLocal<Number> getThreadLocal() {
        return value;
    }
}
