package com.example.outpatientsys.service;

import com.sample.Admin;

public interface IAdminService {
    //处理管理员登录
    Admin adminLogin(Admin admin);

    int adminRegister(Admin admin);
}
