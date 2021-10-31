package combat;
import Character.*;

public class weapons {
    private Items weapon;

    private int damage;

    public int getDamage(){return damage;}


    //set the damage got from Json through this
    public void setDamage(int damage){this.damage = damage;}


    public weapons(){

    }
}
