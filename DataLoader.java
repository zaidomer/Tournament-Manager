import java.io.*;
import java.util.Scanner;

class DataLoader{
    
    public void loadTeams(){
        
    }
    
    public void loadPlayers()throws Exception{
        File file = new java.io.File("AllPlayers.txt"); 
        Scanner input = new Scanner(file);  
        
        while (input.hasNext()) {
            String playerName = input.nextLine();
            playerName.replaceAll(" ", "");
        }
        input.close();
    }
}
            