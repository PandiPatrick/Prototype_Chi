package Character;

public class Items {

    //region General Item Info

    private int ID; //ID value of the item
    private String Type; // Item Type ( Misc, Weapon, Armor... )
    private String Name; // Name of the Item
    private String Description; // Description of the item
    private double value; // Value in currency of the item

    //endregion

    //region Atribute Scaling

    private double STRScaling; // Strength Scaling
    private double DEXScaling; // Dexterity Scaling
    private double INTScaling; // Intelligence Scaling
    private double FOCScaling; // Focus Scaling
    private double CONScaling; // Constitution Scaling

    //endregion

    //region Item INIT

    public Items(int ID, String Type, String Name, String Description, double value){
        this.ID = ID;
        this.Type = Type;
        this.Name = Name;
        this.Description = Description;
        this.value = value;
    } // Misc Item Initialization

    public Items(int ID, String Type, String Name, String Description, double value,
                 double STRScaling, double DEXScaling, double INTScaling,
                 double FOCScaling, double CONScaling){
        this.ID = ID;
        this.Type = Type;
        this.Name = Name;
        this.Description = Description;
        this.value = value;
        this.STRScaling = STRScaling;
        this.DEXScaling = DEXScaling;
        this.INTScaling = INTScaling;
        this.FOCScaling = FOCScaling;
        this.CONScaling = CONScaling;
    } // Weapon/Armor Type Item Initialization

    //endregion

    //region GET

    public int getID() { return ID; }

    public String getType() { return Type; }

    public String getName() { return Name; }

    public String getDescription() { return Description; }

    public double getValue() { return value; }

    public double getSTRScaling() { return STRScaling; }

    public double getDEXScaling() { return DEXScaling; }

    public double getINTScaling() { return INTScaling; }

    public double getFOCScaling() { return FOCScaling; }

    public double getCONScaling() { return CONScaling; }

    //endregion

}
