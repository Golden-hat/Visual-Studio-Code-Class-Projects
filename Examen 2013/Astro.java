public class Astro{

    public static final int ESTRELLA = 0;
    public static final int NEBULOSA = 1;
    public static final int GALAXIA = 2;

    private String nombre;
    private int tipo;
    private double brillo;
    private double distancia;

    public Astro(String r, int t, double b, double d){
        nombre = r;
        tipo = t;
        brillo = b;
        distancia = d;
    }
    public Astro(){
        nombre = "Sirius";
        brillo = -1.42;
        distancia = 8.7;
        tipo = ESTRELLA;
    }
    
    public void setBrillo(double brilli){
        brillo = brilli;
    }
    public double getBrillo(){
        return brillo;
    }

    @Override

    public boolean equals(Object o){
        return(o instanceof Astro
        && ((Astro) o).nombre.equals(this.nombre)
        && ((Astro) o).tipo == this.tipo
        && ((Astro) o).brillo == this.brillo
        && ((Astro) o).tipo == this.tipo);
    }

    @Override
    
    public String toString(){
        double roundedBrillo = Math.round(Math.pow(10, 2)*brillo)/Math.pow(10, 2);
        double roundedDistance = Math.round(Math.pow(10, 2)*distancia)/Math.pow(10, 2);
        String returnStringTipo;

        if (this.tipo == ESTRELLA){
            returnStringTipo = "estrella";
        }else if (this.tipo == NEBULOSA){
            returnStringTipo = "nebulosa";
        }else{
            returnStringTipo = "galaxia";
        }
        return nombre+": "+returnStringTipo+" ("+roundedBrillo+","+roundedDistance+")";
    }

    public double magnitudAbsoluta(){
        double M = 0;
        M = + 5*Math.log10(distancia);
        return M;
    }
    public int masBrillante(Astro t){   
        int result;
        if(this.magnitudAbsoluta() == t.magnitudAbsoluta()){
            result = 0;
        }
        else if(this.magnitudAbsoluta() > t.magnitudAbsoluta()){
            result = 1;
        }
        else{
            result = -1;
        }
        return result;
    }
    
    public String visibleCon(){
        String result;
        if(brillo < 5){
            result = "Visible a simple vista";
        }
        else if(5 <= brillo && brillo < 7){
            result = "Visible con prismáticos";
        } 
        else if(7 <= brillo && brillo <= 25){
            result = "Visible con telescopio";
        }
        else{
            result = "Visible con grandes telescopios";
        }   
        return result;
    }
}