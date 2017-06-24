package com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants;

/**
 * Created by Anya on 11.06.2017.
 */
public interface TeacherQueryConstants {
    public static final String TEACHER_COLUMN_ID = "teach_id";
    public static final String TEACHER_COLUMN_FIRST_NAME = "teach_first_name";
    public static final String TEACHER_COLUMN_LAST_NAME = "teach_last_name";
    public static final String TEACHER_COLUMN_LOGIN = "teach_login";
    public static final String TEACHER_COLUMN_PASSWORD = "teach_pasword";
    public static final String TEACHER_COLUMN_EMAIL = "teach_email";
    public static final String TEACHER_SELECT_BY_EMAIL_AND_PASSWORD = "SELECT * FROM teacher WHERE  teach_email = ? AND teach_pasword = ?";
    public static final String TEACHER_SELECT_STUDENT_LIST_FOR_CURRENT_COURSE = "SELECT s.st_first_name, s.st_last_name, co.course_name \n" +
            "FROM course as co\n" +
            "JOIN teacher_course AS tc ON tc.course_id=co.course_id \n" +
            "JOIN stud_course_mark AS scm ON co.course_id=scm.course_id\n" +
            "JOIN student AS s on scm.st_id=s.st_id \n" +
            "WHERE isnull(scm.mark_id) AND tc.teacher_id = ? AND tc.course_id=?;";
    public static final String TEACHER_UPDATE_MARK_FOR_STUDENT_FROM_CURRENT_COURSE = "UPDATE stud_course_mark\n" +
            "SET mark_id = (SELECT mark_id FROM mark WHERE mark_name = ?), comment=?\n" +
            "WHERE st_id=? AND course_id=?;";

    public static final String TEACHER_UPDATE_COURSE_STATUS = "UPDATE course\n" +
            "SET course_status = ? \n" +
            "WHERE course_id=(SELECT course_id FROM teacher_course WHERE teacher_id=?);";
    public static final String TEACHER_SELECT_HISTORY_OF_STUDENTS_FROM_FINISHED_COURSE = "SELECT s.st_first_name, s.st_last_name, c.course_name, ma.mark_name, scm.comment FROM student s, course AS c \n" +
            "JOIN stud_course_mark AS scm ON scm.course_id=c.course_id \n" +
            "JOIN mark AS ma ON scm.mark_id=ma.mark_id\n" +
            "WHERE scm.st_id=s.st_id AND NOT isnull(scm.mark_id) AND c.course_id=4";


}
