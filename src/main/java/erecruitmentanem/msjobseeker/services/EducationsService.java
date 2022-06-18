package erecruitmentanem.msjobseeker.services;

import erecruitmentanem.msjobseeker.entities.Education;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.helpers.ResponseHandler;
import erecruitmentanem.msjobseeker.repositories.EducationRepository;
import erecruitmentanem.msjobseeker.repositories.JobSeekersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationsService {

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    JobSeekersRepository jobSeekersRepository;

    public ResponseEntity<Object> createEducation(Education body, Long idJobSeeker){
        try {
            if( jobSeekersRepository.existsById(idJobSeeker) == false){
                return ExceptionsHandler.itemNotFoundException();
            }
            Education education = new Education();
            education.setTitle(body.getTitle());
            education.setSchool(body.getSchool());
            education.setStartDate(body.getStartDate());
            education.setEndDate(body.getEndDate());
            education.setJobSeeker(jobSeekersRepository.findById(idJobSeeker).get());
            educationRepository.save(education);
            return ResponseHandler.generateResponse("Education attached.", education);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getEducationsByIdJobSeeker(Long idJobSeeker){
        try {
            List<Education> educations = educationRepository.findAllByJobSeeker(jobSeekersRepository.findById(idJobSeeker).get());
            return ResponseHandler.generateResponse("Education List found.", educations);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> deleteEducation(Long idEducation){
        try {
            educationRepository.deleteById(idEducation);
            return ResponseHandler.generateResponse("Education deleted.", null);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }
    
}
