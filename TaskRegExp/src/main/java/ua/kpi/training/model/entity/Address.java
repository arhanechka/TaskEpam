package ua.kpi.training.model.entity;

/**
 * Created by Anya on 14.05.2017.
 */
public class Address {
    private String index;
    private String town;
    private String street;
    private String homeNumber;
    private String appartmentNumber;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getAppartmentNumber() {
        return appartmentNumber;
    }

    public void setAppartmentNumber(String appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    @Override
    public String toString() {
        return
                "index= " + index +
                ", town= " + town +
                ", street= " + street +
                ", homeNumber= " + homeNumber +
                ", appartmentNumber= " + appartmentNumber;
    }
}
