//This class integrates the GUI classes and the backend classes to bring the game together in the play method

import java.util.Scanner;

public class GameDriver {
    
    private Player p1;
    private Player p2;
    private GameBoard p1Board;
    private GameBoard p2Board;
    private Player winner;
    private StartMenu start;
    private char currentType;
    boolean cheatCode;
    
    public GameDriver() {
        p1 = new Player(0);
        p2 = new Player(1);
        cheatCode = false;
        
        
        
        }
    
    //Runs a game
    public void play(){

        start = new StartMenu();
        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean moveOn = false;
        while(!moveOn){
            moveOn = start.isClosed();
            System.out.print("");
        }
        System.out.println("Player 1: Please enter your username.");
        
        boolean validName = false;
        while(!validName){
            validName = p1.setUsername();
            
        }

        if(p1.getName().equals("Hemiup")){
            input = sc.nextLine();
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("Player 2: Please enter your username.");
        
        validName = false;
        while(!validName){
            validName = p2.setUsername();
        }

        if(p2.getName().equals("Hemiup")){
            input = sc.nextLine();
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

        p1.setShipLocations();

        System.out.print("\033[H\033[2J");
        System.out.flush();


        p2.setShipLocations();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        boolean gameOver = false;

        p1Board = new GameBoard(p1.getBoard().getBoard(), p1.getShipList());
        p2Board = new GameBoard(p2.getBoard().getBoard(), p2.getShipList());

        while(!gameOver){

            p2Board.showBoard();
            
            
            System.out.println(p1.getName()+", choose your target.");
            
            
            
            int valid = -1;

            while(valid == -1){
                input = sc.nextLine();

                if(input.equals("DhruvAndRoyRock")){
                    gameOver = true;
                    cheatCode = true;
                    winner = p1;
                    
                }

                else{valid = p2.getBoard().targetLocation(input);}
                
            }

            if (valid == 1){
                p2.updateShips(input);
            }
            
            p1.addHit(valid);
            p1.addShot();
            if(!cheatCode){gameOver = p2.getBoard().gameState();}
            System.out.println("Press enter to continue");
            input = sc.nextLine();


            p2Board.close();
            p2Board.updateBoard(p2.getBoard().getHits());

            System.out.print("\033[H\033[2J");
            System.out.flush();

            p1Board.showBoard();
            

            System.out.println(p2.getName()+", choose your target.");
            
            
            valid = -1;

            while(valid == -1){
                input = sc.nextLine();

                if(input.equals("DhruvAndRoyRock")&&(!cheatCode)){
                    gameOver = true;
                    cheatCode = true;
                    winner = p2;
                }

                else{valid = p1.getBoard().targetLocation(input);}
                
            }
            
            if (valid == 1){
                p1.updateShips(input);
            }

            p2.addHit(valid);
            p2.addShot();
            
            if(!gameOver){gameOver = p1.getBoard().gameState();}
            

            System.out.println("Press enter to continue");
            input = sc.nextLine();

            p1Board.close();
            p1Board.updateBoard(p1.getBoard().getHits());

            System.out.print("\033[H\033[2J");
            System.out.flush();


        }

        if(p2.getBoard().gameState()&& (!cheatCode)){
            winner = p1;
        }
        else if (!cheatCode){
            winner = p2;
        }

        System.out.println(winner.getName() + " wins! Long live the " + winner.getTeam() + "!");

        Stats endGame = new Stats(p1.getShots(), p1.getHits(), p2.getShots(), p2.getHits(), p1.getName(), p2.getName());
        
    }

    
}