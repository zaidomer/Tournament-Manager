/**
 * Auto Generated Java Class.
 */
import java.io.*;
import java.util.Scanner;

class Game {
    private Team teamOne;
    private Team teamTwo;
    private String date;
    private boolean completed;
    private int teamOneGoals;
    private int teamTwoGoals;

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
        printOut.println(teamOne.getTeamName() + " " + teamTwo.getTeamName() + " " + date + "\r");
        printOut.close();
    }

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

    public void delete()throws Exception{
        File fileToDelete = new File("GameData/" + teamOne.getTeamName().replaceAll(" ", "") + teamTwo.getTeamName().replaceAll(" ", "") + date.replaceAll(" ", "") + ".txt");
        fileToDelete.delete();
    }

    public void saveUpdatedSchedule(String gameToDelete)throws Exception{
        //Setup input file
        File inFile = new File("AllGames.txt");
        Scanner input = new Scanner(inFile);
        String newFileContents = "";
        String line;
        while(input.hasNext()){
            line = input.nextLine();
            if(!input.nextLine().equals(gameToDelete)){
                newFileContents += input.nextLine();
            }
        }
        input.close();
        inFile.delete();
        File outputFile = new File("AllGames.txt");
        PrintWriter printOut = new PrintWriter(outputFile);
        printOut.println(newFileContents);
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

    public int getTeamOneGoals(){
        return teamOneGoals;
    }

    public int getTeamTwoGoals(){
        return teamTwoGoals;
    }

    //Setters
    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public void setTeamOneGoals(int teamOneGoals){
        this.teamOneGoals = teamOneGoals;
    }

    public void setTeamTwoGoals(int teamTwoGoals){
        this.teamTwoGoals = teamTwoGoals;
    }
}
