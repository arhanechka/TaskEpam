package com.kpi.arkhipchuk.tests;
import com.kpi.arkhipchuk.model.dao.DaoCourse;
import com.kpi.arkhipchuk.model.dao.DaoFactory;
import com.kpi.arkhipchuk.services.CourseService;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
/**
 * Created by Anya on 06.07.2017.
 */
public class CourseServiceTest {

    @Test
   public void getCourseByStudentIdTest(){
        DaoCourse daoCourse = mock(DaoCourse.class);
        DaoFactory factory = mock(DaoFactory.class);
        when(factory.createCourseDao()).thenReturn(daoCourse);
        CourseService service = new CourseService(factory);
        service.getCourseById(12345);
        verify(daoCourse).findCourseById(12345);
    }
}
