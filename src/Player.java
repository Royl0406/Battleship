public class Player {
    
    
    private String username;
    private int team;
    private Board statusBoard;
    private int shotNum;
    private int hitNum;


    
    public Player() {
        
    }
    
    public Player(int team){

        
        this.team = team;
        shotNum = 0;
        hitNum = 0;

        
 
    }

    public String setUsername (String input){

        if (input.length() > 25){

            return("Sorry. Your username is too long. Usernames must be less than 25 characters.");
        }

        username = input;
        return ("comp_code_VALID");

    }

    public String getName(){
        return username;
    }

    public String getTeam(){
        if (team == 0){
            return "Imperials";
        }
        return "Rebels";
    }

    public void addHit(){
        hitNum++;
    }

    public void addShot(){
        shotNum++;
    }

    public int getHits(){
        return hitNum;
    }

    public int getShots(){
        return shotNum;
    }

    public Board getBoard(){
        return statusBoard;
    }
}   


