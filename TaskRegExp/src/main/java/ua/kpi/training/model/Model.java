package ua.kpi.training.model;

import ua.kpi.training.model.entity.Address;
import ua.kpi.training.model.entity.Communications;
import ua.kpi.training.model.entity.GlobalInformation;
import ua.kpi.training.model.entity.Groups;
import java.time.LocalDate;

/**
 * Created by Anya on 15.05.2017.
 */
public class Model {
    private GlobalInformation globalInformation;
    private String comment;
    private Groups group;
    private Communications communications;
    private Address address;
    private LocalDate dateAdding;
    private LocalDate dateChanging;

    public GlobalInformation getGlobalInformation() {
        return globalInformation;
    }

    public void setGlobalInformation(GlobalInformation globalInformation) {
        this.globalInformation = globalInformation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public Communications getCommunications() {
        return communications;
    }

    public void setCommunications(Communications communications) {
        this.communications = communications;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getDateAdding() {
        return dateAdding;
    }

    public void setDateAdding(LocalDate dateAdding) {
        this.dateAdding = dateAdding;
    }

    public LocalDate getDateChanging() {
        return dateChanging;
    }

    public void setDateChanging(LocalDate dateChanging) {
        this.dateChanging = dateChanging;
    }

    public String toString(){
       StringBuffer sb = new StringBuffer();
        sb.append("The data of card:\n");
        sb.append("The global information: \n"+ getGlobalInformation().toString()+"\n");
        sb.append("Comment:\n"+ getComment()+"\n");
        sb.append("Group: \n"+getGroup()+"\n");
        sb.append("Communications: \n"+ getCommunications().toString()+"\n");
        sb.append("Address data: \n"+ getAddress().toString()+"\n");
        sb.append("Date of adding: \n" +getDateAdding());
        return sb.toString();
    }
}
