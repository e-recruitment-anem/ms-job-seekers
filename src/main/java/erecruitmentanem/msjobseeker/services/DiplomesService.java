package erecruitmentanem.msjobseeker.services;

import erecruitmentanem.msjobseeker.entities.Diplome;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.helpers.ResponseHandler;
import erecruitmentanem.msjobseeker.repositories.DiplomeRepository;
import erecruitmentanem.msjobseeker.repositories.JobSeekersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DiplomesService {

    @Autowired
    DiplomeRepository diplomeRepository;

    @Autowired
    JobSeekersRepository jobSeekersRepository;

    public ResponseEntity<Object> createDiplome(Diplome body, Long idJobSeeker){
        try {
            if( jobSeekersRepository.existsById(idJobSeeker) == false){
                return ExceptionsHandler.itemNotFoundException();
            }
            Diplome diplome = new Diplome();
            diplome.setTitle(body.getTitle());
            diplome.setStoragePath(body.getStoragePath());
            diplome.setJobSeeker(jobSeekersRepository.findById(idJobSeeker).get());
            diplomeRepository .save(diplome);
            return ResponseHandler.generateResponse("Diplome attached.", diplome);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getDiplomeById(Diplome body, Long idDiplome){
        try {
            if( diplomeRepository.existsById(idDiplome) == false){
                return ExceptionsHandler.itemNotFoundException();
            }
            Diplome diplome = diplomeRepository.findById(idDiplome).get();
            return ResponseHandler.generateResponse("diplome found.", diplome);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> deleteDiplome(Long idDiplome){
        try {
            if( diplomeRepository.existsById(idDiplome) == false){
                return ExceptionsHandler.itemNotFoundException();
            }
            diplomeRepository.deleteById(idDiplome);
            return ResponseHandler.generateResponse("diplome deleted.", null);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }




    public ResponseEntity<Object> getDiplomeByIdJobSeeker(Long idJobSeeker){
        try{
            if(jobSeekersRepository.existsById(idJobSeeker) == false){
               // return ExceptionsHandler.itemNotFoundException();
            }
            JobSeeker jobSeeker = jobSeekersRepository.findById(idJobSeeker).get();
            List<Diplome> diplomes = diplomeRepository.findAllByJobSeeker(jobSeeker);
            return ResponseHandler.generateResponse("Diplomes List found.", diplomes);
        }catch (Exception e) {
            log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }
}
