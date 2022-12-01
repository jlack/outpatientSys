package com.example.outpatientsys.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RosterServiceTests {
    @Autowired
    IRosterService rosterService;
    @Test
    public void testQueryAllRosterTable() {
        List<com.sample.Roster> l = rosterService.getRosterTable();
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).getRosterTime());
        }
    }
}
