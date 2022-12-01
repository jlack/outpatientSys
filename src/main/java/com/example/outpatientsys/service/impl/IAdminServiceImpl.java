package com.example.outpatientsys.service.impl;

import com.example.outpatientsys.mapper.AdminMapper;
import com.example.outpatientsys.service.IAdminService;
import com.example.outpatientsys.service.exception.InsertException;
import com.example.outpatientsys.service.exception.UserNotExistException;
import com.example.outpatientsys.service.exception.UsernameDuplicateException;
import com.example.outpatientsys.service.exception.WrongPasswordException;
import com.example.outpatientsys.utils.PasswordEncryptedUtils;
import com.sample.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IAdminServiceImpl implements IAdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin adminLogin(Admin admin) {
        String userName = admin.getUsername();
        String password = admin.getPassword();
        Admin loginAdmin = adminMapper.queryAdminByAdminName(userName);
        //为空或者isDelete=1代表用户名不存在
        if (loginAdmin == null) {
            throw new UserNotExistException("该用户名账户不存在");
        }
        //取得数据库查询返回用户的盐值和密码以及删除状态
        String salt = loginAdmin.getSalt();
        String databasePwd = loginAdmin.getPassword();

        //对用户输入的密码进行加密
        String md5PasswordBy = PasswordEncryptedUtils.getPasswordByMD5(password, salt);

        //将加密后的字符和数据库查询的MD5进行校验
        if (!databasePwd.equals(md5PasswordBy)){
            throw new WrongPasswordException("该账户密码不正确");
        }
        return loginAdmin;
    }

    @Override
    public int adminRegister(Admin admin) {
        System.out.println("调用admin的service层reg方法");
        Admin queryAdmin = adminMapper.queryAdminByAdminName(admin.getUsername());
        if (queryAdmin != null){
            throw new UsernameDuplicateException("管理员用户名已被注册");
        }
        String oldPassword = admin.getPassword();
        //使用UUID获取时间戳创建盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        //记录此刻的盐值，用于以后做用户登录判断
        admin.setSalt(salt);
        //进行加密操作
        String md5Password = PasswordEncryptedUtils.getPasswordByMD5(oldPassword, salt);
        //将加密后的密码设置为用户设置的密码
        admin.setPassword(md5Password);
        int addNum = adminMapper.addAdmin(admin);
        if (addNum == 0){ //判断服务器或数据库执行是否出现异常
            throw new InsertException("处理用户注册过程中，服务器或数据库执行出现异常");
        }
        return addNum;
    }
}
