package com.example.outpatientsys.service.impl;

import com.example.outpatientsys.mapper.DoctorMapper;
import com.example.outpatientsys.mapper.PatientMapper;
import com.example.outpatientsys.service.IDoctorService;
import com.example.outpatientsys.service.exception.InsertException;
import com.example.outpatientsys.service.exception.UserNotExistException;
import com.example.outpatientsys.service.exception.UsernameDuplicateException;
import com.example.outpatientsys.utils.PasswordEncryptedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.Doctor;

import java.util.List;
import java.util.UUID;

@Service
public class IDoctorServiceImpl implements IDoctorService {
    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public int doctorRegister(Doctor doctor) {
        System.out.println("doctor注册的service层");
        Doctor queryDoctor = doctorMapper.queryDoctorByDoctorName(doctor.getDoctorName());
        if (queryDoctor != null) {
            throw new UsernameDuplicateException("医师用户名已被注册");
        }
        String oldPassword = doctor.getPassword();
        //使用UUID获取时间戳创建盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        //记录此刻的盐值，用于以后做用户登录判断
        doctor.setSalt(salt);
        //进行加密操作
        String md5Password = PasswordEncryptedUtils.getPasswordByMD5(oldPassword, salt);
        //将加密后的密码设置为用户设置的密码
        doctor.setPassword(md5Password);
        int addNum = doctorMapper.addDoctor(doctor);
        if (addNum == 0) { //判断服务器或数据库执行是否出现异常
            throw new InsertException("处理用户注册过程中，服务器或数据库执行出现异常");
        }
        return addNum;
    }

    @Override
    public Doctor doctorLogin(Doctor doctor) {
        String doctorName = doctor.getDoctorName();
        String password = doctor.getPassword();
        Doctor loginDoctor = doctorMapper.queryDoctorByDoctorName(doctorName);
        //为空或者isDelete=1代表用户名不存在
        if (loginDoctor == null || loginDoctor.getIsDelete() == 1) {
            throw new UserNotExistException("该用户名账户不存在");
        }
        return null;
    }

    @Override
    public List<Doctor> queryAllDoctor() {
        return doctorMapper.queryAllDoctor();
    }

    @Override
    public List<Doctor> getRosterTable() {
        return doctorMapper.getRosterTable();
    }


}
