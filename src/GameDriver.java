import org.jcp.xml.dsig.internal.SignerOutputStream;

public class GameDriver {
    
    private String[] shipLocation;
    private Player p1;
    private Player p2;
    
    public GameDriver(String[] shipLocation) {
        this.shipLocation = shipLocation;
        GameSetup currentGame = new GameSetup();
        
        }
    

    public boolean sinkConfirmation(Ship current) {

        if (current.isSunk()){
            System.out.println("You have sunk your opponent's " + current.getType());
            return true;
        }
        return false;
    }
    public boolean hitMiss(int hLoc, int vLoc){


        
        return true;
        
    }

    
}