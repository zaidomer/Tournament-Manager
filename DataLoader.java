import java.io.*;
import java.util.Scanner;
import org.w3c.dom.Document;
import javax.xml.parsers.*;

class DataLoader{
    
    public void loadTeams(){
        
    }
    
    public Player[] loadPlayers()throws Exception{
        File file = new java.io.File("AllPlayers.txt"); 
        Scanner input = new Scanner(file);  
        Player playerFound = null;
        String name;
        
        int indexLength = 0;
        while(input.hasNextLine()){
            name = input.nextLine();
            indexLength++;
            System.out.println(name);
        }
        Player players[] = new Player[indexLength];
        int count = 0;
        
        while (input.hasNextLine()) {
            String playerName = input.nextLine();
            
            //Code needed to read the XML Files
            File xmlFile = new File("PlayerData/" + playerName.replaceAll(" ", "") +".xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
//            document.getDocumentElement().normalize();
//            document.getDocumentElement().getNodeName();
            String playerTeam = document.getElementsByTagName("team").item(0).getTextContent();
            System.out.println(playerTeam);
            int goals = Integer.parseInt(document.getElementsByTagName("goals").item(0).getTextContent());
            int assists = Integer.parseInt(document.getElementsByTagName("assists").item(0).getTextContent());
            int points = Integer.parseInt(document.getElementsByTagName("points").item(0).getTextContent());
            playerFound = new Player(playerName, goals, assists, playerTeam);
            players[count] = playerFound;
            count++;
            System.out.println(players[count].getName());
        }
        input.close();
        return players;
    }
}
