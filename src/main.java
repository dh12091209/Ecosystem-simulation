import java.util.TreeMap;

public class main {
    public static void main(String[] args) throws InterruptedException {
        River myRiver = new River();

        Animal.setRiver(myRiver);
        myRiver.addAnimal(new Bear(),5);
        myRiver.addAnimal(new Fish(),20);
        myRiver.addAnimal(new Fish(),30);
        myRiver.addAnimal(new Bear(),40);
        myRiver.addAnimal(new Fish(),50);
        myRiver.addAnimal(new Fish(),52);
        myRiver.addAnimal(new Bear(),70);

        while(true){
            myRiver.stepSim();

            System.out.println(myRiver);
            Thread.sleep(400);
        }

    }
}
