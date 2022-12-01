package com.example.outpatientsys.service.impl;

import com.example.outpatientsys.mapper.RosterMapper;
import com.example.outpatientsys.service.IRosterService;
import com.sample.Roster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRosterServiceImpl implements IRosterService {
    @Autowired
    RosterMapper rosterMapper;

    @Override
    public List<Roster> getRosterTable() {
        return rosterMapper.queryAllRosterTable();
    }
}
