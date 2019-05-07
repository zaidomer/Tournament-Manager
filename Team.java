import java.io.*;

class Team{
    private String teamName;
    private BinaryTree<Integer> playerList;

    Team(String teamName){
        this.teamName = teamName;
        playerList = new BinaryTree<Integer>();
    }

    // Getters
    public String getTeamName(){
        return teamName;
    }

    public BinaryTree<Integer> getPlayerList(){
        return playerList;
    }

    // Setters
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public void setPlayerList(BinaryTree<Integer> playerList){
        this.playerList = playerList;
    }
    
     //Save Team
    public void save()throws Exception{
        File outputFile = new File("TeamData/" + teamName.replaceAll(" ", "") + ".xml");
        PrintWriter printOut = new PrintWriter(outputFile);
        printOut.println("<team>");
        printOut.println("<name>" + teamName + "</name>");
        printOut.println("</team>");
        printOut.close();
    }
    
    public void saveFileReference()throws Exception{
        File outputFile = new File("AllTeams.txt");
        PrintWriter printOut = new PrintWriter(new FileWriter(outputFile, true));
        printOut.println(teamName);
        printOut.close();
    }

}
