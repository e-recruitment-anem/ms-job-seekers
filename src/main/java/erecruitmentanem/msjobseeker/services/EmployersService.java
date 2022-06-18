package erecruitmentanem.msjobseeker.services;

import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.helpers.ResponseHandler;
import erecruitmentanem.msjobseeker.repositories.EmployerRepository;
import erecruitmentanem.msjobseeker.entities.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployersService {

    @Autowired
    EmployerRepository employerRepository ;

    public ResponseEntity<Object> createEmployer(Employer body){
        try {
            Employer employer = new Employer();

            employer.setIdAccount(body.getIdAccount());
            employer.setName(body.getName());
            employer.setAgency(body.getAgency());
            employer.setRegistrationDate(body.getRegistrationDate());
            employer.setSocialRaison(body.getSocialRaison());
            employer.setMainActivity(body.getMainActivity());
            employer.setSecondaryActivity(body.getSecondaryActivity());
            employer.setLegalSector(body.getLegalSector());
            employer.setLegalStatus(body.getLegalStatus());
            employer.setActivityBranch(body.getActivityBranch());
            employer.setActivitySector(body.getActivitySector());
            employer.setCommercialRegisterNumber(body.getCommercialRegisterNumber());
            employerRepository.save(employer);
            return ResponseHandler.generateResponse("Employer Created.", employer);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }
}
