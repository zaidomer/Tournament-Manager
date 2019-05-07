/**
 * Auto Generated Java Class.
 */
import java.io.*;

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
    
    // Setters
    public void setGoals(int goals){
        this.goals = goals;
    }
    
    public void setAssists(int assists){
        this.assists = assists;
    }

    public void setName(String name){
        this.name = name;
    }

    //Save Player
    public void save()throws Exception{
        File outputFile = new File("PlayerData/" + name.replaceAll(" ", "") + ".xml");
        PrintWriter printOut = new PrintWriter(outputFile);
        printOut.println("<player>");
        printOut.println("<name>" + name + "</name>");
        printOut.println("<team>" + team + "</team>");
        printOut.println("<goals>" + goals + "</goals>");
        printOut.println("<assists>" + assists + "</assists>");
        printOut.println("<points>" + points + "</points>");
        printOut.println("</player>");
        printOut.close();
    }
    
    public void saveFileReference()throws Exception{
        File outputFile = new File("AllPlayers.txt");
        PrintWriter printOut = new PrintWriter(new FileWriter(outputFile, true));
        printOut.println(name);
        printOut.close();
    }
    
}