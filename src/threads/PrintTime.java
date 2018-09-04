package threads;

public class PrintTime extends Thread {
    static int timer;
    Time time;
    int timeToStop;

    public PrintTime(int timeToStop, Time time) {
        this.timeToStop = timeToStop;
        this.time = time;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {

            try {
                Thread.sleep(1000);
                time.incTime();
                synchronized (time) {
                    time.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (timeToStop == time.getTime()) interrupt();
            System.out.println(time.getTime());
        }
    }
}
