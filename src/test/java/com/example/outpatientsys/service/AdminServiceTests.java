package com.example.outpatientsys.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sample.Admin;

@SpringBootTest
public class AdminServiceTests {
    @Autowired
    IAdminService adminService;

    @Test
    public void testAddAdmin() {
        Admin admin = new Admin();
        admin.setUsername("admin001");
        admin.setPassword("123456");
        int resultNum = adminService.adminRegister(admin);
        System.out.println(resultNum);
    }

    @Test
    public void testLoginAdmin() {
        Admin admin = new Admin();
        admin.setUsername("admin001");
        admin.setPassword("123456");
        Admin loginAdmin = adminService.adminLogin(admin);
        System.out.println(loginAdmin.getAdminId());
    }
}
