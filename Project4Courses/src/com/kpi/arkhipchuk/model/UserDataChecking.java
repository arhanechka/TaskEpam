package com.kpi.arkhipchuk.model;

/**
 * Created by Anya on 13.06.2017.
 */
public class UserDataChecking {
    public Boolean inputAndCheckData(String pattern, String inputData) {
        return inputData.matches(pattern);}
}
