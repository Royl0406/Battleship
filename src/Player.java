import java.util.Scanner;
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


    public void setShipLocations(){
        GameSetup setup = new GameSetup();
        System.out.println("Please enter your properly formatted ship locations.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] shipStrings = setup.extractIndividualShip(input);

        boolean formatted = false;

        while(!formatted){

            for(int i = 0; i < shipStrings.length; i++) {  
                if (!setup.setLocation(shipStrings[i]).equals("comp_code_VALID")){
                    System.out.println(setup.setLocation(shipStrings[i]));
                    formatted = false;
                    break;
                 }
                 else{
                     formatted = true;
                 }
               }

        }

        statusBoard.setBoard(setup.getLocations());

        
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


