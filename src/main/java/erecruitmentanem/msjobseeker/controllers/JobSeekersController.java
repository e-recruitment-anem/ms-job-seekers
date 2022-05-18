package erecruitmentanem.msjobseeker.controllers;
import erecruitmentanem.msjobseeker.DTOs.CreateJobSeeker;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import erecruitmentanem.msjobseeker.helpers.ResponseHandler;
import erecruitmentanem.msjobseeker.repositories.JobSeekersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobSeekersController {


    @Autowired
    JobSeekersRepository jobSeekersRepository ;

    @PostMapping
    ResponseEntity<Object> createJobSeeker(@RequestBody CreateJobSeeker body){   
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setIdJobSeeker(body.getIdJobSeeker());
        jobSeeker.setFirstName(body.getFirstName());
        jobSeeker.setLastName(body.getLastName());
        jobSeeker.setGender(body.getGender());
        jobSeeker.setBirthDate(body.getBirthDate());
        jobSeeker.setBirthPlace(body.getBirthPlace());
        jobSeeker.setAddress(body.getAddress());
        jobSeeker.setPostalCode(body.getPostalCode());
        jobSeeker.setResidenceCity(body.getResidenceCity());
        jobSeeker.setNationality(body.getNationality());
        jobSeeker.setPhoneNumber(body.getPhoneNumber());
        jobSeekersRepository.save(jobSeeker);
        return ResponseHandler.generateResponse("message", jobSeeker);
        
 
    }


}
