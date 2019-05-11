import java.util.ArrayList;

class DataFinder{

    public Team findTeam(String teamName, ArrayList<Team> league){
        for(int i = 0; i < league.size(); i++){
            if(((league.get(i)).getTeamName()).equals(teamName)){
                return league.get(i);
            }
        }
        return new Team(null);
    }
}