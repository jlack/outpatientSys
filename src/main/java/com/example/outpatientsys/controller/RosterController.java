package com.example.outpatientsys.controller;

import com.example.outpatientsys.service.IDoctorService;
import com.example.outpatientsys.service.IRosterService;
import com.example.outpatientsys.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roster")
public class RosterController extends BaseController {
    @Autowired
    private IRosterService rosterService;
    @GetMapping("/getRosterTable")
    public JsonResult<List<com.sample.Roster>> getRosterTable() {
        List<com.sample.Roster> rosterList = rosterService.getRosterTable();
        return new JsonResult<List<com.sample.Roster>>(OK,rosterList);
    }
}
