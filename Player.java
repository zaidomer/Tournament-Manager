/**
 * Auto Generated Java Class.
 */
import java.io.*;
import java.util.Scanner;

class Player{
    
    // Declare Variables
    private int points;
    private int goals = 0;
    private int assists = 0;
    private String name;
    private String team;
    
    public Player(String name, int goals, int assists, String team){
        this.name = name;
        this.goals = goals;
        this.assists = assists;
        this.team = team;
        points = goals + assists;
    }
    
    // Getters
    public int getGoals(){
        return goals;
    }
    
    public int getAssists(){
        return assists;
    }
    
    public int getPoints(){
        points = goals + assists;
        return points;
    }

    public String getName(){
        return name;
    }
    
    public String getTeam(){
        return team;
    }
    
    // Setters
    public void setGoals(int goals){
        this.goals = goals;
    }
    
    public void setAssists(int assists){
        this.assists = assists;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public void setName(String name){
        this.name = name;
    }

    //Save and Delete Player
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
    
    public void saveFileReference()throws Exception{
        File outputFile = new File("AllPlayers.txt");
        PrintWriter printOut = new PrintWriter(new FileWriter(outputFile, true));
        printOut.println(name);
        printOut.close();
    }
    
    public void delete()throws Exception{
        File fileToDelete = new File("PlayerData/" + name.replaceAll(" ", "") + ".txt");
        fileToDelete.delete();
    }
    
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