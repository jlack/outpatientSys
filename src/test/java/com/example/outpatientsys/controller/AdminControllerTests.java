package com.example.outpatientsys.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sample.Admin;

@SpringBootTest
public class AdminControllerTests {
    @Autowired
    AdminController adminController;

    @Test
    public void testAdminLogin() {
//        Admin admin = adminController.adminLogin("admin001", "123456");
//        System.out.println(admin.getAdminId());
    }
}
