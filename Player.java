/**
 * Auto Generated Java Class.
 */

class Player{
    
    // Declare Variables
    private int points;
    private int goals = 0;
    private int assists = 0;
    private String name;
    
    public Player(String name){
        this.name = name;
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
    
    // Setters
    public void setGoals(int goals){
        this.goals = goals;
    }
    
    public void setAssists(int assists){
        this.assists = assists;
    }
    
}