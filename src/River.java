public class River {
    Animal river[];
    public  River(){
        river = new Animal[100];
    }
    public River(int num){
        river = new Animal[num];
    }
    //Design Decision - return boolean, return false if out of bounds and return false if index is already contains an Animal
    public boolean addAnimal(Animal a, int index){
        if(index <0 || index >= river.length) return false;

        Animal temp = getAnimalAt(index);
        if(temp!=null) return false;
        river[index] = a;
        return true;
    }

    public Animal getAnimalAt(int index){
        if (index<0||index>=river.length) throw new ArrayIndexOutOfBoundsException("Index is out of the River boundary");
        return river[index];
    }

    public String toString(){
        String out =""; //build our output
        for(Animal a : river){
            if(a==null){
                out += "-";
            }
            else{
                out += a.getSymbol();
            }
        }
        return out;
    }
    public void clearLoc(int index){
        river[index] = null;
    }
    public void stepSim(){
        for(int i=0; i<river.length; i++){
            Animal current = getAnimalAt(i);
            if(current != null){
                current.act(i);
            }
        }
        for(int i=0; i<river.length-1; i++){
            if (getAnimalAt(i) instanceof Bear && getAnimalAt(i+1) instanceof Fish){ // if bear with fish
                clearLoc(i+1);//clear fish loc
            }else if ((getAnimalAt(i) instanceof Fish && getAnimalAt(i+1) instanceof Bear)){ //if fish with bear
                clearLoc(i);//clear fish loc
            }else if ((getAnimalAt(i) instanceof Fish && getAnimalAt(i+1) instanceof Fish)){ // if fish with fish
                if(!isFull()) addAnimal(new Fish(), emptyPlace()); // if the array not full of Animal, add new fish on random place

            }
        }
    }
    //give a random place of array
    public int emptyPlace(){
        int rand = (int)(Math.random()*100);
        if(getAnimalAt(rand) == null) return rand;
        else return emptyPlace();

    }
    // is the array full of animal
    public boolean isFull(){
        for(Animal x: river){
            if(x == null) return false;
        }
        return true;
    }
    public int getLength(){
        return river.length -1;
    }
}
