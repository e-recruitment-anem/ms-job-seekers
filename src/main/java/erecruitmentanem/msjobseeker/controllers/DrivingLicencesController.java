package erecruitmentanem.msjobseeker.controllers;

import erecruitmentanem.msjobseeker.entities.DrivingLicense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import erecruitmentanem.msjobseeker.services.DrivingLicencesService;

@RestController
@RequestMapping("driving-licences")
@CrossOrigin(origins = "*")
public class DrivingLicencesController{

    @Autowired
    DrivingLicencesService drivingLicencesService;

    @PostMapping("/{idJobSeeker}")
    ResponseEntity<Object> createDrivingLicense(@RequestBody DrivingLicense body, @PathVariable("idJobSeeker") Long idJobSeeker){
        return drivingLicencesService.createDrivingLicense(body,idJobSeeker);
    }

    @GetMapping("/b/{idJobSeeker}")
    ResponseEntity<Object> getDrivingLicenseByJobSeekerId(@PathVariable("idJobSeeker") Long id){
        return drivingLicencesService.getDrivingLicenseByJobSeekerId(id);
    }

    @GetMapping("/{idDrivingLicense}")
    ResponseEntity<Object> getDrivingLicenseById(@PathVariable("idDrivingLicense") Long idDrivingLicense){
        return drivingLicencesService.getDrivingLicenseById(idDrivingLicense) ;
    }

    @DeleteMapping("/{idDrivingLicense}")
    ResponseEntity<Object> deleteDrivingLicense(@PathVariable("idDrivingLicense") Long idDrivingLicense){
        return drivingLicencesService.deleteDrivingLicense(idDrivingLicense) ;
    }
}