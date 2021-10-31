package Character;
import combat.*;

public class character {

    //region Name

    public character(String name) { this.Name = name; }

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
        return dmg;
    }

    //endregion

}
