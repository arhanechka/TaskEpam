package com.kpi.arkhipchuk.view;

/**
 * Created by Anya on 13.06.2017.
 */
public interface RegEaxpressions {
    String ALL_NAMES_REGEX = "^[A-Z]{1}[a-z]+([-][A-Z]{1}[a-z]+)?$";
    String NICKNAME_REGEX = "^([a-z|A-Z|\\d]){3,12}$";
    String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String PASSWORD_REGEX = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
}
