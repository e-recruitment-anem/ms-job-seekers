package erecruitmentanem.msjobseeker.services;

import erecruitmentanem.msjobseeker.DTOs.CreateJobSeeker;
import erecruitmentanem.msjobseeker.entities.JobRequest;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.helpers.ResponseHandler;
import erecruitmentanem.msjobseeker.repositories.JobRequestRepository;
import erecruitmentanem.msjobseeker.repositories.JobSeekersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
@Slf4j
public class JobRequestsService {

    @Autowired
    JobRequestRepository jobRequestRepository;
    @Autowired
    JobSeekersRepository jobSeekerRepository;



    public ResponseEntity<Object> createJobRequest(JobRequest body){
        try {
            JobRequest jobRequest = new JobRequest();
            jobRequest.setAgency(body.getAgency());
            jobRequest.setAdmin(body.getAdmin());
            jobRequest.setAvalibility(body.getAvalibility());
            jobRequest.setDate(body.getDate());
            jobRequest.setDeviceEligibility(body.getDeviceEligibility());
            jobRequest.setLearning(body.getLearning());
            jobRequest.setMobility(body.getMobility());
            jobRequest.setNightWork(body.getNightWork());
            jobRequest.setReason(body.getReason());
            jobRequest.setJobSeeker(new JobSeeker());
            jobRequest.setJobSeeker(jobSeekerRepository.findById(1L).get());
            jobRequestRepository.save(jobRequest);
            return ResponseHandler.generateResponse("message", jobRequest);
        } catch (Exception e) {
            log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }


    public ResponseEntity<Object> getJobRequestById(Long id){
        try{
            JobRequest jobRequest = (JobRequest) jobRequestRepository.findById(id).get();
            return ResponseHandler.generateResponse("job seeker found.", jobRequest);
        }catch (Exception e) {
            log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }

    public String getJobRequestsList(Number page) {
        try {
            //JobRequest jobRequest = (JobRequest) jobRequestRepository.findAllByPage(page);
            return "Hello World";
            //ResponseHandler.generateResponse("job seeker found.", jobRequest);
        } catch (Exception e) {
            log.info(String.valueOf(e));
            return "ExceptionsHandler.badRequestException()";
        }
    }

    }
