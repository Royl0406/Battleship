

public class GameDriver {
    
    private Player p1;
    private Player p2;
    
    public GameDriver() {
        p1 = new Player(0);
        p2 = new Player(1);
        
        }
    

    public void play(){

        p1.setShipLocations();
        p2.setShipLocations();
        
    }

    
}