package primeroB.LinkedSequences.LinkedIntSequences.exercises;
import primeroB.LinkedSequences.LinkedIntSequences.LinkedIntSequence;
import primeroB.LinkedSequences.LinkedIntSequences.NodeInt;

public class evenReturn {
    public static void main(String[] args) {
        LinkedIntSequence k = new LinkedIntSequence();
        int a[] = {4, 7, 2, 8, 9, 3, 6};
        k.appendArrayNumbers(a);
        System.out.print(evenNumbersReturn(k));
        System.out.println(eNRet(k));
    }


    //Implementación con LinkedIntSequences
    public static LinkedIntSequence evenNumbersReturn(LinkedIntSequence q){
        LinkedIntSequence aux = new LinkedIntSequence();
        NodeInt p = q.getFirst();
    
        while(p != null){
            if(p.getData()%2 == 0){
                aux.append(p.getData());
            }
            p = p.next;
        }
        return aux;
    }

    //Implementación directa con NodeInt. Se usa una LinkedSequence como argumento por conveniencia.
    public static NodeInt eNRet(LinkedIntSequence q){
        NodeInt first = null;
        NodeInt last = null;

        NodeInt p = q.getFirst();
        while(p != null){
            if(p.getData()%2 == 0){
                if(first == null){
                    first = new NodeInt(p.getData(), null);
                    last = first;
                }
                else{
                    last.next = new NodeInt(p.getData(), null);
                    last = last.next;
                }
            }
            p = p.next;
        }
        return first;
    }
}
