package com.example.outpatientsys.controller;

import com.example.outpatientsys.service.IDoctorService;
import com.example.outpatientsys.utils.JsonResult;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sample.Doctor;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController extends BaseController {
    @Autowired
    private IDoctorService doctorService;

    @GetMapping("/login")
    public JsonResult<Doctor> doctorLogin(String username, String password) {
        Doctor doctor = new Doctor();
        doctor.setDoctorName(username);
        doctor.setPassword(password);
        Doctor loginDoctor = doctorService.doctorLogin(doctor);
        return new JsonResult<Doctor>(OK,loginDoctor);
    }

    @PostMapping("/register")
    public JsonResult<Void> doctorRegister(String username, String password, String trueName, String phone, Long gender) {
        System.out.println(gender);
        Doctor doctor = new Doctor();
        doctor.setDoctorName(username);
        doctor.setPassword(password);
        doctor.setTrueName(trueName);
        doctor.setPhone(phone);
        doctor.setGender(gender);
        int resultNum = doctorService.doctorRegister(doctor);
        System.out.println(resultNum);
        return new JsonResult<>(OK);
    }

    @GetMapping("/getAllDoctor")
    public JsonResult<List<Doctor>> getAllDoctor(){
        List<Doctor> doctorList = doctorService.queryAllDoctor();
//        JsonArrayFormatVisitor
        return new JsonResult<List<Doctor>>(OK,doctorList);
    }

}
