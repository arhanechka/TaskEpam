package ua.kpi.company;

/**
 * Created by User on 17.03.2016.
 */
public class Model {
    private String stringValue;


    // The Program logic

    public String getValue() {
        return stringValue;
    }

    public void setValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public void addValue(String stringValueForAdding) {
        this.stringValue += ", " + stringValueForAdding;
    }

}