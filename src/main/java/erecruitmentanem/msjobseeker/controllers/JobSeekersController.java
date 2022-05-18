package erecruitmentanem.msjobseeker.controllers;


import erecruitmentanem.msjobseeker.entities.JobSeeker;
import erecruitmentanem.msjobseeker.repositories.JobSeekersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class JobSeekersController {


    @Autowired
    JobSeekersRepository jobSeekersRepository ;

    @PostMapping("/")
    JobSeeker createJobSeeker(@PathVariable("id") Long idf)
    {
        JobSeeker jobseeker = jobSeekersRepository.save(new JobSeeker());
        return jobseeker;
    }

    @GetMapping("/{id}")
    String getJobSeekerById(@PathVariable("id") Long idf)
    {
        return idf.toString();
    }

    @GetMapping("/show/{id}")
    String getJobSeekers(@PathVariable("id") Long idf)
    {
        return idf.toString();
    }

    @PutMapping("/update/{id}")
    String updateJobSeekers(@PathVariable("id") Long idf)
    {
        return idf.toString();
    }

    @DeleteMapping("/delete/{id}")
    String deleteJobSeekers(@PathVariable("id") Long idf)
    {
        return idf.toString();
    }

    @PatchMapping("/patch/{id}")
    String updateSkills(@PathVariable("id") Long idf)
    {
        return idf.toString();
    }

}
