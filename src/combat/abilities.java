package combat;
import Character.*;

public class abilities {
    private double dmg;
    private int speed = 0;
    private int speedCost;
    private int staminaCost;
    private String name;

    public abilities(int optiune){

        switch(optiune) {
            case 1:
                this.dmg = 25;
                this.speedCost = 2;
                this.staminaCost = 10;
                this.name = "Average";
                break;
            case 2:
                this.dmg = 50;
                this.speedCost = 3;
                this.staminaCost = 25;
                this.name = "Strong";
                break;
            case 3:
                this.dmg = 20;
                this.speedCost = 1;
                this.staminaCost = 10;
                this.name = "Fast";
                break;
                //i set random numbers, we can decide these after testing
        }
    }

    public double getDamage() {
        return dmg;
    }
    public double getStamina1() {
        return staminaCost;
    }

    public void used(){
        this.speed+=speedCost;
    }
    public void turn() {
        speed--;
    }


    public int getSpeed() {
        return speed;
    }
}
