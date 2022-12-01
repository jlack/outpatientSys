package com.example.outpatientsys.controller;

import com.example.outpatientsys.service.IPatientService;
import com.example.outpatientsys.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sample.Patient;
import com.sample.Doctor;

@RestController
@RequestMapping("/patient")
public class PatientController extends BaseController{
    @Autowired
    private IPatientService patientService;

    @RequestMapping("/test")
    public JsonResult<Void> test(String patientName, String password){
        System.out.println("ok " + patientName);
        System.out.println("ok " + password);
        return new JsonResult<>(OK);
    }

    @PostMapping("/register")
    public JsonResult<Void> patientRegister(String username, String password,String trueName,String idNum,String phone) {
        Patient patient = new Patient();
        patient.setPatientName(username);
        patient.setPassword(password);
        patient.setTrueName(trueName);
        patient.setIdNum(idNum);
        patient.setPhone(phone);
        //执行插入操作
        int regNum = patientService.patientRegister(patient);
        System.out.println(regNum);
        return new JsonResult<>(OK);
    }
    @GetMapping("/login")
    public JsonResult<Patient> patientLogin(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        Patient patient = new Patient();
        patient.setPatientName(username);
        patient.setPassword(password);
        Patient loginPatient = patientService.patientLogin(patient);
        return new JsonResult<Patient>(OK,loginPatient);
    }
//
//    //用户登录
//    @GetMapping
//    public JsonResult<Patient> userLogin(Patient patient, HttpSession session,String code){
//        //将存储在session的kaptcha所生成的验证码取出
//        String validCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
//        //判断验证码是否一致
//        if (!validCode.equals(code)){
//            throw new ValidCodeNotMatchException("验证码错误,请重试！");
//        }
//        //执行登录操作
//        Patient loginUser = patientService.patientLogin(user);
//        //分别将用户的session保存到服务端
//        session.setAttribute("uid",loginUser.getUid());
//        session.setAttribute("username",loginUser.getUsername());
//        //优化一下传回前端的user数据，有些字段是不需要的。
//        //只将用户名和uid进行回传
//        User newUser = new User();
//        newUser.setUsername(loginUser.getUsername());
//        newUser.setUid(loginUser.getUid());
//        newUser.setGender(loginUser.getGender());
//        newUser.setPhone(loginUser.getPhone());
//        newUser.setEmail(loginUser.getEmail());
//        newUser.setAvatar(loginUser.getAvatar());
//
//        return new JsonResult<>(OK,newUser);
//    }

}
