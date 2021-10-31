package Character;
import combat.*;

public class Character {

    //region Name

    public Character (String name) { this.Name = name; }

    private String Name;
    public void setName(String setName){
        Name = setName;
    }
    public String getName() { return Name; }

    //endregion

    //region Skill INIT

    // Fields: level, xp, RankUpXP | Methods: get, set, add
    public Skill Harvesting = new Skill(0, 0, 100);
    public Skill Logging  = new Skill(0, 0, 100);
    public Skill Mining  = new Skill(0, 0, 100);
    public Skill Skinning  = new Skill(0, 0, 100);
    public Skill Fishing  = new Skill(0, 0, 100);

    //endregion

    //region Metrics INIT

    // Fields: Max, Value | Methods: get, set, add
    public Metrics Health = new Metrics(100, 100);
    public Metrics Mana = new Metrics(100, 100);
    public Metrics Stamina = new Metrics(100, 100);

    //endregion

    //region The weapon used
    //modify or tell me how to add this otherwise

    private weapons current = new weapons();
    //citire current din JSon sau inventory (?)
    double dmg = current.getDamage();

    public double getDmg() {
        return dmg;
    }

    //endregion

}
