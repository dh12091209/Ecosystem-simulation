public class Animal {
    private String symbol;
    protected static River river;


    public Animal(){
        symbol = "A";
    }
    public Animal(String symbol){
        this.symbol = symbol;
    }

    public static void setRiver(River river){
        Animal.river = river;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public void act(int index){
        if(river == null) throw new IllegalStateException("Cannot Act - No River Set for Animals");

        int choice = (int)(1+Math.random()*100);
        if(choice <= 20){//move left
                //make sure I am not at the left end
            if(index ==0) return; //exit, cannot move

            //get the Animal next to me
            Animal nexToMe = river.getAnimalAt(index-1);
            //if the space is empty, move to it
            if(nexToMe == null){
                river.clearLoc(index);
                river.addAnimal(this,index-1);
            }
        }
        else if(choice <= 40){ //move right
            //make sure I am not at the right end
            if(index ==river.getLength()) return; //exit, cannot move

            //get the Animal next to me
            Animal nexToMe = river.getAnimalAt(index+1);
            //if the space is empty, move to it
            if(nexToMe == null){
                river.clearLoc(index);
                river.addAnimal(this,index+1);
            }
        }
    }
}
