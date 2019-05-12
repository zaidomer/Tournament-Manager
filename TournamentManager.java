import java.util.Scanner;
import java.util.ArrayList;

/**
 * Auto Generated Java Class.
 */
public class TournamentManager {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        boolean coninueProgram = true;
        
        //Create League, Games Schedule, Data Finder
        ArrayList<Team> league = new ArrayList<Team>();
        Queue<Game> schedule = new Queue<Game>();
        DataFinder findData = new DataFinder();
        
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

        //Load Schedule
        schedule = loadData.loadSchedule(league, false);
        
        //Program Loop
        while(coninueProgram == true){
            System.out.println("Enter 1 To Make a Team");
            System.out.println("Enter 2 To Add Player to Team");
            System.out.println("Enter 3 To Get The Size Of A Team");
            System.out.println("Enter 4 To Get The Size Of The League");
            System.out.println("Enter 5 To Find A Player");
            System.out.println("Enter 6 To Remove A Player");
            System.out.println("Enter 7 To Organize Games");
            System.out.println("Enter 8 To Record Game Info");
            System.out.println("Enter 9 To View Schedule");
            System.out.println("Enter 10 To View Completed Game Results");
            System.out.println("Enter 11 To Exit");
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
                System.out.println();
                System.out.println("There are currently " + schedule.size() + " games scheduled");

                //Team one
                System.out.print("Team One: ");
                input.nextLine();
                String teamOneName = input.nextLine();
                Team teamOne = findData.findTeam(teamOneName, league);

                //Team two
                System.out.print("Team Two: ");
                String teamTwoName = input.nextLine();
                Team teamTwo = findData.findTeam(teamTwoName, league);

                //Date
                System.out.print("Date of Game: ");
                String date = input.nextLine();

                //Add Game to Schedule
                if(teamOne.getTeamName() == null || teamTwo.getTeamName() == null){
                    System.out.println("One or more of the two teams not found. Try again.");
                }else{
                    // Create Game Object and Add Save
                    Game gameToAdd = new Game(teamOne, teamTwo, date);
                    gameToAdd.save();
                    gameToAdd.saveFileReference();

                    //Add Game to Schedule with Queue Nodes
                    QueueNode<Game> gameNode = new QueueNode<Game>(gameToAdd);
                    schedule.enqueue(gameNode);
                    System.out.println("Game added to schedule");
                }
                System.out.println();
            }else if(userChoice == 8){

                //Input Variables
                String goalScorerName = "";
                String assistPlayerName = "";
                boolean playerFound = false;
                int numInputAttempts = 0;
                Player goalScorer;
                Player assistPlayer;

                System.out.println();
                Game gameToRecord = schedule.dequeue();
                System.out.println(gameToRecord.getTeamOne().getTeamName() + " vs " + gameToRecord.getTeamTwo().getTeamName() + " " + gameToRecord.getDate());

                //Team 1
                System.out.println(gameToRecord.getTeamOne().getTeamName() + " goals: ");
                int teamOneGoals = input.nextInt();
                gameToRecord.setTeamOneGoals(teamOneGoals);
                System.out.println();
                for(int i = 1; i <= teamOneGoals; i++){
                    System.out.println("Goal #" + i);
                    
                    //Find Goal Scoreer Player
                    while(playerFound == false){
                        System.out.print("Goals Scorer: ");
                        if(numInputAttempts == 0 && i == 1){
                            input.nextLine();
                        }
                        goalScorerName = input.nextLine();
                        playerFound = ((gameToRecord.getTeamOne()).getPlayerList()).containsNodeName(goalScorerName, gameToRecord.getTeamOne().getPlayerList().getRoot());
                        if(playerFound == false){
                            System.out.println("Player Not Found. Try Again");
                        }
                        numInputAttempts++;
                    }
                    goalScorer = loadData.loadIndividualPlayer(goalScorerName);
                    goalScorer.setGoals(goalScorer.getGoals() + 1);
                    goalScorer.setPoints(goalScorer.getPoints());
                    goalScorer.save();

                    playerFound = false;
                    numInputAttempts = 0;
                    goalScorerName = "";

                    //Assists
                    System.out.println("Number of Players With Assists: ");
                    int numAssists = input.nextInt();
                    for(int k = 1; k <= numAssists; k++){
                        while(playerFound == false){
                            System.out.print("Assist Player #" + k + ": ");
                            if(numInputAttempts == 0 && k==1){
                                input.nextLine();
                            }
                            assistPlayerName = input.nextLine();
                            playerFound = ((gameToRecord.getTeamOne()).getPlayerList()).containsNodeName(assistPlayerName, gameToRecord.getTeamOne().getPlayerList().getRoot());
                            if(playerFound == false){
                                System.out.println("Player Not Found. Try Again");
                            }
                            numInputAttempts++;
                        }
                        assistPlayer = loadData.loadIndividualPlayer(assistPlayerName);
                        assistPlayer.setAssists(assistPlayer.getAssists() + 1);
                        assistPlayer.setPoints(assistPlayer.getPoints());
                        assistPlayer.save();

                        playerFound = false;
                        numInputAttempts = 0;
                        assistPlayerName = "";

                        System.out.println();
                    }
                }

                //Reset Variables for Team 2
                goalScorerName = "";
                assistPlayerName = "";
                playerFound = false;
                numInputAttempts = 0;

                //Team 2
                System.out.print(gameToRecord.getTeamTwo().getTeamName() + " goals: ");
                int teamTwoGoals = input.nextInt();
                gameToRecord.setTeamTwoGoals(teamTwoGoals);
                for(int i = 1; i <= teamTwoGoals; i++){
                    System.out.println("Goal #" + i);
                    
                    //Find Goal Scoreer Player
                    while(playerFound == false){
                        System.out.print("Goals Scorer: ");
                        if(numInputAttempts == 0 && i == 1){
                            input.nextLine();
                        }
                        goalScorerName = input.nextLine();
                        playerFound = ((gameToRecord.getTeamTwo()).getPlayerList()).containsNodeName(goalScorerName, gameToRecord.getTeamTwo().getPlayerList().getRoot());
                        if(playerFound == false){
                            System.out.println("Player Not Found. Try Again");
                        }
                        numInputAttempts++;
                    }
                    goalScorer = loadData.loadIndividualPlayer(goalScorerName);
                    goalScorer.setGoals(goalScorer.getGoals() + 1);
                    goalScorer.setPoints(goalScorer.getPoints());
                    goalScorer.save();

                    playerFound = false;
                    numInputAttempts = 0;
                    goalScorerName = "";

                    //Assists
                    System.out.println("Number of Players With Assists: ");
                    int numAssists = input.nextInt();
                    for(int k = 1; k <= numAssists; k++){
                        while(playerFound == false){
                            System.out.print("Assist Player #" + k + ": ");
                            if(numInputAttempts == 0 && k==1){
                                input.nextLine();
                            }
                            assistPlayerName = input.nextLine();
                            playerFound = ((gameToRecord.getTeamTwo()).getPlayerList()).containsNodeName(assistPlayerName, gameToRecord.getTeamTwo().getPlayerList().getRoot());
                            if(playerFound == false){
                                System.out.println("Player Not Found. Try Again");
                            }
                            numInputAttempts++;
                        }
                        assistPlayer = loadData.loadIndividualPlayer(assistPlayerName);
                        assistPlayer.setAssists(assistPlayer.getAssists() + 1);
                        assistPlayer.setPoints(assistPlayer.getPoints());
                        assistPlayer.save();

                        playerFound = false;
                        numInputAttempts = 0;
                        assistPlayerName = "";

                        System.out.println();
                    }
                    
                }

                //Update Game Object with Data, Delete old Game File
                gameToRecord.setTeamOneGoals(teamOneGoals);
                gameToRecord.setTeamTwoGoals(teamTwoGoals);
                gameToRecord.saveResult();
                gameToRecord.delete();
                String gameToDelete = gameToRecord.getTeamOne().getTeamName() + gameToRecord.getTeamTwo().getTeamName() + gameToRecord.getDate();
                gameToRecord.saveUpdatedSchedule(gameToDelete); 
                System.out.println("Game inofrmation successfully recorded and saved.");
                System.out.println();

            }else if(userChoice == 9){
                System.out.println();
                System.out.println("There are " + schedule.size() + " games scheduled");
                System.out.println();
                loadData.loadSchedule(league, true);
                System.out.println();
            }else if(userChoice == 10){

            }else if(userChoice == 11){
                coninueProgram = false;
            }
        }
        input.close();
    }
    
}
