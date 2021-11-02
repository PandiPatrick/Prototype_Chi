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

    private abilities abilityUsed;
    private int check;

    public encounter(character player1, character player2, character player3, character enemy1, character enemy2, character enemy3, int check){
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.enemy1 = enemy1;
        this.enemy2 = enemy2;
        this.enemy3 = enemy3;
        this.check = check;
    }

    public encounter(character player, character enemy, int check){
        this.player1 = player;
        this.enemy1 = enemy;
        this.check = check;
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

    public void turnStats(){
        player1.ability1.turn();
        player1.ability2.turn();
        player1.ability3.turn();
        player2.ability1.turn();
        player2.ability2.turn();
        player2.ability3.turn();
        player3.ability1.turn();
        player3.ability2.turn();
        player3.ability3.turn();
    }

    public void attack(character player, character target){
        double stamina = player.Stamina.getValue();

        int opt = sc.nextInt();
        double dmg;
        switch(opt){
            case 1:
                dmg = player.ability1.getDamage();
                if(player.ability1.getSpeed() > 0 || stamina>player.ability1.getStamina1())
                    break;
                healthDown(target, dmg);
                player.ability1.used();
                player.Stamina.setValue(stamina - player.ability1.getStamina1());
                break;
            case 2:
                dmg = player.ability2.getDamage();
                if(player.ability2.getSpeed() > 0 || stamina>player.ability2.getStamina1())
                    break;
                healthDown(target, dmg);
                player.ability2.used();
                player.Stamina.setValue(stamina - player.ability2.getStamina1());
                break;
            case 3:
                dmg = player.ability3.getDamage();
                if(player.ability3.getSpeed() > 0 || stamina>player.ability3.getStamina1())
                    break;
                healthDown(target, dmg);
                player.ability3.used();
                player.Stamina.setValue(stamina - player.ability3.getStamina1());
                break;
        }

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

    public void fight3(){
        double stamina;
        boolean x = true; //the check for the combat loop (you or the enemy is dead)

        while(x){ // until either all enemies or all players die or they run away
            //mesaje de combat + stats(?) - UI

            int opt = sc.nextInt(); //we can modify this after both the UI and logic is done - here we need to choose the target of the attack or the option to heal or run
            stamina = player1.Stamina.getValue();
            switch (opt) {
                    case 1: //Attack
                        attack(player1, enemy1);
                            if (alive(enemy1)==false);
                                //xp++
                        break;
                    case 2:
                        attack(player1, enemy2);
                        if (alive(enemy2)==false);
                        //xp++
                        break;
                    case 3:
                        attack(player1, enemy3);
                        if (alive(enemy3)==false);
                        //xp++
                        break;
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
                    attack(player2, enemy1);
                    if (alive(enemy1)==false);
                    //xp++
                    break;
                case 2:
                    attack(player2, enemy2);
                    if (alive(enemy2)==false);
                    //xp++
                    break;
                case 3:
                    attack(player2, enemy3);
                    if (alive(enemy3)==false);
                    //xp++
                    break;
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
                    attack(player3, enemy1);
                    if (alive(enemy1)==false);
                    //xp++
                    break;
                case 2:
                    attack(player3, enemy2);
                    if (alive(enemy2)==false);
                    //xp++
                    break;
                case 3:
                    attack(player3, enemy3);
                    if (alive(enemy3)==false);
                    //xp++
                    break;
                case 4: //Run
                    runAway();
                    break;
                case 5: //Inventory and use health potion
                    healthUp(player3, 50);
                    break;//we'll use a variable instead of 50
            }

            if(HP(enemy1)>1){
                healthDown(randomTarget(), enemy1.getEnemyDamage());
            }
            if(HP(enemy2)>1){
                healthDown(randomTarget(), enemy2.getEnemyDamage());
            }
            if(HP(enemy3)>1){
                healthDown(randomTarget(), enemy3.getEnemyDamage());
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

            turnStats();
        }

    }

    public void fight1(character player, character enemy) {
        double stamina;
        boolean x = true; //the check for the combat loop (you or the enemy is dead)

        while (x) { // until either all enemies or all players die or they run away
            //mesaje de combat + stats(?) - UI

            int opt = sc.nextInt(); //we can modify this after both the UI and logic is done - here we need to choose the target of the attack or the option to heal or run
            stamina = player.Stamina.getValue();
            switch (opt) {
                case 1: //Attack
                    attack(player, enemy);
                    if (alive(enemy) == false) ;
                    //xp++
                    break;
                case 2: //Run
                    runAway();
                    break;
                case 3: //Inventory and use health potion
                    healthUp(player, 50);
                    break;//we'll use a variable instead of 50
            }

            if (alive(enemy) == false) {
                x = false;
                //end combat after win message
            }
            if (alive(player) == false) {
                x = false;
                //end combat
                //game over screen
            }

            player.ability1.turn();
            player.ability2.turn();
            player.ability3.turn();

        }
    }

    public void startFight(){
        if(check==1)
            fight1(player1, enemy1);
        else
            fight3();
    }

}
