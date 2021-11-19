import java.util.Scanner;
public class TestAstro {
    public static void main(String[] args) {
        Astro AlfaCentauri = new Astro("Alfa Centauri", 0, 4.6, 4.3);

        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, introduzca el nombre de su Estrella: "); String r = sc.nextLine();
        System.out.println("Tipo de astro. 0.Estrella, 1.Nebulosa, 2.Galaxia: "); int t = sc.nextInt();
        System.out.println("Brillo del astro: "); double b = sc.nextDouble();
        System.out.println("Distancia del astro: "); double d = sc.nextDouble();
    
        Astro NewAstro = new Astro(r, t, b, d);
        System.out.println("\n"+NewAstro.toString()+" "+NewAstro.visibleCon()+"\n"+AlfaCentauri.toString()+" "+AlfaCentauri.visibleCon());
        
        System.out.println(NewAstro.masBrillante(AlfaCentauri));

    }
}
