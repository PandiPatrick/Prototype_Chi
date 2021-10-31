package combat;
import Character.*;

import java.util.Random;
import java.util.Scanner;


public class encounter {
    Scanner sc = new Scanner(System.in);
    Random rnd=new Random();

    character player1;
    character player2;
    character player3;
    character enemy1;
    character enemy2;
    character enemy3;

    public encounter(character player1, character player2, character player3, character enemy1, character enemy2, character enemy3){
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.enemy1 = enemy1;
        this.enemy2 = enemy2;
        this.enemy3 = enemy3;
    }
    //you can send already created characters with already established stats where you call the encounter


/*
    private double playerDmg1 = player1.getDmg();
    private double playerDmg2 = player2.getDmg();
    private double playerDmg3 = player3.getDmg();
    private double enemyDmg1 = enemy1.getDmg();
    private double enemyDmg2 = enemy2.getDmg();
    private double enemyDmg3 = enemy3.getDmg();
*/

    public void healthDown(character target, double value){
        double current = target.Health.getValue();
        target.Health.setValue(current - value);
    }

    public void healthUp(character target, double value){
        double current = target.Health.getValue();
        target.Health.setValue(current + value);
    }

    public double HP(character target){
        return target.Health.getValue();
    }

    public void runAway(){
        int x = rnd.nextInt(11);

        if(x==1) {
            healthDown(this.player1, 20); //we can change this however we want
            healthDown(this.player2, 20);
            healthDown(this.player3, 20);
        }
            //print message on screen then end combat
        else
            System.out.println("bravo");
            //print message on screen then end combat
    }

    public void attack(character player, character target){
        double dmg = player.getDmg();
        healthDown(target, dmg);
    }

    public boolean alive(character target){
        if(HP(target)<1){
            return false;
        }
        else
            return true;
    }

    public character randomTarget(){
        int n = rnd.nextInt(3);

        if(n==0 && alive(player1)==true)
            return player1;
        else if(n==1 && alive(player2)==true)
            return player2;
        else if(n==2 && alive(player3)==true)
            return player3;

        return null;
    }

    public void fight(){
        double stamina;
        boolean x = true; //the check for the combat loop (you or the enemy is dead)

        while(x){ // until either all enemies or all players die or they run away
            //mesaje de combat + stats(?) - UI

            int opt = sc.nextInt(); //we can modify this after both the UI and logic is done
            stamina = player1.Stamina.getValue();
            switch (opt) {
                    case 1: //Attack
                        if(player1.run == 0 && stamina>player1.getStaminaCost() ){ //maybe make the button invisible for that option in the UI if that's the case?
                        attack(player1, enemy1);
                            if (alive(enemy1)==false);

                            //xp++
                            player1.Stamina.setValue(stamina - player1.getStaminaCost());
                            player1.setRun();

                        }
                        break;
                    case 2:
                        if(player1.run == 0 && stamina>player1.getStaminaCost() ){
                        attack(player1, enemy2);

                            if (alive(enemy2)==false);

                            //xp++
                            player1.Stamina.setValue(stamina - player1.getStaminaCost());
                            player1.setRun();
                            }
                        break;
                    case 3:
                        if(player1.run == 0 && stamina>player1.getStaminaCost() ){
                        attack(player1, enemy3);
                            if (alive(enemy3)==false);

                            //xp++
                            player1.Stamina.setValue(stamina - player1.getStaminaCost());
                            player1.setRun();
                            }
                        break;//we'll use a variable instead of 50
                    case 4: //Run
                        runAway();
                        break;
                    case 5: //Inventory and use health potion
                        healthUp(player1, 50);
                        break;//we'll use a variable instead of 50
             }

            opt = sc.nextInt(); //we can modify this after both the UI and logic is done
            stamina = player2.Stamina.getValue();
            switch (opt) {
                case 1: //Attack
                    if(player2.run == 0 && stamina>player2.getStaminaCost() ){
                    attack(player2, enemy1);

                        if (alive(enemy1)==false);

                        //xp++
                        player2.Stamina.setValue(stamina - player1.getStaminaCost());
                        player2.setRun();
                    }
                    break;
                case 2:
                    if(player2.run == 0 && stamina>player2.getStaminaCost() ){
                    attack(player2, enemy2);

                        if (alive(enemy2)==false);

                        //xp++
                        player2.Stamina.setValue(stamina - player1.getStaminaCost());
                        player2.setRun();
                    }
                    break;
                case 3:
                    if(player2.run == 0 && stamina>player2.getStaminaCost() ){
                    attack(player2, enemy3);

                        if (alive(enemy3)==false);

                        //xp++
                        player2.Stamina.setValue(stamina - player1.getStaminaCost());
                        player2.setRun();
                    }
                    break;//we'll use a variable instead of 50
                case 4: //Run
                    runAway();
                    break;
                case 5: //Inventory and use health potion
                    healthUp(player2, 50);
                    break;//we'll use a variable instead of 50
            }

            opt = sc.nextInt(); //we can modify this after both the UI and logic is done
            stamina = player3.Stamina.getValue();
            switch (opt) {
                case 1: //Attack
                    if(player3.run == 0 && stamina>player3.getStaminaCost() ){
                    attack(player3, enemy1);
                        if (alive(enemy1)==false);

                        //xp++
                        player3.Stamina.setValue(stamina - player1.getStaminaCost());
                        player3.setRun();
                    }
                    break;
                case 2:
                    if(player3.run == 0 && stamina>player3.getStaminaCost() ){
                    attack(player3, enemy2);
                        if (alive(enemy2)==false);

                        //xp++
                        player3.Stamina.setValue(stamina - player1.getStaminaCost());
                        player3.setRun();
                    }
                    break;
                case 3:
                    if(player3.run == 0 && stamina>player3.getStaminaCost() ){
                    attack(player3, enemy3);
                    if (alive(enemy3)==false);

                    //xp++
                        player3.Stamina.setValue(stamina - player1.getStaminaCost());
                        player3.setRun();
                    }
                    break;//we'll use a variable instead of 50
                case 4: //Run
                    runAway();
                    break;
                case 5: //Inventory and use health potion
                    healthUp(player1, 50);
                    break;//we'll use a variable instead of 50
            }

            if(HP(enemy1)>1){
                healthDown(randomTarget(), enemy1.getDmg());
            }
            if(HP(enemy2)>1){
                healthDown(randomTarget(), enemy2.getDmg());
            }
            if(HP(enemy3)>1){
                healthDown(randomTarget(), enemy3.getDmg());
            }

            if(alive(enemy1)==false && alive(enemy2)==false && alive(enemy3)==false){
                x = false;
                //end combat after win message
            }
            if(alive(player1)==false && alive(player2)==false && alive(player3)==false){
                x = false;
                //end combat
                //game over screen
            }

            player1.run --;
            player2.run --;
            player3.run --;

        }

    }

}
