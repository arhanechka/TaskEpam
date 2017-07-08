package com.kpi.arkhipchuk.view;

/**
 * Created by Anya on 13.06.2017.
 */
public final class RegExpressions {
    public static final String ALL_NAMES_REGEX = "^[A-Z]{1}[a-z]+([-][A-Z]{1}[a-z]+)?$";
    public static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String PASSWORD_REGEX = "^[a-z0-9_-]{4,18}$";
}
