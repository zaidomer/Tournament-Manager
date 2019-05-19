import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
/**
 * Project - TournamentManager
 * Player.java
 * Player object file, stores player name, goals, assists, points
 * @author Zaid Omer
 * @version May 12, 2019
 */
class Player{
    
    // Declare Variables
    private int points;
    private int goals = 0;
    private int assists = 0;
    private String name;
    private String team;

    /**
     * Player constructor
     * @param name, String player name
     * @param goals, int number of goals for player
     * @param assists, int number of assists for player
     * @param team, String the team name the player is on
     */
    public Player(String name, int goals, int assists, String team){
        this.name = name;
        this.goals = goals;
        this.assists = assists;
        this.team = team;
        points = goals + assists;
    }

    /**
     * goals getter
     * @return goals, int number of goals player has
     */
    public int getGoals(){
        return goals;
    }

    /**
     * Assists getter
     * @return assists, int number of assists
     */
    public int getAssists(){
        return assists;
    }

    /**
     * Points getter
     * @return points, int number of points player has
     */
    public int getPoints(){
        points = goals + assists;
        return points;
    }

    /**
     * Player name getter
     * @return name, String player name
     */
    public String getName(){
        return name;
    }

    /**
     * Team name getter
     * @return team, String for team name
     */
    public String getTeam(){
        return team;
    }

    /**
     * goals setter
     * @param goals, int new goals value
     */
    public void setGoals(int goals){
        this.goals = goals;
    }

    /**
     * Assists setter
     * @param assists, int new assists value
     */
    public void setAssists(int assists){
        this.assists = assists;
    }

    /**
     * Points setter
     * @param points, int new points value
     */
    public void setPoints(int points){
        this.points = points;
    }

    /**
     * Player name setter
     * @param name, String new player name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Saves all player info to their own file
     * @throws Exception
     */
    public void save()throws Exception{
        File outputFile = new File("PlayerData/" + name.replaceAll(" ", "") + ".txt");
        PrintWriter printOut = new PrintWriter(outputFile);
        printOut.println(name);
        printOut.println(team);
        printOut.println(goals);
        printOut.println(assists);
        printOut.println(points);
        printOut.close();
    }

    /**
     * saves player name to the all players reference file
     * @throws Exception
     */
    public void saveFileReference()throws Exception{
        File outputFile = new File("AllPlayers.txt");
        PrintWriter printOut = new PrintWriter(new FileWriter(outputFile, true));
        printOut.println(name);
        printOut.close();
    }

    /**
     * delete the player file
     * @throws Exception
     */
    public void delete()throws Exception{
        File fileToDelete = new File("PlayerData/" + name.replaceAll(" ", "") + ".txt");
        fileToDelete.delete();
    }

    /**
     * delete the reference to the player in the all players file
     * @param playerToDelete, String player to delete's name
     * @throws Exception
     */
    public void deleteFileReference(String playerToDelete)throws Exception{
        //Setup input file
        File inFile = new File("AllPlayers.txt");
        Scanner input = new Scanner(inFile);
        String newFileContents = "";
        String line;
        while(input.hasNext()){
            line = input.nextLine();
            if(!line.equals(playerToDelete)){
                newFileContents += line;
                newFileContents = newFileContents + "\n";
            }
        }

        //delete old file and replace with new one (without the deleted game)
        input.close();
        inFile.delete();
        File outputFile = new File("AllPlayers.txt");
        PrintWriter printOut = new PrintWriter(outputFile);
        printOut.println(newFileContents);
        printOut.close();
    }
    
}