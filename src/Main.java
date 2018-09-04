import threads.PrintMessage;
import threads.PrintTime;
import threads.Time;

public class Main {

    public static void main(String[] args) {
        Time time = new Time();
        PrintTime printTime = new PrintTime(50, time);
        printTime.start();

        PrintMessage printMessage1 = new PrintMessage(time, 5, 50);
        PrintMessage printMessage2 = new PrintMessage(time, 7, 50);

        printMessage2.start();
        printMessage1.start();


    }
}
