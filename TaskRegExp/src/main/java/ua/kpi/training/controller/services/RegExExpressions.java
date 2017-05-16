package ua.kpi.training.controller.services;

/**
 * Text constants for checking of regular expressions
 */
public interface RegExExpressions {
    /**
     * The {@link RegExExpressions#ALL_NAMES_REGEX} checks expression of names. The first letter must be capital, instance must contents only letters.
     */
    String ALL_NAMES_REGEX = "^[A-Z]{1}[a-z]+([-][A-Z]{1}[a-z]+)?$";
    /**
     * The {@link RegExExpressions#NICKNAME_REGEX} checks expression of nicknames. Instance can contents letters, numbers, simbols, but must not begins with special symbol.
     */
    String NICKNAME_REGEX = "^([a-z|A-Z|\\d]){3,12}$";
    /**
     * The {@link RegExExpressions#GROUP_REGEX} checks expression of groups. The expression must be equal with enum {@link ua.kpi.training.model.entity.Groups}.
     */
    String GROUP_REGEX = "Family|Work|Friends|Services|None";

    String PHONE_REGEX = "^[0][[1-9][0-9]]{2}[-][0-9]{3}([-][0-9]{2}){2}$";

    String SECOND_MOBILE = "(^[0][[1-9][0-9]]{2}[-][0-9]{3}([-][0-9]{2}){2}$)*|(none)";

    String INDEX_REGEX = "^[0-9]{5}$";

    String HOUSE_REGEX = "[0-9]+[a-zA-Z]*{1}$";

    String NUMBER_REGEX = "[0-9]+";

    String CITY_REGEX = "^[A-Z]{1}[a-z]+$";

    String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


}
