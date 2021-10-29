package Character;

public class Skill {

    //region FIELDS

    private double Level;
    private double XP;
    private double RankUpXP; // XP till next level

    //endregion

    //region Stat INIT

    public Skill (double level, double xp, double RankUpXP) {
        this.Level = level;
        this.XP = xp;
        checkRankUp();
        this.RankUpXP = RankUpXP;
    }

    //endregion

    //region SET

    public void setLevel (double setLevel) {
        this.Level = setLevel;
    }

    public void setXP (double setXP) {
        this.XP = setXP;
        checkRankUp();
    }

    public void setRankUpXP (double setRankUpXP) {
        this.RankUpXP = setRankUpXP;
    }

    //endregion

    //region ADD

    public void addLevel (double addLevel) {
        Level += addLevel;
    }

    public void addXP (double addXP) {
        XP += addXP;
        checkRankUp();
    }

    public void addRankUpXP (double addRankUpXP) {
        RankUpXP += addRankUpXP;
    }

    //endregion

    //region GET

    public double getLevel () { return Level; }

    public double getXP () { return XP; }

    public double getRankUpXP () { return RankUpXP; }

    //endregion

    //region RankUp

    // Checks if XP reached RankUpXP threshold
    public void checkRankUp () {
        if ( XP >= RankUpXP)
        {
            XP = XP - RankUpXP;
            addLevel(1);
        }
    }

    //endregion

}

