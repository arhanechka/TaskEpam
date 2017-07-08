package com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants;

/**
 * Final class with query constants for entity student sql requests
 */
public final class StudentQueryConstants {
    public static final String STUDENT_COLUMN_ID = "st_id";
    public static final String STUDENT_COLUMN_FIRST_NAME = "st_first_name";
    public static final String STUDENT_COLUMN_LAST_NAME = "st_last_name";
    public static final String STUDENT_COLUMN_LOGIN = "st_login";
    public static final String STUDENT_COLUMN_PASSWORD = "st_password";
    public static final String STUDENT_COLUMN_EMAIL = "st_email";
    public static final String STUDENT_SELECT_BY_EMAIL_AND_PASSWORD = "SELECT * FROM student WHERE st_email = ? AND st_password = ?";
    public static final String STUDENT_SELECT_BY_EMAIL = "SELECT * FROM student WHERE st_email = ?";
    public static final String STUDENT_UPDATE_MARK_AND_COMMENT = "UPDATE stud_course_mark\n" +
            "SET mark_id = (SELECT mark_id FROM mark WHERE mark_name = ?), comment=?\n" +
            "WHERE st_id=? AND course_id=?;";
        public static final String STUDENT_INSERT_NEW_STUDENT = "INSERT INTO student (st_first_name, st_last_name, st_login, st_password, st_email) VALUES (?, ?, ?, ?, ?)";
        public static final String COURSES_HISTORY = "SELECT s.st_first_name, s.st_last_name, ma.mark_name, scm.comment FROM student s, course as c \n" +
                "join stud_course_mark as scm ON scm.course_id=c.course_id \n" +
                "join mark as ma on scm.mark_id=ma.mark_id\n" +
                "where scm.st_id=s.st_id AND NOT isnull(scm.mark_id) AND c.course_id=?;";


}
