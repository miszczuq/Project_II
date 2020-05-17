import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class MyTimer extends Thread {
    private static int day =1 ;
    private static List<VirusSpreadListener> list= new ArrayList<>();
    public MyTimer(){
        start();
    }

    public static void addVirusSpreadListener(VirusSpreadListener v){
        list.add(v);
    }

    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fireEvent(new EventObject(this));
            ++day;
        }
    }
    private void fireEvent(EventObject e){
        for(VirusSpreadListener v : list){
            v.SpreadVirus();
        }
    }

    public static int getDay() {
        return day;
    }
    public static void increaseDay(){
        day += 1;
    }
}
