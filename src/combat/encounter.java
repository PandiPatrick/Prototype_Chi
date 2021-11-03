package combat;
import Character.*;

import java.util.Random;
import java.util.Scanner;

public class encounter implements Runnable{
    Scanner sc = new Scanner(System.in);
    Random rnd=new Random();

    character player[] = new character[4];
    character enemy[] = new character[4];
    character missedDummy = new character("Dummy",1, true);

    public encounter(character player1, character player2, character player3, character enemy1, character enemy2, character enemy3){
        this.player[1] = player1;
        this.player[2] = player2;
        this.player[3] = player3;
        this.enemy[1] = enemy1;
        this.enemy[2] = enemy2;
        this.enemy[3] = enemy3;

        missedDummy.Health.setValue(999999);

        fight:
        while(true){ // until either all enemies or all players die or they run away
            //mesaje de combat + stats(?) - UI

            point:
            for (int i = 1; i <= 3; i++) {

                //if (!player[i].isAlive()) break point;

                int opt = sc.nextInt(); //we can modify this after both the UI and logic is done
                double stamina = player[i].Stamina.getValue();
                switch (opt) {
                    case 1: //Attack
                        attack(1, i, stamina);
                        System.out.println("Attacked Enemy 1 with Player " + i);
                        break;
                    case 2:
                        attack(2, i, stamina);
                        System.out.println("Attacked Enemy 2 with Player " + i);
                        break;
                    case 3:
                        attack(3, i, stamina);
                        System.out.println("Attacked Enemy 3 with Player " + i);
                        break;
                    case 4: //Run
                        if (runAway()) break fight;
                    case 5: //Inventory and use health potion
                        healthUp(player[i], 50);
                        System.out.println("Player " + i + " chugged a Potion and gained 50 Health");
                        break; //we'll use a variable instead of 50
                    case 6:
                        for (int j = 1; j <= 3; j++) {
                            player[j].printStats();
                        }
                        System.out.println();
                        for (int j = 1; j <= 3; j++) {
                            enemy[j].printStats();
                        }
                        i--;
                        break;
                }
            }

            if(enemy[1].isAlive()){
                healthDown(randomTarget(), enemy[1].getDmg());
            }
            if(enemy[2].isAlive()){
                healthDown(randomTarget(), enemy[2].getDmg());
            }
            if(enemy[3].isAlive()){
                healthDown(randomTarget(), enemy[3].getDmg());
            }

            if(!enemy[1].isAlive() && !enemy[2].isAlive() && !enemy[3].isAlive()){
                System.out.println("Victory");
                break fight;
            }
            if(!player[1].isAlive() && !player[2].isAlive() && !player[3].isAlive()){
                System.out.println("Defeat");
                break fight;
            }

            player[1].run --;
            player[2].run --;
            player[3].run --;

        }

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
        target.Health.setValue(target.Health.getValue() - value);
        if (target.Health.getValue()<=0) {
            target.setAlive(false);
            System.out.println("Character died");
        }
    }

    public void healthUp(character target, double value){
        target.Health.setValue(target.Health.getValue() + value);
    }

    public boolean runAway(){
        int x = rnd.nextInt(2);
        if(x==1) {
            healthDown(this.player[1], 20); //we can change this however we want
            healthDown(this.player[2], 20);
            healthDown(this.player[3], 20);
            System.out.println("Escape Attempt Failed");
            return false;
        }
        else
            System.out.println("Escape Attempt Successful");
        return true;
    }

    public void attack(character player, character target){
        healthDown(target, player.getDmg());
    }

    public character randomTarget(){
        int n = rnd.nextInt(3);

        if(n==0 && player[1].isAlive())
            return player[1];
        else if(n==1 && player[2].isAlive())
            return player[2];
        else if(n==2 && player[3].isAlive())
            return player[3];
        else return missedDummy;
    }

    public void attack(int enemyNumber, int attacker, double stamina){
        if(player[attacker].run == 0 && stamina>player[attacker].getStaminaCost() ){ //maybe make the button invisible for that option in the UI if that's the case?
            attack(player[attacker], enemy[enemyNumber]);
            if (!enemy[enemyNumber].isAlive());

            //xp++
            player[attacker].Stamina.setValue(stamina - player[attacker].getStaminaCost());
            player[attacker].setRun();

        }
    }


    @Override
    public void run() {

    }
}
