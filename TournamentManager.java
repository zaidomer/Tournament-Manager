import java.util.Scanner;
import java.util.ArrayList;
/**
 * Auto Generated Java Class.
 */
public class TournamentManager {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Create League
        ArrayList<Team> league = new ArrayList<Team>();

        while(true){
            System.out.println("Enter 1 to Make a Team");
            System.out.println("Enter 2 to Add Player to Team");
            int userChoice = input.nextInt();
            if(userChoice == 1){
                System.out.print("Team Name: ");
                input.nextLine();
                String teamName = input.nextLine();
                league.add(new Team(teamName));
                System.out.println(teamName + " has been added to the league!");
                System.out.println();
                teamName = null;
            }
            if(userChoice == 2){
                if(league.size() > 0){

                    // Get Player info
                    System.out.print("Player Name: ");
                    input.nextLine();
                    String playerName = input.nextLine();
                    Player playerToAdd = new Player(playerName);

                    // Find team for player
                    boolean playerAdded = false;
                    System.out.println("What team would you like to add " + playerName + " to?");
                    String teamForPlayer = input.nextLine();
                    for(int i = 0; i < league.size(); i++){
                        if(((league.get(i)).getTeamName()).equals(teamForPlayer)){
                            Node<Integer> playerNode = new Node<Integer>(playerToAdd.getPoints());
                            ((league.get(i)).getPlayerList());
                            playerAdded = true;
                            System.out.println(playerName + "has been added to" + teamForPlayer);
                        }
                    }
                    if(playerAdded == false){
                        System.out.println("Team \"" + teamForPlayer + "\" not found. Check team name and try again");
                    }
                    
                }else{
                    System.out.println("There must be a team before you can add a player");
                }
                
            }
        }

    }
    
}
