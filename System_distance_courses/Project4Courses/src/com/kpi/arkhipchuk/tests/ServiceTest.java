package com.kpi.arkhipchuk.tests;

import com.kpi.arkhipchuk.model.dao.DaoOptional;
import com.kpi.arkhipchuk.model.dao.DaoTeacher;
import com.kpi.arkhipchuk.model.dao.DaoFactory;
import com.kpi.arkhipchuk.services.Service;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

/**
 * Test class for Service testing
 */
public class ServiceTest {

    @Test
    public void testSetStudentMark(){
        DaoOptional daoOptional = mock( DaoOptional.class);
        DaoFactory factory = mock(DaoFactory.class);
        when(factory.createOptionalDao()).thenReturn( daoOptional);
        Service service = new Service(factory);
        service.setStudentMark( "A" , "Comment"  , 100500 ,  12345);
        verify(daoOptional).updateMark("A" , "Comment" , 100500 , 12345);
    }


}
