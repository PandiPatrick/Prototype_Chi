package Character;
import combat.*;

public class character {

    public double run = 0; //I'll set it public until i figure out how to protect it while also easily using it


    private int n; //putem seta abilitatea prin n cand construim caracterul?
    abilities ability = new abilities(n);  //maybe set the ability when creating the character using the constructor?


    private boolean alive = true;

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    //region Name

    public character(String name, int n) { this.Name = name; this.n = n;}

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

    public double getDmg() {
        return ability.getDamage();
    }
    public double getStaminaCost() {
        return ability.getStamina1();
    }
    public double getRun(){return ability.getSpeed();}

    public void setRun(){
        this.run = getRun();
    }
    //endregion




}
