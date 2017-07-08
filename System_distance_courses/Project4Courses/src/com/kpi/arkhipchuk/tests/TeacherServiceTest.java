package com.kpi.arkhipchuk.tests;

import com.kpi.arkhipchuk.model.dao.DaoFactory;
import com.kpi.arkhipchuk.model.dao.DaoTeacher;
import com.kpi.arkhipchuk.services.TeacherService;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Anya on 06.07.2017.
 */
public class TeacherServiceTest {

    @Test
    public void testCheckTeacher(){
        DaoTeacher daoTeacher = mock(DaoTeacher.class) ;
        DaoFactory factory = mock(DaoFactory.class);
        when(factory.createTeacherDao()).thenReturn( daoTeacher);
        TeacherService teacherService = new TeacherService(factory);
        teacherService.checkTeacher("test@gmail.com", "1111");
        verify(daoTeacher).getTeacherByEmail("test@gmail.com", "1111");
    }
}
