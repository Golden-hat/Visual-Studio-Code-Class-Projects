package examples.topic1;

import libraries.dataStructures.linear.ArrayQueue;
import libraries.dataStructures.models.Queue;

public class PatientManager {
    private Queue<Patient> q;
    private double appointmentHour;
    private static final int MAXIMUM_DAILY_PATIENTS = 40;
    private static final double HOUR_FIRST_SLOT = 9.00;
    private static final double AVERAGE_VISIT_LENGTH = 0.15;
    
    public PatientManager() {
        q = new ArrayQueue<Patient>();
        appointmentHour = HOUR_FIRST_SLOT;
    }

    public String scheduleAppointment(Patient x) {
        String res = "Wait a moment; checking if tomorrow there's availability ... ";
        boolean accepted = (q.size() <= MAXIMUM_DAILY_PATIENTS);
        if (!accepted) res += "\nI'm sorry. There are no appointments left for tomorrow";
        else{
            q.enqueue(x);
            res += "\nConfirmed, we expect you tomorrow at "
                + String.format("%2.2f", appointmentHour);
            appointmentHour += AVERAGE_VISIT_LENGTH;
            if (appointmentHour - Math.round(appointmentHour) < 0.0)
                appointmentHour = Math.round(appointmentHour);
        }
        return res;
    }

    public String toString() {
        return "History of your " + q.size
            + " Patients tomorrow in visiting order\n" + q;
    }                    
}