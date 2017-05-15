package ua.kpi.training.model.entity;

/**
 * Created by Anya on 14.05.2017.
 */
public class Communications {
    private String phoneNumberHome;
    private String phoneNumberMobileFirst;
    private String phoneNumberMobileSecond;
    private String emailAddress;
    private String skypeNickName;

    public Communications() {
    }

    public String getPhoneNumberHome() {
        return phoneNumberHome;
    }

    public void setPhoneNumberHome(String phoneNumberHome) {
        this.phoneNumberHome = phoneNumberHome;
    }

    public String getPhoneNumberMobileFirst() {
        return phoneNumberMobileFirst;
    }

    public void setPhoneNumberMobileFirst(String phoneNumberMobileFirst) {
        this.phoneNumberMobileFirst = phoneNumberMobileFirst;
    }

    public String getPhoneNumberMobileSecond() {
        return phoneNumberMobileSecond;
    }

    public void setPhoneNumberMobileSecond(String phoneNumberMobileSecond) {
        this.phoneNumberMobileSecond = phoneNumberMobileSecond;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSkypeNickName() {
        return skypeNickName;
    }

    public void setSkypeNickName(String skypeNickName) {
        this.skypeNickName = skypeNickName;
    }

    @Override
    public String toString() {
        return
                "phoneNumberHome= " + phoneNumberHome +
                ", phoneNumberMobileFirst= " + phoneNumberMobileFirst +
                ", phoneNumberMobileSecond= " + phoneNumberMobileSecond +
                ", emailAddress= " + emailAddress +
                ", skypeNickName= " + skypeNickName+" ";
    }
}
