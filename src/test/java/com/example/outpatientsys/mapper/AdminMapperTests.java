package com.example.outpatientsys.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sample.Admin;

@SpringBootTest
public class AdminMapperTests {
    @Autowired
    AdminMapper adminMapper;

    @Test
    public void testAddAdmin() {
    }

    @Test
    public void testQueryAdmin() {
        Admin admin = adminMapper.queryAdminByAdminName("admin");
        System.out.println(admin.getAdminId());
    }
}
