package ua.kpi.training.model.entity;

/**
 * Created by Anya on 14.05.2017.
 */
public class Communications {
    /**
     * The {@link Communications#phoneNumberHome} field representing the number of member's home phone.
     */
    private String phoneNumberHome;
    /**
     * The {@link Communications#phoneNumberMobileFirst} field representing the member's first mobile number.
     */
    private String phoneNumberMobileFirst;
    /**
     * The {@link Communications#phoneNumberMobileSecond} field representing the member's second mobile number if it is exist, or none.
     */
    private String phoneNumberMobileSecond;
    /**
     * The {@link Communications#emailAddress} field representing the member's email.
     */
    private String emailAddress;
    /**
     * The {@link Communications#skypeNickName} field representing the member's skype nickname.
     */
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
