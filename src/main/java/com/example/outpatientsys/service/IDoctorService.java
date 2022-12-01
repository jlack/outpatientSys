package com.example.outpatientsys.service;
import com.sample.Doctor;
import com.sample.Patient;

import java.util.List;

public interface IDoctorService {
    //处理用户注册
    int doctorRegister(Doctor doctor);

    //处理用户登录
    Doctor doctorLogin(Doctor doctor);

    List<Doctor> queryAllDoctor();

    List<Doctor> getRosterTable();
}
