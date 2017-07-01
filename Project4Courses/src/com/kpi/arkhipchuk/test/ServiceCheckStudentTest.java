package com.kpi.arkhipchuk.test;
import com.kpi.arkhipchuk.model.dao.DaoCourse;
import com.kpi.arkhipchuk.model.dao.DaoFactory;
import com.kpi.arkhipchuk.model.dao.DaoStudent;
import com.mysql.jdbc.Connection;
import com.sun.deploy.services.Service;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * Created by Anya on 28.06.2017.
 */
public class ServiceCheckStudentTest {
    @Test
    public void checkStudentTest(){
        DaoFactory daoFactory = mock(DaoFactory.class );
        DaoStudent daoStudent = mock(DaoStudent.class);
        Service service1 = mock(Service.class);
    }
}
