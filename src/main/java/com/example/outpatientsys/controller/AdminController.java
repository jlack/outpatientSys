package com.example.outpatientsys.controller;

import com.example.outpatientsys.service.IAdminService;
import com.example.outpatientsys.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sample.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Autowired
    IAdminService adminService;

    @GetMapping("/login")
    public JsonResult<Admin> adminLogin(String username, String password) {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        Admin loginAdmin = adminService.adminLogin(admin);
        return new JsonResult<Admin>(OK,loginAdmin);
    }


}
