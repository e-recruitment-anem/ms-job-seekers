package erecruitmentanem.msjobseeker.controllers;

import erecruitmentanem.msjobseeker.entities.Education;
import erecruitmentanem.msjobseeker.services.EducationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("educations")
@CrossOrigin(origins = "*")
public class EducationController {

    @Autowired
    EducationsService educationsService;

    @PostMapping("/{idJobSeeker}")
    ResponseEntity<Object> createEducation(@RequestBody Education body, @PathVariable("idJobSeeker") Long idJobSeeker){
        return educationsService.createEducation(body,idJobSeeker);
    }
    @GetMapping("/{idJobSeeker}")
    ResponseEntity<Object> getEducationsByIdJobSeeker(@PathVariable("idJobSeeker") Long idJobSeeker){
        return educationsService.getEducationsByIdJobSeeker(idJobSeeker);
    }
    @DeleteMapping("/{idEducation}")
    ResponseEntity<Object> deleteEducation(@PathVariable("idEducation") Long idEducation){
        return educationsService.deleteEducation(idEducation);
    }
}
