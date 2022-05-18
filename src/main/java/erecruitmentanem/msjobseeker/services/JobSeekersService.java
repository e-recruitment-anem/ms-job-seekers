package erecruitmentanem.msjobseeker.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import erecruitmentanem.msjobseeker.DTOs.CreateJobSeeker;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.helpers.ResponseHandler;
import erecruitmentanem.msjobseeker.repositories.JobSeekersRepository;

@Service
public class JobSeekersService {
    @Autowired(required = false)
    JobSeekersRepository jobSeekersRepository;

    @Autowired(required = false)
    ResponseHandler responseHandler;

    @Autowired(required = false)
    ExceptionsHandler exceptionsHandler;

    public ResponseEntity<Object> createJobSeeker(CreateJobSeeker body){
        try {
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
        } catch (Exception e) {
           return exceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getJobSeekerById(Long id){
            if(jobSeekersRepository.existsById(id) == false){
                return exceptionsHandler.itemNotFoundException();   
            }
            JobSeeker jobSeeker = jobSeekersRepository.findById(id).get();
            return responseHandler.generateResponse("job seeker found.", jobSeeker);   
       
        }


}
