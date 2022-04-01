public class Ship {

    private int rowNum;
    private int colNum;
    private int length;
    private int type;
    private String orient;
    private int[] statusArray;
    
    
    public Ship(int rowNum, int colNum, int length, int type, String orient){

        this.rowNum = rowNum;
        this.colNum = colNum;
        this.length = length;
        this.type = type;
        this.orient = orient;
        statusArray = new int[5];
        for (int i = 0; i<length; i++){
            statusArray[i] = 1;
        }

    }

    public boolean isSunk(){
        for (int i : statusArray) {

            if(i == 1){
                return false;
            }
            
        }

        return true;
    }

    public void shipHit(int index){

        statusArray[index] = 0;

    }
    
}
