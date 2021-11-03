package Character;
import combat.*;

public class character {

    public double run = 0; //I'll set it public until i figure out how to protect it while also easily using it

    private boolean alive = true;

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public boolean isAlive() {
        return alive;
    }
    abilities ability;

    //region Name

    public character(String name, int ability, boolean alive) {
        this.Name = name;
        this.ability = new abilities(ability);
        this.alive = alive;
    }

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
        return ability.getStamina();
    }
    public double getRun(){return ability.getSpeed();}

    public void setRun(){
        this.run = getRun();
    }
    //endregion

    public void printStats(){
        System.out.println(Name + " has " + Health.getValue() + " Health and " + Stamina.getValue() + " Stamina");
    }



}
