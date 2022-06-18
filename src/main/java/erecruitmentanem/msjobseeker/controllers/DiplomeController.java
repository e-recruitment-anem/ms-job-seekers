package erecruitmentanem.msjobseeker.controllers;
import  erecruitmentanem.msjobseeker.services.DiplomesService ;
import erecruitmentanem.msjobseeker.entities.Diplome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("diplome")
public class DiplomeController{

    @Autowired
    DiplomesService diplomeService;

    @PostMapping("/{idJobSeeker}")
    ResponseEntity<Object> createDiplome(@RequestBody Diplome body, @PathVariable("idJobSeeker") Long idJobSeeker){
        return diplomeService.createDiplome(body,idJobSeeker);
    }

    @GetMapping("/{idDiplome}")
    ResponseEntity<Object> getDiplomeById(@RequestBody Diplome body, @PathVariable("idDiplome") Long idDiplome){
        return diplomeService.getDiplomeById(body,idDiplome);
    }

    @GetMapping("/b/{idJobSeeker}")
    ResponseEntity<Object> getDiplomeByIdJobSeeker(@PathVariable("idJobSeeker") Long idJobSeeker){
        return diplomeService.getDiplomeByIdJobSeeker(idJobSeeker);
    }

    @DeleteMapping("/{idDiplome}")
    ResponseEntity<Object> getDiplomeById(@PathVariable("idDiplome") Long idDiplome){
        return diplomeService.deleteDiplome(idDiplome);
    }

}