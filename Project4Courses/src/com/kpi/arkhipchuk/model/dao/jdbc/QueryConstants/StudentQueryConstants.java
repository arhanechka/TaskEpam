package com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants;

/**
 * Created by Anya on 11.06.2017.
 */
public interface StudentQueryConstants {
    public static final String STUDENT_COLUMN_ID = "st_id";
    public static final String STUDENT_COLUMN_FIRST_NAME = "st_first_name";
    public static final String STUDENT_COLUMN_LAST_NAME = "st_last_name";
    public static final String STUDENT_COLUMN_LOGIN = "st_login";
    public static final String STUDENT_COLUMN_PASSWORD = "st_password";
    public static final String STUDENT_COLUMN_EMAIL = "st_email";
    public static final String STUDENT_SELECT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM student WHERE st_login = ? AND st_password = ?";
        public static final String STUDENT_INSERT_NEW_STUDENT = "INSERT INTO student (first_name, last_name, login, password, email) VALUES (?, ?, ?, ?, ?)";


}
