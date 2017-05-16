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
    /**
     * The {@link RegExExpressions#PHONE_REGEX} checks expression of phone number. The expression must contain only numbers and be equal tha structure: 111-111-11-11.
     */
    String PHONE_REGEX = "^[0][[1-9][0-9]]{2}[-][0-9]{3}([-][0-9]{2}){2}$";
    /**
     * The {@link RegExExpressions#SECOND_MOBILE} checks expression of second phone mobile number. The expression must contain only numbers and be equal tha structure: 111-111-11-11 if the phone exist, or word "none".
     */
    String SECOND_MOBILE = "(^[0][[1-9][0-9]]{2}[-][0-9]{3}([-][0-9]{2}){2}$)*|(none)";
    /**
     * The {@link RegExExpressions#INDEX_REGEX} checks expression of postal index. The expression must contain only 5 numbers.
     */
    String INDEX_REGEX = "^[0-9]{5}$";
    /**
     * The {@link RegExExpressions#HOUSE_REGEX} checks expression of house number. The expression must contain only numbers and one letter is possible after the number.
     */
    String HOUSE_REGEX = "[0-9]+[a-zA-Z]*{1}$";
    /**
     * The {@link RegExExpressions#NUMBER_REGEX} checks expression of appartment number. The expression must contain only numbers.
     */
    String NUMBER_REGEX = "[0-9]+";
    /**
     * The {@link RegExExpressions#CITY_REGEX} checks expression of city name. The first letter must be capital, instance must contents only letters.
     */
    String CITY_REGEX = "^[A-Z]{1}[a-z]+$";
    /**
     * The {@link RegExExpressions#EMAIL_REGEX} checks expression of email. The instance must contents 3 parts: "@" between 1 and 2 and "." between 2 and 3
     */
    String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


}
