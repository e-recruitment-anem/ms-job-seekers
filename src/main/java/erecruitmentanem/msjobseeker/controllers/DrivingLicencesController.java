package erecruitmentanem.msjobseeker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erecruitmentanem.msjobseeker.services.DrivingLicencesService;

@RestController
@RequestMapping("driving-licences")
public class DrivingLicencesController{

    @Autowired
    DrivingLicencesService drivingLicencesService;

    // @GetMapping("{id}")

}