package com.example.outpatientsys.service.impl;

import com.example.outpatientsys.mapper.PatientMapper;
import com.example.outpatientsys.service.IPatientService;
import com.example.outpatientsys.service.exception.InsertException;
import com.example.outpatientsys.service.exception.UserNotExistException;
import com.example.outpatientsys.service.exception.UsernameDuplicateException;
import com.example.outpatientsys.service.exception.WrongPasswordException;
import com.example.outpatientsys.utils.PasswordEncryptedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.Patient;

import java.util.UUID;

@Service
public class IPatientServiceImpl implements IPatientService {
    @Autowired
    PatientMapper patientMapper;


    @Override
    public int patientRegister(Patient patient) {
        //需要先判断用户名是否在数据库中重复
        System.out.println("调用service层reg方法");
        Patient queryPatient = patientMapper.queryPatientByPatientName(patient.getPatientName());
        if (queryPatient != null){
            throw new UsernameDuplicateException("病人用户名已被注册");
        }
        //密码不能以明文方式存入数据库，需要进行加密操作
        //密码加密的实现： 盐值 + password + 盐值 ---> md5算法进行加密，连续加载三次 ---> 得到最终存入数据库的结果
        //盐值就是一个随机的字符串
        //记录旧密码
        String oldPassword = patient.getPassword();
        //使用UUID获取时间戳创建盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        //记录此刻的盐值，用于以后做用户登录判断
        patient.setSalt(salt);
        //进行加密操作
        String md5Password = PasswordEncryptedUtils.getPasswordByMD5(oldPassword, salt);
        //将加密后的密码设置为用户设置的密码
        patient.setPassword(md5Password);
        int addNum = patientMapper.addPatient(patient);
        if (addNum == 0){ //判断服务器或数据库执行是否出现异常
            throw new InsertException("处理用户注册过程中，服务器或数据库执行出现异常");
        }
        return addNum;
    }

    @Override
    public Patient patientLogin(Patient patient) {
        String patientName = patient.getPatientName();
        String password = patient.getPassword();
        Patient loginPatient = patientMapper.queryPatientByPatientName(patientName);
        //为空或者isDelete=1代表用户名不存在
        if (loginPatient == null || loginPatient.getIsDelete() == 1) {
            throw new UserNotExistException("该用户名账户不存在");
        }
        //取得数据库查询返回用户的盐值和密码以及删除状态
        String salt = loginPatient.getSalt();
        String databasePwd = loginPatient.getPassword();

        //对用户输入的密码进行加密
        String md5PasswordBy = PasswordEncryptedUtils.getPasswordByMD5(password, salt);

        //将加密后的字符和数据库查询的MD5进行校验
        if (!databasePwd.equals(md5PasswordBy)){
            throw new WrongPasswordException("该账户密码不正确");
        }
        return loginPatient;
    }

//    public User userLogin(User user) {
//        //用户名
//        String username = user.getUsername();
//        //用户输入的密码
//        String userPassword = user.getPassword();
//
//        //查询登录用户是否在数据库中存在
//        User loginUser = userMapper.queryUserByUsername(username);
//
//        if (loginUser == null){ //为空代表用户名不存在
//            throw new UserNotExistException("该用户名账户不存在");
//        }
//
//        //取得数据库查询返回用户的盐值和密码以及删除状态
//        String salt = loginUser.getSalt();
//        String databasePwd = loginUser.getPassword();
//        Integer deleteStatus = loginUser.getIsDelete();
//
//        //对用户输入的密码进行加密
//        String md5PasswordBy = PasswordEncryptedUtils.getPasswordByMD5(userPassword, salt);
//
//        //将加密后的字符和数据库查询的MD5进行校验
//        if (!databasePwd.equals(md5PasswordBy)){
//            throw new WrongPasswordException("该账户密码不正确");
//        }
//
//        //判断登录的用户账户是否已注销
//        if (deleteStatus == 1){
//            throw new UserNotExistException("该用户名账户不存在");
//        }
//
//        //密码正确返回查询的用户信息
//        return loginUser;
//    }
}
