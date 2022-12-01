package com.example.outpatientsys.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sample.Patient;
import java.sql.Date;

@SpringBootTest
public class PatientMapperTests {
    @Autowired
    PatientMapper patientMapper;

//单元测试不能有返回值！！
    @Test
    public void testInsertPatient() {
        Patient patient =
                new Patient("zhangsan","123",new Date(92,3,12)
                        ,"450203111","139111",1,0);

        System.out.println(patientMapper.addPatient(patient));
    }
    @Test
    public void testQueryPatientByName(){
        String patientName = "张三";
        Patient queryPatient = patientMapper.queryPatientByPatientName(patientName);
        System.out.println(queryPatient.getPatientName());

    }
//    @Test
//    public void testQueryPatientById(){
//        long patientId = 1;
//        Patient queryPatient = patientMapper.queryPatientByPatientId(patientId);
//        System.out.println(queryPatient.getPatientName());
//    }

}
