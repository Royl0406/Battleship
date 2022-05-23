import java.util.Scanner;
import java.util.ArrayList;
public class Player {
    
    
    private String username;
    private int team;
    private Board statusBoard;
    private int shotNum;
    private int hitNum;
    private ArrayList<Ship> shipList;


    
    public Player() {
        
    }
    
    public Player(int team){

        
        this.team = team;
        shotNum = 0;
        hitNum = 0;
        statusBoard = new Board(team);
        shipList = new ArrayList<Ship>();
        

        
 
    }

    public boolean setUsername (){

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        if (input.length() > 25){

            System.out.println("Sorry. Your username is too long. Usernames must be 25 characters or less.");
            return false;
        }

        username = input;
        return true;

    }
    
    public void setShipLocations(){
        GameSetup setup = new GameSetup();
        System.out.println(username + ", please enter your properly formatted ship locations.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] shipStrings = setup.extractIndividualShip(input);

        boolean formatted = false;

        while(!formatted){

            for(int i = 0; i < shipStrings.length; i++) { 
                String code = setup.setLocation(shipStrings[i], team);
                if (!code.equals("comp_code_VALID")){
                    System.out.println(code);
                    formatted = false;
                    input = sc.nextLine();
                    shipStrings = setup.extractIndividualShip(input);
                    break;
                 }
                 else{
                     formatted = true;
                 }
               }

        }

        statusBoard.setBoard(setup.getLocations());
        shipList = setup.getShipList();


        
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

    public void addHit(int input){
        hitNum += input;
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


