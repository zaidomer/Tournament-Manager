import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Project - TournamentManager
 * Game.java
 * A File to make the game object, with teams involved, date, and score
 * @author Zaid Omer
 * @version May 12, 2019
 */
class Game {
    private Team teamOne;
    private Team teamTwo;
    private String date;
    private boolean completed;
    private int teamOneGoals;
    private int teamTwoGoals;

    /**
     * Game constructor
     * @param teamOne the first team in a match
     * @param teamTwo the second team in a match
     * @param date the date of the game
     */
    public Game(Team teamOne, Team teamTwo, String date){
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.date = date;
    }

    /**
     * Saves the information of 1 game to its own txt file
     * @throws Exception
     */
    public void save()throws Exception{
        File outputFile = new File("GameData/" + teamOne.getTeamName().replaceAll(" ", "") + teamTwo.getTeamName().replaceAll(" ", "") + date.replaceAll(" ", "") + ".txt");
        PrintWriter printOut = new PrintWriter(outputFile);
        printOut.println(teamOne.getTeamName());
        printOut.println(teamTwo.getTeamName());
        printOut.println(date);
        printOut.close();
    }

    /**
     * saves the game to the text file with all the games referenced
     * @throws Exception
     */
    public void saveFileReference()throws Exception{
        File outputFile = new File("AllGames.txt");
        PrintWriter printOut = new PrintWriter(new FileWriter(outputFile, true));
        printOut.println(teamOne.getTeamName() + " " + teamTwo.getTeamName() + " " + date + "\r");
        printOut.close();
    }

    /**
     * saves the result of a game (the final score) to its own txt file
     * @throws Exception
     */
    public void saveResult()throws Exception{
        File outputFile = new File("CompletedGames/" + teamOne.getTeamName().replaceAll(" ", "") + teamTwo.getTeamName().replaceAll(" ", "") + date.replaceAll(" ", "") + ".txt");
        PrintWriter printOut = new PrintWriter(outputFile);
        printOut.println(teamOne.getTeamName());
        printOut.println(teamTwo.getTeamName());
        printOut.println(date);
        printOut.println(teamOneGoals);
        printOut.println(teamTwoGoals);
        printOut.close();
    }

    /**
     * deletes a game file, once it has been completed
     * @throws Exception
     */
    public void delete()throws Exception{
        File fileToDelete = new File("GameData/" + teamOne.getTeamName().replaceAll(" ", "") + teamTwo.getTeamName().replaceAll(" ", "") + date.replaceAll(" ", "") + ".txt");
        fileToDelete.delete();
    }

    /**
     * updates the txt file referencing all the pending games, and removing the game(s) that have completed
     * @param gameToDelete
     * @throws Exception
     */
    public void saveUpdatedSchedule(String gameToDelete)throws Exception{
        //Setup input file
        File inFile = new File("AllGames.txt");
        Scanner input = new Scanner(inFile);
        String newFileContents = "";
        String line;
        while(input.hasNext()){
            line = input.nextLine();
            if(!line.equals(gameToDelete)){
                newFileContents += line;
                newFileContents = newFileContents + "\n";
            }
        }

        //delete old file and replace with new onw (without the deleted game)
        input.close();
        inFile.delete();
        File outputFile = new File("AllGames.txt");
        PrintWriter printOut = new PrintWriter(outputFile);
        printOut.println(newFileContents);
        printOut.close();

        //Save as completed game
        File completedFiles = new File("AllCompletedGames.txt");
        PrintWriter printCompleted = new PrintWriter(new FileWriter(completedFiles, true));
        printCompleted.println(teamOne.getTeamName() + " vs " + teamTwo.getTeamName() + " " + date + " (" + teamOneGoals + "-" + teamTwoGoals + ")");
        printCompleted.close();
    }

    /**
     * team one getter
     * @return teamOne , of type Team
     */
    public Team getTeamOne(){
        return teamOne;
    }

    /**
     * team two getter
     * @return teamTwo, of type Team
     */
    public Team getTeamTwo(){
        return teamTwo;
    }

    /**
     * date getter
     * @return date, of type String
     */
    public String getDate(){
        return date;
    }

    /**
     * game completed getter
     * @return completed, a boolean saying if the game has been completed(true) or not (false)
     */
    public boolean getCompleted(){
        return completed;
    }

    /**
     * team one goals getter
     * @return teamOneGoals, number of goals team one scored of type int
     */
    public int getTeamOneGoals(){
        return teamOneGoals;
    }

    /**
     * team two goals getter
     * @return teamTwoGoals, number of goals team two scored of type int
     */
    public int getTeamTwoGoals(){
        return teamTwoGoals;
    }

    /**
     * completed setter
     * @param completed , the new boolean value of completed
     */
    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    /**
     * team one goals setter
     * @param teamOneGoals , the int for the updated goals for team one
     */
    public void setTeamOneGoals(int teamOneGoals){
        this.teamOneGoals = teamOneGoals;
    }

    /**
     * team two goals setter
     * @param teamTwoGoals the int for the updated goals for team two
     */
    public void setTeamTwoGoals(int teamTwoGoals){
        this.teamTwoGoals = teamTwoGoals;
    }
}
