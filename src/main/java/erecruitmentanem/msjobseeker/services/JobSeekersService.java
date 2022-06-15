package erecruitmentanem.msjobseeker.services;
import erecruitmentanem.msjobseeker.Specifications.JobSeekerSpecification;
import erecruitmentanem.msjobseeker.entities.JobRequest;
import erecruitmentanem.msjobseeker.repositories.JobRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import erecruitmentanem.msjobseeker.DTOs.CreateJobSeeker;
import erecruitmentanem.msjobseeker.DTOs.JobSeekerDto;
import erecruitmentanem.msjobseeker.DTOs.JobSeekerLanguagesDto;
import erecruitmentanem.msjobseeker.DTOs.JobSeekerSkillsDto;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.helpers.ResponseHandler;
import erecruitmentanem.msjobseeker.repositories.JobSeekersRepository;

import java.util.List;


@Service @RequiredArgsConstructor
@Slf4j
public class JobSeekersService {
    @Autowired
    JobSeekersRepository jobSeekersRepository;

    @Autowired
    JobRequestRepository jobRequestRepository;

    @Autowired
    JobSeekerSpecification jobSeekerSpecification;

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
            System.out.println(e);
           return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getJobSeekerById(Long id){
            if(jobSeekersRepository.existsById(id) == false){
                return ExceptionsHandler.itemNotFoundException();   
            }
            JobSeeker jobSeeker = jobSeekersRepository.findById(id).get();
            return ResponseHandler.generateResponse("job seeker found.", jobSeeker);   
        }

    public ResponseEntity<Object> updateJobSeekerById(Long id ,JobSeekerDto body){
        if(jobSeekersRepository.existsById(id) == false){
            return ExceptionsHandler.itemNotFoundException();   
        }
        JobSeeker jobSeeker = jobSeekersRepository.findById(id).get();
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
        jobSeeker.setEducationalLevel(body.getEducationalLevel());
        jobSeeker.setQualificationLevel(body.getQualificationLevel());
        jobSeeker.setIdentityCardType(body.getIdentityCardType());
        jobSeeker.setIdentityCardNumber(body.getIdentityCardNumber());
        jobSeeker.setIdentityCardDelivryCity(body.getIdentityCardDelivryCity());
        jobSeeker.setIdentityCardDelivryDate(body.getIdentityCardDelivryDate());
        jobSeeker.setMilltarySituation(body.getMilltarySituation());
        jobSeeker.setFamilySituation(body.getFamilySituation());
        jobSeeker.setChildren(body.getChildren());
        jobSeeker.setMinSalary(body.getMinSalary());
        jobSeeker.setDisability(body.getDisability());
        jobSeekersRepository.save(jobSeeker);
        return ResponseHandler.generateResponse("item updated successfully.", jobSeeker);
    }

    public ResponseEntity<Object> updateJobSeekerSkillsById(Long id ,JobSeekerSkillsDto body){
        if(jobSeekersRepository.existsById(id) == false){
            return ExceptionsHandler.itemNotFoundException();   
        }
        JobSeeker jobSeeker = jobSeekersRepository.findById(id).get();
        jobSeeker.setSkills(body.getSkills());
        jobSeekersRepository.save(jobSeeker);
        return ResponseHandler.generateResponse("job seeker skills updatedSuccessfully.", jobSeeker.getSkills());
        
    }

    public ResponseEntity<Object> updateJobSeekerLanguagesById(Long id ,JobSeekerLanguagesDto body){
        if(jobSeekersRepository.existsById(id) == false){
            return ExceptionsHandler.itemNotFoundException();   
        }
        JobSeeker jobSeeker = jobSeekersRepository.findById(id).get();
        //jobSeeker.setLanguages(body.getLanguages());
        jobSeekersRepository.save(jobSeeker);
        return ResponseHandler.generateResponse("job seeker languages updatedSuccessfully.", jobSeeker.getLanguages());
        
    }


    public ResponseEntity<Object> getJobSeekers(int page, int size, JobSeeker request) {

        try {
            Page<JobSeeker> pages = null;
            if (page > -1) {

                Pageable paging = PageRequest.of(page, size);
                pages = jobSeekersRepository.findAll( jobSeekerSpecification.getJobSeekers(request),paging);
            }
            return ResponseHandler.generateResponse("Get JobSeekers List.", pages);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseHandler.generateResponse("Bad Request.", e);
        }

    }
}
