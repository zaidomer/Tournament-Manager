import java.util.ArrayList;

/**
 * Project - TournamentManager
 * DataFinder.java
 * An object with methods to find data
 * @author Zaid Omer
 * @version May 12, 2019
 */
class DataFinder{

    /**
     * Finds the team object, when the team name is given
     * @param teamName String, the name of the team to find
     * @param league ArrayList<Team> the array list of all the teams in the league
     * @return
     */
    public Team findTeam(String teamName, ArrayList<Team> league){
        for(int i = 0; i < league.size(); i++){
            if(((league.get(i)).getTeamName()).equals(teamName)){
                return league.get(i);
            }
        }
        return new Team(null);
    }
}