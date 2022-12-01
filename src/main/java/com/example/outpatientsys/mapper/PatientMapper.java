package com.example.outpatientsys.mapper;
import com.sample.Patient;

import java.util.List;

public interface PatientMapper {
    //mapper中包含patient的
    //1.注册功能 addPatient()
    //2.修改病人个人信息 updatePatientInfo()
    //3.查询病人诊断结果 涉及appointment表联查
    //4.登录时进行校验，即通过patient_name查询病人密码是否符合 queryPatientByPatientName()
    int addPatient(Patient patient);

    Patient updatePatientInfo(Patient patient);

    Patient queryPatientByPatientName(String patientName);

    Patient queryPatientByPatientId(long patientId);

    List<Patient> queryAllPatient();
}
