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

}
