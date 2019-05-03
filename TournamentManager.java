import java.util.Scanner;

/**
 * Auto Generated Java Class.
 */
public class TournamentManager {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Enter 1 to Make a Team");
            System.out.println("Enter 2 to Add Player to Team");
            int userChoice = input.nextInt();
            if(userChoice == 1){
                System.out.print("Team Name: ");
                input.nextLine();
                String teamName = input.nextLine();
                System.out.println(teamName);
            }
            if(userChoice == 2){
                System.out.print("Player Name: ");
                input.nextLine();
                String playerName = input.nextLine();
                System.out.println(playerName);
            }
        }

    }
    
}
