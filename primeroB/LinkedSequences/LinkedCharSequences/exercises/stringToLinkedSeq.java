package primeroB.LinkedSequences.LinkedCharSequences.exercises;
import primeroB.LinkedSequences.LinkedCharSequences.LinkedCharSequence;
import primeroB.LinkedSequences.LinkedCharSequences.NodeChar;

public class stringToLinkedSeq {
    public LinkedCharSequence k = new LinkedCharSequence();
    public static void main(String[] args) {
        
        String a = "Examen";
        convertToLinkedSeq(a);
        k.toString();
    }

    public static NodeChar convertToLinkedSeq(String s){
        if(s.length() != 0){
            NodeChar n = new NodeChar(s.charAt(0));
            return n;
        }else{
            return null;
        }
    }
}
