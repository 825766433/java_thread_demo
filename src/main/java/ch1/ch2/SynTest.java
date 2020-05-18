package ch1.ch2;

public class SynTest {

    private Integer count = 0;

    public synchronized void incCount(){
        synchronized (this){
            count++;
        }
    }

    public  Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
