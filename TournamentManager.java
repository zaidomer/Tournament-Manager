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
            System.out.println("Enter 1 To Make a Team");
            System.out.println("Enter 2 To Add Player to Team");
            System.out.println("Enter 3 To Get The Size Of A Team");
            System.out.println("Enter 4 To Get The Size Of The League");
            System.out.println("Enter 5 To Find A Player");
            int userChoice = input.nextInt();
            if(userChoice == 1){
                System.out.print("Team Name: ");
                input.nextLine();
                String teamName = input.nextLine();
                league.add(new Team(teamName));
                System.out.println(teamName + " has been added to the league!");
                System.out.println();
                teamName = null;
            } else if(userChoice == 2){
                if(league.size() > 0){

                    // Get Player info
                    System.out.print("Player Name: ");
                    input.nextLine();
                    String playerName = input.nextLine();

                    System.out.print(playerName + "\'s Goals: ");
                    int goals = input.nextInt();
                    System.out.print(playerName + "\'s Assists: ");
                    int assists = input.nextInt();
                    Player playerToAdd = new Player(playerName, goals, assists);

                    // Find team for player
                    boolean playerAdded = false;
                    System.out.println("What team would you like to add " + playerName + " to?");
                    input.nextLine();
                    String teamForPlayer = input.nextLine();
                    for(int i = 0; i < league.size(); i++){
                        if(((league.get(i)).getTeamName()).equals(teamForPlayer)){
                            Node<Integer> playerNode = new Node<Integer>(playerToAdd.getPoints(), playerToAdd.getName());
                            if((league.get(i)).getPlayerList() != null){
                                BinaryTree<Integer> tempTree = (league.get(i)).getPlayerList();
                                tempTree.add(playerNode);
                                (league.get(i)).setPlayerList(tempTree);
                                playerAdded = true;
                            }else{
                                BinaryTree<Integer> tempTree = new BinaryTree<Integer>();
                                tempTree.add(playerNode);
                                league.get(i).setPlayerList(tempTree);
                                playerAdded = true;
                            }
                            System.out.println(playerName + " has been added to " + teamForPlayer);
                        }
                    }
                    if(playerAdded == false){
                        System.out.println("Team \"" + teamForPlayer + "\" not found. Check team name and try again");
                    }
                    
                }else{
                    System.out.println("There must be a team before you can add a player");
                }
                
            }else if(userChoice == 3){
                input.nextLine();
                boolean sizeDisplayed = false;
                System.out.print("Team Name: ");
                String teamChosen = input.nextLine();
                for(int i = 0; i < league.size(); i++){
                    if(((league.get(i)).getTeamName()).equals(teamChosen)){
                        System.out.println("There are " + ((league.get(i)).getPlayerList()).size(((league.get(i)).getPlayerList()).getRoot()) + " player(s) on that team");
                        sizeDisplayed = true;
                    }
                }
                if(sizeDisplayed == false){
                    System.out.println("Team \"" + teamChosen + "\" not found. Check team name and try again");
                }
                
            }else if(userChoice == 4){
                System.out.println("There are " + league.size() + " team(s) in the league");
            }
        }

    }
    
}
