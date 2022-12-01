package com.example.outpatientsys.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.sample.Doctor;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DoctorServiceTests {
    @Autowired
    IDoctorService doctorService;

    @Test
    public void testAddDoctor() {
        System.out.println(doctorService.getClass().getSimpleName());
        Doctor doctor = new Doctor();
        doctor.setDoctorName("zyhzyh");
        doctor.setPassword("123456");
        doctor.setTrueName("周宇航");
        doctor.setPhone("13347627204");
        doctor.setGender(1);
        int resultNum = doctorService.doctorRegister(doctor);
        System.out.println(resultNum);
    }

    @Test
    public void testQueryDoctor() {
        List<Doctor> l = doctorService.queryAllDoctor();
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).getTrueName());
        }
    }

}
