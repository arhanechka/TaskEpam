package ua.kpi.training.controller.services;

/**
 * Created by Anya on 15.05.2017.
 */
public interface RegExExpressions {
    String ALL_NAMES_REGEX = "^[A-Z]{1}[a-z]+([-][A-Z]{1}[a-z]+)?$";

    String NICKNAME_REGEX = "^([a-z|A-Z|\\d]){3,12}$";

    String GROUP_REGEX = "Family|Work|Friends|Services|None";

    String PHONE_REGEX = "^[0][[1-9][0-9]]{2}[-][0-9]{3}([-][0-9]{2}){2}$";

    String SECOND_MOBILE = "(^[0][[1-9][0-9]]{2}[-][0-9]{3}([-][0-9]{2}){2}$)*|(none)";

    String INDEX_REGEX = "^[0-9]{5}$";

    String HOUSE_REGEX = "[0-9]+[a-zA-Z]*{1}$";

    String NUMBER_REGEX = "[0-9]+";

    String CITY_REGEX = "^[A-Z]{1}[a-z]+$";

    String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


}
