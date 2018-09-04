package threads;

public class PrintMessage extends Thread {
    Time time;
    int interval;
    int timeToStop;

    public PrintMessage(Time time, int interval, int timeToStop) {
        this.time = time;
        this.interval = interval;
        this.timeToStop = timeToStop;
    }

    @Override
    public void run() {
        do {
            synchronized (time) {
                try {
                    time.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (time.getTime() != 0 && time.getTime() % interval == 0) {
                System.out.println("Thread with interval " + interval);
            }
            if (time.getTime() == timeToStop) interrupt();
        } while (!isInterrupted());
    }
}
