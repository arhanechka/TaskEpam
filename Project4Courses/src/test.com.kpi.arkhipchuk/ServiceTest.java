package test.com.kpi.arkhipchuk;

import com.kpi.arkhipchuk.controller.Service;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.model.entity.Teacher;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Anya on 02.07.2017.
 */
public class ServiceTest {
    Service service = Service.getInstance();

    @Test
    public void checkStudentTest(){
        String studentForCheckLastName="Ivanov";
        String rightEmail = "ivashka@gmail.com";
        String rightPassword = "1111";
        String wrongEmail = "serezhka@gmail.com";
        Student studentFromBase1 = service.checkStudent(rightEmail,rightPassword);
        Student studentFromBase2 = service.checkStudent(wrongEmail,rightPassword);
        Assert.assertEquals(studentForCheckLastName, studentFromBase1.getLastName());
        Assert.assertEquals(null, studentFromBase2.getLastName());
    }
}
