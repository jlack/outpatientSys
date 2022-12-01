package com.example.outpatientsys.mapper;
import com.sample.Doctor;

import java.util.List;

public interface DoctorMapper {
    Doctor queryDoctorByDoctorName(String doctorName);

    int addDoctor(Doctor doctor);

    List<Doctor> queryAllDoctor();

    List<Doctor> getRosterTable();

}
