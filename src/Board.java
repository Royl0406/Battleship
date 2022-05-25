public class Board{
    private char[][] boardArray;
    private int team;
    private char currentType;
    public Board(char[][] input){
        boardArray = input;
        currentType = 0;
    }

    public Board(int team){

        this.team = team;

    }

    public char[][] getBoard(){
        return boardArray;
    }

    public void setBoard(char[][] input){
        boardArray = input;
    }

    public char getType(int r, int c){
        return boardArray[r][c];
    }


    public int targetLocation(String input){
        
        int r;
        int c = 0;

        try {

            c = Integer.parseInt(input.substring(1));
            
        } catch (Exception numberFormatException) {
            System.out.println("Sorry. That's not a valid target. Please try again.");
            return -1;
        }
        
        
        

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
            default: System.out.println("Sorry. That's not a valid target. Please try again"); return -1;
            

        }

    
    
        try {

        if (boardArray[r][c]!='1' && boardArray[r][c]!='0'){
            System.out.println("Hit!");
            currentType = boardArray[r][c];
            boardArray[r][c] = '1';
            return 1;
        }

        else if(boardArray[r][c] == '1' || boardArray[r][c] == '2'){
            System.out.println("Sorry. It looks like you've already hit that square. Please try again.");
            return -1;
        }

        System.out.println("Miss!");
        boardArray[r][c] = '2';

        return 0;
        
    } catch (Exception arrayIndexOutOfBoundsException) {

        
        System.out.println("Sorry. That's not a valid target. Please try again.");
        return -1;
        
    }

        
    }

//remember to add 2 for missed shots
    public boolean gameState(){

        for(char[] arr : boardArray){
            for(char loc : arr){
                if(loc!= '0' && loc!= '1' && loc!= '2'){
                    return false;
                }
            }
        }

        return true;

    }

    public char getCurType (){
        return currentType;
    }

    

}