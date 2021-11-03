package saves;

public class SaveCharacter {
    private String Name;
    private boolean isAlive;
    private int LocationX;
    private int LocationY;
    private int Health;
    private int Stamina;


    public SaveCharacter() {
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setLocationX(int locationX) {
        LocationX = locationX;
    }

    public void setLocationY(int locationY) {
        LocationY = locationY;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public void setStamina(int stamina) {
        Stamina = stamina;
    }

    public String getName() {
        return Name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getLocationX() {
        return LocationX;
    }

    public int getLocationY() {
        return LocationY;
    }

    public int getHealth() {
        return Health;
    }

    public int getStamina() {
        return Stamina;
    }
}
