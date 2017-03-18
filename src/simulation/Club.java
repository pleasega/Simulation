package simulation;

/**
 * Created by LPC on 18/3/2017.
 */
public class Club {
    private String name;
    private double attackRating;
    private double midfieldRating;
    private double defenseRating;

    public Club(String name, double attackRating, double midfieldRating, double defenseRating)
    {
        this.name = name;
        this.attackRating = attackRating;
        this.midfieldRating = midfieldRating;
        this.defenseRating = defenseRating;
    }

    public String getName()
    {
        return name;
    }

    public double getAttackRating()
    {
        return attackRating;
    }

    public double getMidfieldRating()
    {
        return midfieldRating;
    }

    public double getDefenseRating()
    {
        return defenseRating;
    }
}