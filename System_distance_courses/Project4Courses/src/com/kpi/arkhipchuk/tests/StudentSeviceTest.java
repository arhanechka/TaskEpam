package com.kpi.arkhipchuk.tests;
import com.kpi.arkhipchuk.model.dao.DaoCourse;
import com.kpi.arkhipchuk.model.dao.DaoFactory;
import com.kpi.arkhipchuk.model.dao.DaoStudent;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.services.StudentService;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
/**
 * Created by Anya on 06.07.2017.
 */
public class StudentSeviceTest {
    @Test
    public void checkStudentTest(){
        DaoStudent daoStudent = mock( DaoStudent.class);
        DaoFactory factory = mock(DaoFactory.class);
        when(factory.createStudentDao()).thenReturn( daoStudent);
        StudentService service = new StudentService(factory);
        service.checkStudent( "Test@gamil.com", "12345");
        verify(daoStudent).getStudentByEmail("Test@gamil.com", "12345");
    }
}
