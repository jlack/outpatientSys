package com.example.outpatientsys.service;
import com.sample.Patient;
public interface IPatientService {
    //处理用户注册
    int patientRegister(Patient patient);

    //处理用户登录
    Patient patientLogin(Patient patient);

//    //处理用户修改密码
//    void patientResetPwd(String oldPwd, String newPwd, HttpSession session);
//
//    //处理用户修改个人资料
//    void patientUpdateInfo(String phone,String email,Integer gender,String patientname,Integer uid);
//
//    //根据id查询用户信息
//    Patient queryPatientByUid(Integer uid);

}
