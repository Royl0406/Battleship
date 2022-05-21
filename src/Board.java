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


    public int targetLocation(int r, int c){
        if (boardArray[r][c]!='1' && boardArray[r][c]!='0'){
            System.out.println("Hit!");
            boardArray[r][c] = 1;
            return 1;
        }

        System.out.println("Miss!");

        return 0;
    }

    

}