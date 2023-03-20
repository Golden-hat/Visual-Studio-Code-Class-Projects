package segundoB.csd.EjerciciosTema3;
import java.util.concurrent.locks.Condition;

public class Synchronous{
    Condition OK; //,OKsender OKreceiver;
    int senders_waiting, receivers_waiting;
    String msg;

    public Synchronous(){
        senders_waiting = receivers_waiting = 0;
        msg = "";
    }

    public void send(String m) {
        if (receivers_waiting > 0) {
        msg = m;
            // OKreceiver.notify();
        } else {
        senders_waiting++;
        // OKsender.wait();
        senders_waiting--;
        msg = m;
        }
    }

    public String receive() {
        if (senders_waiting > 0) {
        // OKsender.notify();
        } else {
        receivers_waiting++;
        // OKreceiver.wait();
        receivers_waiting--;
        }
        return msg;
    }

// Works with Hoare. See cases:
// 1) First Sender arrives … then Receiver
// • Sender waits at OKsender
// • Receiver notifies to OKsender, then goes to special queue
// • Sender reactivates and goes into the monitor, updates msg and leaves
// • Receiver goes into monitor, returns msg (OK)
// 2) First Receiver arrives … then Sender
// • Receiver waits at OKreceiver
// • Sender updates msg and notifies Okreceiver and goes to special queue
// • Receiver reactivates and goes into the monitor, and returns msg (OK).
// Leaves monitor
// • Sender goes into monitor and finishes. 

// Doesn’t work with Lampson-Redell. See cases:
// 1) First Sender arrives … then Receiver
// • Sender waits at OKsender
// • Receiver notifies to Oksender and continues at monitor
// • Sender goes to entry queue of the monitor
// • Receiver returns msg (which has not been updated yet) à ERROR!!
// 2) First Receiver arrives … then Sender
// • Receiver waits at OKreceiver
// • Sender updates msg and notifies Okreceiver and continues at the monitor
// • Receiver goes to entry queue of the monitor
// • Sender finishes and now Receiver can enter inside the monitor
// • Receiver returns msg (OK)

}