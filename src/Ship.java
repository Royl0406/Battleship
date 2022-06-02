//This class stores information about a specific ship, including an Integer array that contains the status of each square,
//an ImageIcon array that contains the images of each square, and other general information such as length, type, etc.



import javax.swing.*;

public class Ship {

    private int rowNum;
    private int colNum;
    private int length;
    private int type;
    private int team;
    private String orient;
    private int[] statusArray;
    private ImageIcon[] images;
    
    
    public Ship(){
        
    }
    
    public Ship(int rowNum, int colNum, int length, int type, String orient, int team){

        this.rowNum = rowNum;
        this.colNum = colNum;
        this.length = length;
        this.type = type;
        this.orient = orient;
        this.team = team;
        statusArray = new int[length];
        images = new ImageIcon[length];
        
        for (int i = 0; i<length; i++){
            statusArray[i] = 1;
        }

        
        
        for (int i = 0; i<length; i++){

            String pathName = "Star Wars images/";

            pathName = pathName + team + type + i + orient + ".png";


            images[i] = new ImageIcon(pathName);
            
            
        }

    }

    //Returns true if the ship is sunk and false otherwise

    public boolean isSunk(){
        for (int i : statusArray) {
            if(i == 1){
                return false;
            }
            
        }

        return true;
    }

    //Updates the status array to indicate that the ship has been hit

    public void shipHit(int index){

        statusArray[index] = 0;

    }

    //Basic getters

    public String getType(){
        switch(type){
            case 0: return "Aircraft Carrier"; 
            case 1: return "Battleship"; 
            case 2: return "Destroyer"; 
            case 3: return "Submarine"; 
            case 4: return "Patrol Boat";
            default: return "NULL";
         }
    }

    public int getTypeInt(){
        return type;
    }

    public ImageIcon getImage(int index){
        return images[index];
    }

    public int getRow(){
        return rowNum;
    }

    public int getCol(){
        return colNum;
    }

    public String getOrient(){
        return orient;
    }

    public int getLength(){
        return length;
    }


    
}
