package erecruitmentanem.msjobseeker.controllers;

import erecruitmentanem.msjobseeker.entities.Employer;
import erecruitmentanem.msjobseeker.services.EmployersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("employers")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployerController {

    @Autowired
    EmployersService employersService ;

    @PostMapping("create")
    ResponseEntity<Object> createEmployer(@RequestBody Employer body){
        return employersService.createEmployer(body);
    }

}
