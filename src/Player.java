//This class contains information for a specific player. It stores an ArrayList of the player's ships,
//a Board object for the player, the player's username, and it counts shots and hits for each player

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

    //Sets username based on user input

    public boolean setUsername (){

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        if (input.length() > 25){

            System.out.println("Sorry. Your username is too long. Usernames must be 25 characters or less.");
            return false;
        }

        username = input;

        //Special surprise for anyone who inputs "Hemiup" as their username. Try entering the cheat code when targeting ships!
        if(username.equals("Hemiup")){
            System.out.println("The cheat code is 'DhruvAndRoyRock'. Enter it when prompted for a target. Press enter to continue.");
        }
        return true;

    }

    //Takes in an input and utilises the extractIndividualShip method and setLocation method from the GameSetup class
    //to input ships onto the player's board
    
    public void setShipLocations(){
        GameSetup setup = new GameSetup();
        System.out.println(username + ", please enter your properly formatted ship locations.");
        
        boolean formatted = false;

        Scanner sc = new Scanner(System.in);

        String input = "";
        
        while(!formatted){
            input = sc.nextLine();
            if(input.length() == 29){
                formatted = true;
            }

            else{
                System.out.println("Sorry. Your input was incorrectly formatted. Please try again.");
            }

            
        }
        
        
        String[] shipStrings = setup.extractIndividualShip(input);

        formatted = false;

        while(!formatted){
            if(shipStrings.length == 5){
                formatted = true;
            }

            else{
                System.out.println("Sorry. Your input was formatted incorrectly. Please try again.");
                input = sc.nextLine();
                
                shipStrings = setup.extractIndividualShip(input);
            }
        }

        

        formatted = false;

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

    public void updateShips(String input){
        int r = 0;
        int c = 0;

        c = Integer.parseInt(input.substring(1));

        String rowStr = input.substring(0,1);

        switch(rowStr){

            case "A": r = 0; break;
            case "B": r = 1; break;
            case "C": r = 2; break;
            case "D": r = 3; break;
            case "E": r = 4; break;
            case "F": r = 5; break;
            case "G": r = 6; break;
            case "H": r = 7; break;
            case "I": r = 8; break;
            case "J": r = 9; break;
        }

        char type = statusBoard.getCurType();

        
        int typeInt = 0;

        switch(type){
            case 'a': typeInt = 0; break;
            case 'b': typeInt = 1; break;
            case 'd': typeInt = 2; break;
            case 's': typeInt = 3; break;
            case 'p': typeInt = 4; break;

        }

        Ship current = new Ship();
        
        for(Ship s:shipList){
            if(s.getTypeInt() == typeInt){
                current = s; 
            }
        }
        shipList.remove(shipList.indexOf(current));

        int rowDif = r-current.getRow();

        int colDif = c - current.getCol();

        if(rowDif == 0){
            
            
            current.shipHit(colDif);
        }

        else if(colDif == 0){
            current.shipHit(rowDif);
        }

        shipList.add(current);

        if (current.isSunk()){
            System.out.println("You blew up the enemy " + current.getType() + "!");
        }

    }

    //Basic getters and setters

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

    public ArrayList getShipList(){
        return shipList;
    }
}   


