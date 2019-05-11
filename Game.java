/**
 * Auto Generated Java Class.
 */
import java.io.*;

class Game {
    private Team teamOne;
    private Team teamTwo;
    private String date;
    private boolean completed;

    public Game(Team teamOne, Team teamTwo, String date){
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.date = date;
    }

    public void save()throws Exception{
        File outputFile = new File("GameData/" + teamOne.getTeamName().replaceAll(" ", "") + teamTwo.getTeamName().replaceAll(" ", "") + date.replaceAll(" ", "") + ".txt");
        PrintWriter printOut = new PrintWriter(outputFile);
        printOut.println(teamOne.getTeamName());
        printOut.println(teamTwo.getTeamName());
        printOut.println(date);
        printOut.close();
    }

    public void saveFileReference()throws Exception{
        File outputFile = new File("AllGames.txt");
        PrintWriter printOut = new PrintWriter(new FileWriter(outputFile, true));
        printOut.println(teamOne.getTeamName() + " " + teamTwo.getTeamName() + " " + date);
        printOut.close();
    }

    //Getters
    public Team getTeamOne(){
        return teamOne;
    }
    
    public Team getTeamTwo(){
        return teamTwo;
    }

    public String getDate(){
        return date;
    }

    public boolean getCompleted(){
        return completed;
    }

    //Setters
    public void setCompleted(boolean completed){
        this.completed = completed;
    }
}
