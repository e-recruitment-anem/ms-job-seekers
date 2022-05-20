package erecruitmentanem.msjobseeker.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import erecruitmentanem.msjobseeker.DTOs.ProfessionalExperiencesDTOs.ProfessionalExperienceDto;
import erecruitmentanem.msjobseeker.entities.ProfessionalExperience;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.helpers.ResponseHandler;
import erecruitmentanem.msjobseeker.repositories.JobSeekersRepository;
import erecruitmentanem.msjobseeker.repositories.ProfessionalExperienceRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProfessionalExperiencesService {
    @Autowired
    JobSeekersRepository jobSeekersRepository;

    @Autowired
    ProfessionalExperienceRepository professionalExperienceRepository;
    
    public ResponseEntity<Object> createProfessionalExperience(Long jobSeekerId , ProfessionalExperience body){
        try {
            if(jobSeekersRepository.existsById(jobSeekerId)== false){
                return ExceptionsHandler.itemNotFoundException();
            }
            ProfessionalExperience professionalExperience = new ProfessionalExperience();
            professionalExperience.setStartDate(body.getStartDate());
            professionalExperience.setEndDate(body.getEndDate());
            professionalExperience.setIdJobTitle(body.getIdJobTitle());
            professionalExperience.setDescription(body.getDescription());
            professionalExperience.setJobSeeker(jobSeekersRepository.findById(jobSeekerId).get());
            professionalExperienceRepository.save(professionalExperience);
            return ResponseHandler.generateResponse("professional experience created successfuly.", null);
        } catch (Exception e) {
            log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getProfessionalExperience(Long id){
        try {
            if(professionalExperienceRepository.existsById(id)== false){
                return ExceptionsHandler.itemNotFoundException();
            }
            ProfessionalExperience professionalExperience = professionalExperienceRepository.findById(id).get();
            return ResponseHandler.generateResponse("professional experience found.", professionalExperience);
        } catch (Exception e) {
            log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getProfessionalExperiencesByJobSeekerId(Long id){
        try {
            if(jobSeekersRepository
            .existsById(id)== false){
                return ExceptionsHandler.itemNotFoundException();
            }
            List<ProfessionalExperience> professionalExperiences = professionalExperienceRepository.findAllByJobSeekerId(id);
            return ResponseHandler.generateResponse("professional experience found.", professionalExperiences);
        } catch (Exception e) {
            log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> updateProfessionalExperienceById(Long id , ProfessionalExperienceDto body){
        try {
            if(professionalExperienceRepository
            .existsById(id)== false){
                return ExceptionsHandler.itemNotFoundException();
            }
            ProfessionalExperience professionalExperience = professionalExperienceRepository.findById(id).get();
            professionalExperience.setStartDate(body.getStartDate());
            professionalExperience.setEndDate(body.getEndDate());
            professionalExperience.setIdJobTitle(body.getIdJobTitle());
            professionalExperience.setDescription(body.getDescription());
            professionalExperienceRepository.save(professionalExperience);
            return ResponseHandler.generateResponse("professional experience found.", professionalExperience);
        } catch (Exception e) {
            log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> deleteProfessionalExperienceById(Long id){
        try {
            if(professionalExperienceRepository
            .existsById(id)== false){
                return ExceptionsHandler.itemNotFoundException();
            }
            professionalExperienceRepository.deleteById(id);
            return ResponseHandler.generateResponse("professional experience deleted successfuly.", null);
        } catch (Exception e) {
             log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }
}
