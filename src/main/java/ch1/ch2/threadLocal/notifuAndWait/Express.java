package ch1.ch2.threadLocal.notifuAndWait;

public class Express {

    //里程数,当快递里程数发生了变化，需要进行通知
    private int km;
    //快递所在地，快递地点发生了变化，需要进行通知
    private String site;

    public Express() {
    }

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    //变化公里数，然后通知处于wait状态并需要处理公里数的线程进行相关业务处理
    public synchronized void changeKm(){
        this.km=99;
        notifyAll();
    }

    public synchronized void changeKm2(){
        this.km=101;
        notifyAll();
    }

    //变化地点，然后通知处于wait状态并需要处理地点的线程进行业务处理
    public synchronized void changeSite(){
        this.site="北京";
        notifyAll();
    }

    //如果公里数进行了变化，则进行相应业务操作，例如入库
    public synchronized void waitKm(){
        while (this.km<100){
            try {
                wait();
                System.out.println("已进入waitKm方法循环体中，无法进行相应业务处理");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("waitKm(Express express)真正处理方法");

    }

    //如果地点进行了变化，则进行相应业务操作，例如入库
    public synchronized void waitSite(){
        while (this.site.equals("北京")){//false
            try {
                wait();
                System.out.println("已进入waitSite方法循环体中，无法进行相应业务处理");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("waitSite(Express express)真正处理方法");
    }
}
