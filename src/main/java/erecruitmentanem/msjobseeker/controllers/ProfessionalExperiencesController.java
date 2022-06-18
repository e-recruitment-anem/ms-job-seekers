package erecruitmentanem.msjobseeker.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import erecruitmentanem.msjobseeker.DTOs.ProfessionalExperiencesDTOs.ProfessionalExperienceDto;
import erecruitmentanem.msjobseeker.entities.ProfessionalExperience;
import erecruitmentanem.msjobseeker.services.ProfessionalExperiencesService;

@RestController
@RequestMapping("professional-experiences")
@CrossOrigin(origins = "*")
public class ProfessionalExperiencesController {
    @Autowired
    ProfessionalExperiencesService professionalExperiencesService;

    @PostMapping("{jobSeekerId}")
    ResponseEntity<Object> createProfessionalExperience(@PathVariable("jobSeekerId") Long jobSeekerId ,@RequestBody ProfessionalExperience body){
        return professionalExperiencesService.createProfessionalExperience(jobSeekerId , body);
    }

    @GetMapping("{id}")
    ResponseEntity<Object> getProfessionalExperienceById(@PathVariable("id") Long id){
        return professionalExperiencesService.getProfessionalExperience(id);
    }

    @GetMapping("by-job-seeker/{id}")
    ResponseEntity<Object> getProfessionalExperiencesByJobSeekerId(@PathVariable("id") Long id){
        return professionalExperiencesService.getProfessionalExperiencesByJobSeekerId(id);
    }

    @PutMapping("{id}")
    ResponseEntity<Object> updateProfessionalExperienceById(@PathVariable("id") Long id, @RequestBody ProfessionalExperienceDto body){
        return professionalExperiencesService.updateProfessionalExperienceById(id,body);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Object> deleteProfessionalExperienceById(@PathVariable("id") Long id){
        return professionalExperiencesService.deleteProfessionalExperienceById(id);
    }
}
