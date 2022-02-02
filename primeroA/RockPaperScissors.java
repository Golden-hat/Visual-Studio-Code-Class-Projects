package primeroA;

import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {
        
        System.out.println("Bienvenido a ROCK-PAPER-SCISSORS");
        System.out.println("\nPor favor, introduce tu opción:");
        System.out.println("1.Rock");
        System.out.println("2.Paper");
        System.out.println("3.Scissors\n");

        Scanner sc = new Scanner(System.in);
        String selection = sc.nextLine().toLowerCase();
        String computerOption = generateComputerOption().toLowerCase();

        String result = null;

        switch(selection){
            case "rock":
            switch(computerOption){
                case "rock": result = "Empate!"; break;
                case "paper": result = "Has perdido!"; break;
                case "scissors": result = "Has ganado!"; break;   
            }
            break;
            case "paper":
            switch(computerOption){
                case "rock": result = "Has ganado!";break;
                case "paper": result = "Empate!";break;
                case "scissors": result = "Has perdido!";break;
            }
            break;
            case "scissors":
            switch(computerOption){
                case "rock": result = "Has perdido!";break;
                case "paper": result = "Has ganado!";break;
                case "scissors": result = "tied!";break;
            }
            break;
            default:
            System.out.println("Por favor, inserta un valor válido!");
        }
        sc.close();
        System.out.println(selection+" vs "+computerOption);
        if(result!=null)System.out.println(result);

    }

    public static String generateComputerOption(){

        String computerOption = null;

        switch((int)(3*Math.random())){

            case 0:
            computerOption = "rock";
            break;
            case 1:
            computerOption = "paper";
            break;
            case 2:
            computerOption = "scissors";
            break;
        }
        return computerOption;
    }
}
