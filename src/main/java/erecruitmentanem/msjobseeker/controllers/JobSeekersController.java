package erecruitmentanem.msjobseeker.controllers;
import erecruitmentanem.msjobseeker.DTOs.CreateJobSeeker;
import erecruitmentanem.msjobseeker.DTOs.JobSeekerDto;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import erecruitmentanem.msjobseeker.helpers.ResponseHandler;
import erecruitmentanem.msjobseeker.repositories.JobSeekersRepository;
import erecruitmentanem.msjobseeker.services.JobSeekersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobSeekersController {


  @Autowired(required = false)
  JobSeekersService jobSeekersService;

    @PostMapping
    ResponseEntity<Object> createJobSeeker(@RequestBody CreateJobSeeker body){   
        return jobSeekersService.createJobSeeker(body);
    }

    @GetMapping("{id}")
    ResponseEntity<Object> getJobSeeker(@PathVariable("id") Long id){   
        return jobSeekersService.getJobSeekerById(id);
    }

    @PutMapping("{id}")
    ResponseEntity<Object> updateJobSeeker(@PathVariable("id") Long id , @RequestBody JobSeekerDto body){   
        return jobSeekersService.updateJobSeekerById(id , body);
    }


}
