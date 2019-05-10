import java.util.Scanner;
import java.util.ArrayList;

/**
 * Auto Generated Java Class.
 */
public class TournamentManager {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        boolean coninueProgram = true;
        
        //Create League
        ArrayList<Team> league = new ArrayList<Team>();
        
        //Load previous teams information
        DataLoader loadData = new DataLoader();
        league = loadData.loadTeams();
        
        //Load previous players Information
        ArrayList<Player> players = loadData.loadPlayers();
        for(int i = 0; i < players.size(); i++){
            Player playerRetrieved = new Player((players.get(i)).getName(), (players.get(i)).getGoals(), (players.get(i)).getAssists(), (players.get(i)).getTeam());
            BinaryTreeNode<Integer> playerRetrievedNode = new BinaryTreeNode<Integer>(playerRetrieved.getPoints(), playerRetrieved.getName());
            BinaryTree<Integer> retrievedTree = new BinaryTree<Integer>();
            for(int k = 0; k < league.size(); k++){
                if((players.get(i)).getTeam().equals(league.get(k).getTeamName())){
                    retrievedTree = (league.get(k)).getPlayerList();
                    retrievedTree.add(playerRetrievedNode);
                    (league.get(k)).setPlayerList(retrievedTree);
                }
            }
            retrievedTree = null;
        }
        
        //Program Loop
        while(coninueProgram == true){
            System.out.println("Enter 1 To Make a Team");
            System.out.println("Enter 2 To Add Player to Team");
            System.out.println("Enter 3 To Get The Size Of A Team");
            System.out.println("Enter 4 To Get The Size Of The League");
            System.out.println("Enter 5 To Find A Player");
            System.out.println("Enter 6 To Remove A Player");
            System.out.println("Enter 7 To Organize Games");
            System.out.println("Enter 7 To Exit");
            int userChoice = input.nextInt();
            
            if(userChoice == 1){
                System.out.print("Team Name: ");
                input.nextLine();
                String teamName = input.nextLine();
                Team teamToAdd = new Team(teamName);
                league.add(teamToAdd);
                System.out.println(teamName + " has been added to the league!");
                teamToAdd.save();
                teamToAdd.saveFileReference();
                System.out.println("Team has been saved");
                System.out.println();
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
                    
                    
                    // Find team for player
                    boolean playerAdded = false;
                    System.out.println("What team would you like to add " + playerName + " to?");
                    input.nextLine();
                    String teamForPlayer = input.nextLine();
                    Player playerToAdd = new Player(playerName, goals, assists, teamForPlayer);
                    for(int i = 0; i < league.size(); i++){
                        if(((league.get(i)).getTeamName()).equals(teamForPlayer)){
                            BinaryTreeNode<Integer> playerBinaryTreeNode = new BinaryTreeNode<Integer>(playerToAdd.getPoints(), playerToAdd.getName());
                            BinaryTree<Integer> tempTree = (league.get(i)).getPlayerList();
                            tempTree.add(playerBinaryTreeNode);
                            (league.get(i)).setPlayerList(tempTree);
                            playerAdded = true;
                            System.out.println(playerName + " has been added to " + teamForPlayer);
                        }
                    }
                    if(playerAdded == false){
                        System.out.println("Team \"" + teamForPlayer + "\" not found. Check team name and try again");
                    }else{
                        playerToAdd.save();
                        playerToAdd.saveFileReference();
                        System.out.println("Player has been saved");
                    }
                    
                }else{
                    System.out.println("There must be a team before you can add a player");
                }
                System.out.println();
            }else if(userChoice == 3){
                input.nextLine();
                boolean sizeDisplayed = false;
                System.out.print("Team Name: ");
                String teamChosen = input.nextLine();
                for(int i = 0; i < league.size(); i++){
                    if(((league.get(i)).getTeamName()).equals(teamChosen)){
                        System.out.println("There are " + ((league.get(i)).getPlayerList()).size(((league.get(i)).getPlayerList()).getRoot()) + " player(s) on that team");
                        System.out.println();
                        sizeDisplayed = true;
                    }
                }
                if(sizeDisplayed == false){
                    System.out.println("Team \"" + teamChosen + "\" not found. Check team name and try again");
                }
                
            }else if(userChoice == 4){
                System.out.println("There are " + league.size() + " team(s) in the league");
            }else if(userChoice == 5){
                System.out.print("Player Name: ");
                input.nextLine();
                String playerName = input.nextLine();
                boolean playerFound = false;
                Player playerSearched = null;
                for(int i = 0; i < league.size(); i++){
                    if(league.get(i).getPlayerList().containsNodeName(playerName, league.get(i).getPlayerList().getRoot())){
                        playerSearched = loadData.loadIndividualPlayer(playerName);
                        playerFound = true;
                    }
                }
                if(playerFound == false){
                    System.out.println("Player \"" + playerName + "\" not found");
                }else{
                    System.out.println();
                    System.out.println("Name: " + playerSearched.getName());
                    System.out.println("Team: " + playerSearched.getTeam());
                    System.out.println("Goals: " + playerSearched.getGoals());
                    System.out.println("Assists: " + playerSearched.getAssists());
                    System.out.println("Points: " + playerSearched.getPoints());
                    System.out.println();
                }
            }else if(userChoice == 6){
                
            }else if(userChoice == 7){
                coninueProgram = false;
            }
        }
        input.close();
    }
    
}
