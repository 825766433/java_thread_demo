package ch1.ch2.threadLocal.notifuAndWait;

public class CheckKm extends Thread {

    private ExpressService expressService;
    private Express express;

    public CheckKm(ExpressService expressService) {
        this.expressService = expressService;
    }

    @Override
    public void run() {
    }
}
