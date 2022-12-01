package com.example.outpatientsys.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sample.Doctor;

import javax.print.Doc;
import java.sql.Date;
import java.util.List;

@SpringBootTest
public class DoctorMapperTests {
    @Autowired
    DoctorMapper doctorMapper;

    //单元测试不能有返回值！！
    @Test
    public void testAddDoctor() {
        Doctor doctor = new Doctor();
        doctor.setDoctorName("test001");
        doctor.setPassword("123456");
        doctor.setSalt("123456");
        doctor.setTrueName("周宇航");
        doctor.setPhone("13347627204");
        doctor.setGender(1);
        int resultNum = doctorMapper.addDoctor(doctor);
        System.out.println(resultNum);
    }

    @Test
    public void testQueryDoctor() {
        System.out.println(doctorMapper.queryDoctorByDoctorName("huatuo"));
    }

    @Test
    public void testQueryAllDoctor() {
        List<Doctor> list = doctorMapper.queryAllDoctor();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTrueName());
        }

    }
}
