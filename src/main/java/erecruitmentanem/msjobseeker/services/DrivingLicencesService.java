package erecruitmentanem.msjobseeker.services;

import erecruitmentanem.msjobseeker.repositories.DrivingLicenseRepository;
import erecruitmentanem.msjobseeker.entities.DrivingLicense;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.helpers.ResponseHandler;
import erecruitmentanem.msjobseeker.repositories.JobSeekersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class DrivingLicencesService {


    @Autowired
    DrivingLicenseRepository drivingLicenseRepository;

    @Autowired
    JobSeekersRepository jobSeekersRepository;

    public ResponseEntity<Object> createDrivingLicense(DrivingLicense body, Long idJobSeeker){
        try {
            if( jobSeekersRepository.existsById(idJobSeeker) == false){
                return ExceptionsHandler.itemNotFoundException();
            }
            DrivingLicense drivingLicense = new DrivingLicense();
            drivingLicense.setType(body.getType());
            drivingLicense.setStoragePath(body.getStoragePath());
            drivingLicense.setJobSeeker(jobSeekersRepository.findById(idJobSeeker).get());
            drivingLicenseRepository.save(drivingLicense);
            return ResponseHandler.generateResponse("Driving License attached.", drivingLicense);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }


    public ResponseEntity<Object> getDrivingLicenseById(Long idDrivingLicense){
        try {
            if(drivingLicenseRepository.existsById(idDrivingLicense) == false){
                return ExceptionsHandler.itemNotFoundException();
            }
            DrivingLicense drivingLicense = drivingLicenseRepository.findById(idDrivingLicense).get();
            return ResponseHandler.generateResponse("Driving License found.",drivingLicense);

        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> deleteDrivingLicense(Long idDrivingLicense){
        try {
            if(drivingLicenseRepository.existsById(idDrivingLicense) == false){
                return ExceptionsHandler.itemNotFoundException();
            }
            drivingLicenseRepository.deleteById(idDrivingLicense);
            return ResponseHandler.generateResponse("Driving License deleted.",null);

        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getDrivingLicenseByJobSeekerId(Long id){
        try{
            if(drivingLicenseRepository.existsById(id) == false){
                return ExceptionsHandler.itemNotFoundException();
            }
            JobSeeker jobSeeker = jobSeekersRepository.findById(id).get();
            List<DrivingLicense> drivingLicenses = drivingLicenseRepository.findAllByJobSeeker(jobSeeker);
            return ResponseHandler.generateResponse("driving License List found.", drivingLicenses);
        }catch (Exception e) {
            log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }



}
