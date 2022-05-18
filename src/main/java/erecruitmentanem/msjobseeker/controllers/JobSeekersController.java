package erecruitmentanem.msjobseeker.controllers;
import erecruitmentanem.msjobseeker.DTOs.CreateJobSeeker;
import erecruitmentanem.msjobseeker.DTOs.JobSeekerDto;
import erecruitmentanem.msjobseeker.DTOs.JobSeekerLanguagesDto;
import erecruitmentanem.msjobseeker.DTOs.JobSeekerSkillsDto;
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

    @PatchMapping("{id}/skills")
    ResponseEntity<Object> updateJobSeekerSkills(@PathVariable("id") Long id , @RequestBody JobSeekerSkillsDto body){   
        return jobSeekersService.updateJobSeekerSkillsById(id , body);
    }

    @PatchMapping("{id}/languages")
    ResponseEntity<Object> updateJobSeekerLanguages(@PathVariable("id") Long id , @RequestBody JobSeekerLanguagesDto body){   
        return jobSeekersService.updateJobSeekerLanguagesById(id , body);
    }


}
