package Character;
import combat.*;

public class character {

    //region constructor

    //player
    public character(String name, double health, double stamina) {
        this.Name = name;
        Health.setValue(health);
        Stamina.setValue(stamina);
    }

    //enemy
    public character(int enemyDamage,String name, double health){
        this.Name = name;
        this.enemyDamage = enemyDamage;
        Health.setValue(health);
    }

    //end region



    //public double run = 0; //I'll set it public until i figure out how to protect it while also easily using it

    private double enemyDamage;

    public abilities ability1 = new abilities(1);  //maybe set the ability when creating the character using the constructor?
    public abilities ability2 = new abilities(2);
    public abilities ability3 = new abilities(3);


    private boolean alive = true;

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    //region Name



    private String Name;
    public void setName(String setName){
        Name = setName;
    }
    public String getName() { return Name; }

    //endregion



    //region Metrics INIT

    // Fields: Max, Value | Methods: get, set, add
    public Metrics Health = new Metrics(100, 100);
    public Metrics Stamina = new Metrics(100, 100);

    //endregion

    //region The weapon used
    //modify or tell me how to add this otherwise

    private weapons current = new weapons();
    //citire current din JSon sau inventory (?)
    double dmg = current.getDamage();

    public double getDmg(abilities ability) {
        return ability.getDamage();
    }
    public double getStaminaCost(abilities ability) {
        return ability.getStamina1();
    }
    public double getRun(abilities ability){return ability.getSpeed();}


    //endregion

    public void setEnemyDamage(double enemyDamage){
        this.enemyDamage = enemyDamage;
    }
    public double getEnemyDamage(){
        return this.enemyDamage;
    }


}
