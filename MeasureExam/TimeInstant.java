package MeasureExam;
public class TimeInstant{

    private int hours;
    private int minutes;

    public TimeInstant(){
        long SystemMinutes= System.currentTimeMillis()/(60*1000);
        long currentMinutes= (int) ( SystemMinutes % (24*60)+120);
        int finalHours = (int) currentMinutes/(60);
        int finalMinutes = (int) currentMinutes % (60);
  
        hours = finalHours;
        minutes = finalMinutes;
    }

    public TimeInstant( int iniHours, int iniMinutes){
        hours = iniHours;
        minutes = iniMinutes;
    }

    public int toMinutes(){
        return hours*60+minutes;
    }
    public int getPeriod(){
        return 0;
    }
    public String toString(){
        String hh= "0"+hours;
        String mm= "0"+minutes;
        hh = hh.substring(hh.length()-2);
        mm = mm.substring(mm.length()-2);

        return hh+":"+mm;
    }
}
