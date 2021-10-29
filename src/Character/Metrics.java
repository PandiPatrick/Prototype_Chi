package Character;

public class Metrics {

    //region FIELDS

    private double max;
    private double value;

    //endregion

    //region Metric INIT

    public Metrics (double max, double value) {
        this.max = max;
        this.value = value;
        checkOvercapping();
    }

    //endregion

    //region SET

    public void setValue (double value) {
        this.value = value;
        checkOvercapping();
    }
    public void setMax (double max) {
        this.max = max;
    }

    //endregion

    //region GET

    public double getValue () {
        return value;
    }
    public double getMax () {
        return max;
    }

    //endregion

    //region ADD

    public void addValue (double value) {
        this.value += value;
        checkOvercapping();
    }
    public void addMax (double max) {
        this.max += max;
    }

    //endregion

    // Checks if Value is greater than Max
    public void checkOvercapping () {
        if ( value > max) {
            value = max;
        }
    }
}
