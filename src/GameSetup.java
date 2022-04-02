import java.util.Scanner;

public class GameSetup {
    
    private char[][] locations;
    private String userInput;
    
    public GameSetup() {

        locations = new char[10][10];
        for (int r = 0; r<10; r++){
            for (int c = 0; c<10; c++){
                locations[r][c] = '0';
                
            }
        }
        
    }
    
    public void getInput() {
        Scanner sc = new Scanner(System.in);
        userInput = sc.nextLine();
        sc.close();
    }

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


    public String setLocation(String input){
        
        String errorMessage = "";

        int row;
        int col;
        int size;
        char typeChar;
        
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
            
            case "A": size = 5; typeChar = 'a'; fullType = "Aircraft Carrier"; break;
            case "B": size = 5; typeChar = 'b'; fullType = "Battleship"; break;
            case "D": size = 3; typeChar = 'd'; fullType = "Destroyer"; break;
            case "S": size = 3; typeChar = 's'; fullType = "Submarine"; break;
            default: size = 2; typeChar = 'p'; fullType = "Patrol Boat";


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
            

        }

        


        else if(orient.equals("v")){
            rowEnd = row + size;
            colEnd++;
            colStart = col;
        }

        else{
            return "Sorry. There was a problem accessing your orientation. Please ensure that you have specified 'h' for horizontal orientation, or 'v' for vertical orientation.";
        }

    

        for (int r = rowStart; r<rowEnd; r++){
            for (int c = colStart; c<colEnd; c++){
                
            
                    try{
                    
                        if (locations[r][c] == '0'){
                            locations[r][c] = typeChar;
                            errorMessage = "comp_code_VALID";
                        }
                        else{
                            errorMessage = "Sorry. Your " + fullType + " is overlapping with another ship. Please try again.";
                        }

                    } catch (Exception ArrayIndexOutOfBoundsException){

                        errorMessage = "Sorry. Your " + fullType + " position is not valid. Remember, ships must be within the 10 by 10 game square. Please try again.";

                    }

                
                }
                
            }
        

        return errorMessage;

    }
    
}
