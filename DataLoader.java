import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Project - TournamentManager
 * DataLoader.java
 * Object with methods to load data from txt files
 * @author Zaid Omer
 * @version May 12, 2019
 */
class DataLoader{

    /**
     * loads all the teams from tect files to an ArrayList
     * @return league , the ArrayList<Team> of all teams
     * @throws Exception
     */
    public ArrayList<Team> loadTeams()throws Exception{
        ArrayList<Team> league = new ArrayList<Team>();
        String teamName = "";
        File file = new java.io.File("AllTeams.txt"); 
        Scanner input = new Scanner(file);
        while(input.hasNextLine()){
            teamName = input.nextLine();
            league.add(new Team(teamName));
        }
        input.close();
        return league;
    }

    /**
     * loads all players from text files
     * @return playerList , an ArrayList<Player> of players
     * @throws Exception
     */
    public ArrayList<Player> loadPlayers()throws Exception{
        File file = new java.io.File("AllPlayers.txt");
        Scanner input = new Scanner(file);  
        String name;
        ArrayList<Player> playerList = new ArrayList<Player>();
        while(input.hasNextLine()){
            name = input.nextLine();
            if(name.length()>1){
                Player playerToAdd = loadIndividualPlayer(name);
                playerList.add(playerToAdd);
            }
        }
        input.close();
        return playerList;
    }

    /**
     * load the data of 1 player from their respective text file
     * @param name , the name of the player of type String
     * @return Player object of the player requested to load into the game
     * @throws Exception
     */
    public Player loadIndividualPlayer(String name)throws Exception{
        int count = 0;
        String playerName = "";
        String team = "";
        int goals = 0;
        int assists = 0;

        File playerFile = new java.io.File("PlayerData/" + name.replaceAll(" ", "") +".txt");
        Scanner readPlayer = new Scanner(playerFile);
        while(readPlayer.hasNextLine()){
            if(count == 0){
                playerName = readPlayer.nextLine();
            }else if(count == 1){
                team = readPlayer.nextLine();
            }else if(count == 2){
                goals = Integer.parseInt(readPlayer.nextLine());
            }else if(count == 3){
                assists = Integer.parseInt(readPlayer.nextLine());
            }else if(count == 4){
                //player points
                Integer.parseInt(readPlayer.nextLine());
            }
            count++;
        }
        readPlayer.close();
        return new Player(playerName, goals, assists, team);
    }


    /**
     * load in all the games upcoming in the schedule
     * @param league , an ArrayList<Team> of all teams in the league
     * @param display , a boolean variable saying if the user wants to display all the games (true) or not (false)
     * @return schedule , a Queue<Game> with all the upcoming games
     * @throws Exception
     */
    public Queue<Game> loadSchedule(ArrayList<Team> league, boolean display)throws Exception{
        File file = new java.io.File("AllGames.txt"); 
        Scanner input = new Scanner(file);  
        String name;
        Queue<Game> schedule = new Queue<Game>();
        while(input.hasNextLine()){
            name = input.nextLine();
            if(name.length() > 1){
                Game gameToAdd = loadIndividualGame(name, league, display);
                QueueNode<Game> gameNode = new QueueNode<Game>(gameToAdd);
                schedule.enqueue(gameNode);
            }
        }
        input.close();
        return schedule;
    }

    /**
     * Loads all the data for 1 game
     * @param gameName the title of the game (i.e. team one vs team two)
     * @param league , an ArrayList<Team> of all teams in the league
     * @param display , a boolean variable saying if the user wants to display all the games (true) or not (false)
     * @return Game , a game object with the teams playing and the date of the game
     * @throws Exception
     */
    public Game loadIndividualGame(String gameName, ArrayList<Team> league, boolean display)throws Exception{
        int count = 0;
        String teamOneName = "";
        String teamTwoName = "";
        String date = "";
        Team teamOne = new Team("");
        Team teamTwo = new Team("");
        DataFinder findData = new DataFinder();

        File gameFile = new java.io.File("GameData/" + gameName.replaceAll(" ", "") +".txt");
        Scanner readGame = new Scanner(gameFile);
        while(readGame.hasNextLine()){
            if(count == 0){
                teamOneName = readGame.nextLine();
                teamOne = findData.findTeam(teamOneName, league);
            }else if(count == 1){
                teamTwoName = readGame.nextLine();
                teamTwo = findData.findTeam(teamTwoName, league);
            }else if(count == 2){
                date = readGame.nextLine();
            }
            count++;
        }
        if(display == true){
            System.out.println(teamOne.getTeamName() + " vs " + teamTwo.getTeamName() + " " + date);
        }
        readGame.close();
        return new Game(teamOne, teamTwo, date);
    }

    /**
     * loads in every game on the schedule, from the all games text file
     * @throws Exception
     */
    public void loadCompletedGames()throws Exception{
        File completedGamesFile = new File("AllCompletedGames.txt");
        Scanner input = new Scanner(completedGamesFile);
        String game = "";
        System.out.println();
        while(input.hasNextLine()){
            game = input.nextLine();
            System.out.println(game);
        }
        System.out.println();
        input.close();
    }
}
