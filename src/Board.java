public class Board{
    private char[][] boardArray;
    public Board(char[][] input){
        boardArray = input;
    }

    public char[][] getBoard(){
        return boardArray;
    }

    public boolean isHit(int r, int c){

        return (boardArray[r][c] == '1');

    }

    

}