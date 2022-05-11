public class Player {
    
    
    private String username;
    private int team;
    
    public Player() {
        
    }
    
    public Player(String username, int team){

        this.username = username;
        this.team = team;
 
    }

    public String isValid (String input){

        if (input.length() > 25){

            return("Sorry. Your username is too long. Usernames must be less than 25 characters.");
        }

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
    

}
