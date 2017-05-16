package ua.kpi.training.model.entity;

/**
 * Class for input the addess data of current user.
 */
public class Address {
    /**
     * The {@link Address#index} field representing postal index.
     */
    private String index;
    /**
     * The {@link Address#town} field representing town where member lives.
     */
    private String town;
    /**
     * The {@link Address#street} field representing street where member lives.
     */
    private String street;
    /**
     * The {@link Address#homeNumber} field representing number of house where member lives.
     */
    private String homeNumber;
    /**
     * The {@link Address#appartmentNumber} field representing number of appartment where member lives.
     */
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
