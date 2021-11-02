public class PieceOfNews {
    public static final int AUDIO = 0;
    public static final int VIDEO = 1;
    public static final int TEXT = 2;

    private TimeInstant instant;
    private int type;
    private int echoedBy;
    private String link;

    public PieceOfNews(TimeInstant i, int t, int n, String l){
        instant = i;
        type = t;
        echoedBy = n;
        link = l;
    }

    @Override

    public boolean equals (Object o){
        return (o instanceof PieceOfNews)
        && this.instant.equals((PieceOfNews) o). instant)
        && this.echoedBy == ((PieceOfNews) o).echoedBy
        && this.type == ((PieceOfNews) o).type;
    }

    public int compareTo (PieceOfNews other){
        int rc = this.instant.compareTo(other.instant);
        if(rc != 0){
            return rc;
        }
        else{
            rc = this.echoedBy - other.echoedBy;
            if(rc != 0){
                return rc;
            }else{
                return this.type - other.type;
            }
        }
    }

    public String toString(){

        String res = "";
        res += instant.toString() + " " + link + " " + echoedBy + " (";
        switch (type) {
        case TEXT:
        res += "text)"; break;
        case VIDEO:
        res += "video)"; break;
        default:
        res += "audio)";
        }
        return res;

    }

}
