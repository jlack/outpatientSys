package com.example.outpatientsys.mapper;

import com.sample.Admin;

public interface AdminMapper {
    Admin queryAdminByAdminName(String adminName);

    int addAdmin(Admin admin);
}
