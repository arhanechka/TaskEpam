package com.kpi.arkhipchuk.model.dao;

import com.kpi.arkhipchuk.model.entity.Course;

import java.util.List;
import java.util.Map;

/**
 * Created by Anya on 07.06.2017.
 */
public interface DaoCourse extends GenericDao <Course> {
    public void update(int currentStudentId, int courseId);
    public Map<String, String> findMap(int... key);
    public void joinNewCourse(int currentStudentId, int courseId);
    public List<Course> findAllCurrentCoursesForStudent(int id);
    public List<Course> findAllAccessableCoursesForStudent(int studentId, int status);
    public List<Course> findAllCurrentCoursesForTeacher(int id);
    public List<Course> findAllAccessableCoursesForTeacher(int id);
    public Course findCourseById(int id);
}
