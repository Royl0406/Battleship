public class GameDriver {
    
    private String[] shipLocation;
    
    public GameDriver(String[] shipLocation) {
        this.shipLocation = shipLocation;
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