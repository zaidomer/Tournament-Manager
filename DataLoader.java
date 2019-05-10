import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class DataLoader{
    
    public ArrayList<Team> loadTeams()throws Exception{
        ArrayList<Team> league = new ArrayList<Team>();
        String teamName = "";
        File file = new java.io.File("AllTeams.txt"); 
        Scanner input = new Scanner(file);
        while(input.hasNextLine()){
            teamName = input.nextLine();
            league.add(new Team(teamName));
        }
        return league;
    }
    
    public ArrayList<Player> loadPlayers()throws Exception{
        File file = new java.io.File("AllPlayers.txt"); 
        Scanner input = new Scanner(file);  
        String name;
        ArrayList<Player> playerList = new ArrayList<Player>();
        while(input.hasNextLine()){
            name = input.nextLine();
            Player playerToAdd = loadIndividualPlayer(name);
            playerList.add(playerToAdd);
        }
        input.close();
        return playerList;
    }

    public Player loadIndividualPlayer(String name)throws Exception{
        int count = 0;
        String playerName = "";
        String team = "";
        int goals = 0;
        int assists = 0;
        int points = 0;

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
                points = Integer.parseInt(readPlayer.nextLine());
            }
            count++;
        }
        readPlayer.close();
        return new Player(playerName, goals, assists, team);

    }
}
