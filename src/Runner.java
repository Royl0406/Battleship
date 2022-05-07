public class Runner {
    public static void main(String[] args) {
        GameSetup r1 = new GameSetup();
        GameBoard g1 = new GameBoard();
        String[] shipLoc = r1.extractIndividualShip("A A1v B A6v D E3h S F4v P G7h");
        for(int i = 0; i < shipLoc.length; i++) {  
            if (!r1.setLocation(shipLoc[i]).equals("comp_code_VALID")){
                System.out.println(r1.setLocation(shipLoc[i]));
            }
            
            
            
        }
    
        //System.out.println(r1.setLocation("A A9h"));
    }
    
}
