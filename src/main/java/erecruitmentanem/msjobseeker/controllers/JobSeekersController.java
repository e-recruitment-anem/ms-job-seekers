package erecruitmentanem.msjobseeker.controllers;
import erecruitmentanem.msjobseeker.DTOs.CreateJobSeeker;
import erecruitmentanem.msjobseeker.DTOs.JobSeekerDto;
import erecruitmentanem.msjobseeker.DTOs.JobSeekerLanguagesDto;
import erecruitmentanem.msjobseeker.DTOs.JobSeekerSkillsDto;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.services.JobSeekersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RestController
public class JobSeekersController {


  @Autowired(required = false)
  JobSeekersService jobSeekersService;

    @GetMapping(value="hello")
    public String getMethodName() {
        return "new SomeData()";
    }
    

    @PostMapping("/create")
    ResponseEntity<Object> createJobSeeker(@RequestBody CreateJobSeeker body){   
        try {
            return jobSeekersService.createJobSeeker(body);
        } catch (Exception e) {
           return ExceptionsHandler.badRequestException();

         }
    }

    @GetMapping("{id}")
    ResponseEntity<Object> getJobSeeker(@PathVariable("id") Long id){   
        return jobSeekersService.getJobSeekerById(id);
    }



    @PutMapping("{id}")
    ResponseEntity<Object> updateJobSeeker(@PathVariable("id") Long id , @RequestBody JobSeekerDto body){   
        return jobSeekersService.updateJobSeekerById(id , body);
    }

    @GetMapping("/search")
    ResponseEntity<Object> getJobRequests(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size , @RequestBody JobSeeker request){
        return jobSeekersService.getJobSeekers(page, size, request);
    }
    @PatchMapping("{id}/skills")
    ResponseEntity<Object> updateJobSeekerSkills(@PathVariable("id") Long id , @RequestBody JobSeekerSkillsDto body){   
        return jobSeekersService.updateJobSeekerSkillsById(id , body);
    }

    @PatchMapping("{id}/languages")
    ResponseEntity<Object> updateJobSeekerLanguages(@PathVariable("id") Long id , @RequestBody JobSeekerLanguagesDto body){   
        return jobSeekersService.updateJobSeekerLanguagesById(id , body);
    }


}
