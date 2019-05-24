import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;

/**
 * Project - TournamentManager
 * Team.java
 * A team object, has a team name and stores players
 * @author Zaid Omer
 * @version May 12, 2019
 */
class Team{
    private String teamName;
    private BinaryTree<Integer> playerList;

    /**
     * Team constructor
     * @param teamName, String variable for the team name
     */
    Team(String teamName){
        this.teamName = teamName;
        playerList = new BinaryTree<Integer>();
    }

    // Getters

    /**
     * Team name getter
     * @return teamName, String variable for team name
     */
    public String getTeamName(){
        return teamName;
    }

    /**
     * Player List getter
     * @return playerList, BinaryTree variable sorting players based on points
     */
    public BinaryTree<Integer> getPlayerList(){
        return playerList;
    }

    // Setters

    /**
     * team name setter
     * @param teamName, String type, set the team name
     */
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    /**
     * player lise setter
     * @param playerList, BinaryTree type, the new binary tree to update to
     */
    public void setPlayerList(BinaryTree<Integer> playerList){
        this.playerList = playerList;
    }

    /**
     * Save team method, creates a file for the team
     * @throws Exception
     */
    public void save()throws Exception{
        File outputFile = new File("TeamData/" + teamName.replaceAll(" ", "") + ".txt");
        PrintWriter printOut = new PrintWriter(outputFile);
        printOut.println(teamName);
        printOut.close();
    }

    /**
     * Save file reference method, saves the name of the team to the file containing the list of all of them
     * @throws Exception
     */
    public void saveFileReference()throws Exception{
        File outputFile = new File("AllTeams.txt");
        PrintWriter printOut = new PrintWriter(new FileWriter(outputFile, true));
        printOut.println(teamName);
        printOut.close();
    }

}
