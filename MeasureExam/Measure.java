package MeasureExam;
public class Measure {
    public static final double MAX_DAY_TIME = 65.0;
    public static final double MAX_NIGHT_TIME = 30.0;
    public static final String DEFAULT_STATION ="AYUNTAMIENTO";

    private TimeInstant instant;
    private double noise;
    private String station;
    private int period;

    public Measure(String e, TimeInstant t, double r){
        this.station = e;
        this.instant = t;
        this.noise = r;
        this.period = t.getPeriod();
    }

    public Measure(){
        station = Measure.DEFAULT_STATION; // como es estática, se pone Measure. (public static final string default station...)
        instant = new TimeInstant();
        period = instant.getPeriod();
        noise = random(20.0, 200.0);
    }

    private double random (double a, double b){
        return a+(b-a+1)*Math.random();
    }

    public double getNoise (double noise){
        return noise;
    }

    @Override // sirve para evitar errores lógicos al compilar

    public boolean equals (Object o){
        if (o instanceof Measure){
            Measure other = (Measure)o; //necesario, porque oinstant no se puede hacer ya que o no pertenece a instant sino a Objetcs, por lo que se tiene que asignar other a o)
            return this.instant.equals (other.instant)&&
            //this.noise == other.noise; está MAL
            Math.abs(this.noise - other.noise) <= 10e-6;
        }
        else{
            return false;
        }
    }
    public boolean exceedMax(){
        switch(this.period){
            case 1:
            return this.noise > Measure.MAX_DAY_TIME;
            default:
            return this.noise > Measure.MAX_NIGHT_TIME;
        }
    }

    @Override
    public String toString(){
        return instant.toString()+" "+station+String.format(" %.2f", noise);
    }

    public void compareTo(Measure other){

        // int a = instant.getHours()*100+instant.getMinutes();
        // int b = other.instnat.getHours()*100+other.instant.getMinutes();
    }
}
