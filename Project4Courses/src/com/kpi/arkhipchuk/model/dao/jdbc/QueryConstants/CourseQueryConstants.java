package com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants;

/**
 * Created by Anya on 11.06.2017.
 */
public interface CourseQueryConstants {
    public static final String COURSE_COLUMN_ID = "course_id";
    public static final String COURSE_COLUMN_NAME = "course_name";
    public static final String COURSE_COLUMN_STATUS = "course_status";
    public static final String STUDENT_SELECT_CURRENT_COURSES = "SELECT * FROM course c \n" +
            "JOIN stud_course_mark AS scm ON scm.course_id=c.course_id \n" +
            "JOIN student AS s ON s.st_id=scm.st_id WHERE scm.st_id=s.st_id AND isnull(scm.mark_id) AND s.st_id=?;";
    public static final String STUDENT_SELECT_ACTUAL_COURSES_FOR_JOIN = "SELECT DISTINCT c.course_id, c.course_name, c.course_status FROM course c\n" +
            " JOIN stud_course_mark as scm ON c.course_id=scm.course_id \n" +
            "WHERE NOT scm.course_id IN (select course_id from stud_course_mark as scm2 where scm2.st_id=?) AND c.course_status=?;";
    public static final String STUDENT_SELECT_FINISHED_COURSES = "SELECT c.course_name, m.mark_name FROM mark m, course c \n" +
            "JOIN stud_course_mark AS scm ON scm.course_id=c.course_id\n" +
            "WHERE NOT isnull(scm.mark_id) AND scm.mark_id=m.mark_id AND scm.st_id=?;";
    public static final String STUDENT_UPDATE_FOR_JOIN_TO_NEW_COURSE = "INSERT INTO stud_course_mark " +
            "(stud_course_mark.st_id, stud_course_mark.course_id) VALUES (?, ?);";
    public static final String TEACHER_SELECT_CURRENT_COURSES = "SELECT distinct co.course_id, co.course_name, co.course_status FROM course as co\n" +
            "JOIN teacher_course AS tc ON tc.course_id=co.course_id\n" +
            "WHERE co.course_status=1 AND tc.teacher_id = ?;";
    public static final String TEACHER_SELECT_LIST_OF_STUDENTS_FOR_CURRENT_COURSES =
            "SELECT distinct s.st_id, s.st_first_name, s.st_last_name, s.st_login, " +
                    "s.st_password, s.st_email FROM student s \n" +
                    "JOIN stud_course_mark AS scm ON scm.st_id=s.st_id\n" +
                    "WHERE scm.course_id=? AND isnull(scm.mark_id);";
    public static final String TEACHER_SELECT_INACTIVE_COURSES_FOR_ACTIVATION = "SELECT * FROM course as co\n" +
            "JOIN teacher_course AS tc ON tc.course_id=co.course_id\n" +
            "WHERE co.course_status=0 AND tc.teacher_id=?;";
    public static final String TEACHER_UPDATE_COURSES_FOR_ACTIVATION = "UPDATE course as co\n" +
            "SET co.course_status=1\n" +
            "WHERE co.course_id=?;";
}
