import java.util.ArrayList;

//This class helps each player place their ships onto their board. It stores the locations into a char array,
//which is then accessed in the Player class and stored in each player's Board object




public class GameSetup {
    
    private char[][] locations;
    private ArrayList<Ship> shipList;


    public GameSetup(){

        locations = new char[10][10];
        shipList = new ArrayList<Ship>();

        
        
    }

    
    //The below method parses a properly formatted String into multiple small Strings that contain information about 
    //a specific ship's location. These Strings are stored in an array, which is returned.
    
    public String[] extractIndividualShip(String input) {
        String[] ships = new String[5];
        for(int i = 0; i < 5; i++) {
            ships[i] = input.substring(0, 5);
        
            if(input.length() > 5) {
                input = input.substring(6);
                input = input.trim();
            }
        }
        return ships;
    }



    //The below method takes in a String that represents a specific ship's location, and sets that ship's location on the
    //char array. If the String isn't properly formatted, it wipes the char array and returns an error message.

    public String setLocation(String input, int team){
        
        String errorMessage = "";

        int row;
        int col;
        int size;
        char typeChar;
        int typeInt;

    
        
        
        String type = input.substring(0,1);
        
        String rowStr = input.substring(2,3);
        
        String colStr = input.substring(3,4);
        
        String orient = input.substring(4);
        String fullType;

        

        if (input.length() != 5){
            return "Sorry. Your input was not formatted correctly. Please check it to make sure that you have not included any stray characters, as the game will not be able to read your ships in.";
        }
        
        switch (rowStr){
            case "A": row = 0; break;
            case "B": row = 1; break;
            case "C": row = 2; break;
            case "D": row = 3; break;
            case "E": row = 4; break;
            case "F": row = 5; break;
            case "G": row = 6; break;
            case "H": row = 7; break;
            case "I": row = 8; break;
            case "J": row = 9; break;
            default: row = 10;
        }

        switch (type){
            
            case "A": size = 5; typeChar = 'a'; fullType = "Aircraft Carrier"; typeInt = 0; break;
            case "B": size = 5; typeChar = 'b'; fullType = "Battleship"; typeInt = 1; break;
            case "D": size = 3; typeChar = 'd'; fullType = "Destroyer"; typeInt = 2; break;
            case "S": size = 3; typeChar = 's'; fullType = "Submarine"; typeInt = 3; break;
            default: size = 2; typeChar = 'p'; fullType = "Patrol Boat"; typeInt = 4;


        }

        col = Integer.parseInt(colStr);
    

        int rowEnd = row;
        int colEnd = col;
        int rowStart = 0;
        int colStart = 0;

        if (orient.equals("h")){

            colEnd = col + size;
            rowEnd ++;
            rowStart = row;
            colStart = col;
            

        }

        


        else if(orient.equals("v")){
            rowEnd = row + size;
            colEnd++;
            colStart = col;
            rowStart = row;

            
        }

        else{
            return "Sorry. There was a problem accessing your " + fullType + " orientation. Please ensure that you have specified 'h' for horizontal orientation, or 'v' for vertical orientation.";
        }

    
//there are problems with rowStart and rowEnd, need to be fixed.


        for (int r = rowStart; r<rowEnd; r++){
            for (int c = colStart; c<colEnd; c++){
                
            
                    try{
                    
                        if (locations[r][c] == '0'){
                            locations[r][c] = typeChar;
                            errorMessage = "comp_code_VALID";
                            Ship s = new Ship(row, col, size, typeInt, orient, team);
                            shipList.add(s);

                        }
                        else{
                            errorMessage = "Sorry. Your " + fullType + " is overlapping with another ship. Please try again.";

                           
                        }

                    } catch (Exception ArrayIndexOutOfBoundsException){

                    
                        errorMessage = "Sorry. Your " + fullType + " position is not valid. Remember, ships must be within the 10 by 10 game square. Please try again.";

                    }

                
                }
                
            }
        

            
            if (!errorMessage.equals("comp_code_VALID")){
                for(int r = 0; r<10; r++){
                    for(int c = 0; c<10; c++){
                        locations[r][c] = '0';
                    }
                }

                
            }
            
            return errorMessage;

    }
    
    //The below method returns the char array containing the ship locations

    public char[][] getLocations(){

        return locations;

    }

    public ArrayList<Ship> getShipList(){
        return shipList;
    }
}

