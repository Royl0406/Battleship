public class Board{
    private char[][] boardArray;
    public Board(char[][] input){
        boardArray = input;
    }

    public Board(){

    }

    public char[][] getBoard(){
        return boardArray;
    }

    public void setBoard(char[][] input){
        boardArray = input;
    }


    public int targetLocation(String input){
        
        int r;
        int c;

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
            default: r = 9;
            

        }



        if (boardArray[r][c]!='1' && boardArray[r][c]!='0'){
            System.out.println("Hit!");
            boardArray[r][c] = 1;
            return 1;
        }

        System.out.println("Miss!");

        return 0;
    }


    public boolean gameState(){

        for(char[] arr : boardArray){
            for(char loc : arr){
                if(loc!= '0' && loc!= '1'){
                    return false;
                }
            }
        }

        return true;

    }

    

}