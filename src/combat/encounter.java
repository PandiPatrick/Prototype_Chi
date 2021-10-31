package combat;
import Character.*;

import java.util.Random;
import java.util.Scanner;


public class encounter {
    Scanner sc = new Scanner(System.in);
    Random rnd=new Random();
    Character.Character player;
    Character.Character enemy;

    private double playerDmg = player.getDmg();
    private double enemyDmg = enemy.getDmg();

    public void healthDown(Character.Character target, double value){
        double current = target.Health.getValue();
        target.Health.setValue(current - value);
    }

    public void healthUp(Character.Character target, double value){
        double current = target.Health.getValue();
        target.Health.setValue(current + value);
    }

    public double HP(Character.Character target){
        return target.Health.getValue();
    }

    public void runAway(){
        int x = rnd.nextInt(11);

        if(x==1)
            healthDown(this.player, 20); //we can change this however we want
            //print message on screen then end combat
        else
            System.out.println("bravo");
            //print message on screen then end combat
    }

    public void fight(){
        boolean x = true; //the check for the combat loop (you or the enemy is dead)

        while(x){ // while one of you is alive or until you run away
            //mesaje de combat + stats(?)

            int opt = sc.nextInt(); //we can modify this after both the UI and logic is done

            switch(opt){
                case 1: //Attack
                    healthDown(enemy, player.getDmg());
                case 2: //Run
                    runAway();
                case 3: //Inventory and use health potion
                    healthUp(player, 50);    //we'll use a variable instead of 50
            }

            if(HP(enemy)>1){
                healthDown(player, enemy.getDmg());
            }

            if(HP(enemy)<1){
                x = false;
                //how to add XP?
                //end combat after win message
            }
            if(HP(player)<1){
                x= false;
                //death
                //death screen (maybe)
                //end combat
            }

        }

    }

}
