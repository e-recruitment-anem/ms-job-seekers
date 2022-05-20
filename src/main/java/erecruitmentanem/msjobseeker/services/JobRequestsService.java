package erecruitmentanem.msjobseeker.services;

import erecruitmentanem.msjobseeker.DTOs.CreateJobSeeker;
import erecruitmentanem.msjobseeker.DTOs.JobSeekerDto;
import erecruitmentanem.msjobseeker.entities.JobRequest;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.helpers.ResponseHandler;
import erecruitmentanem.msjobseeker.repositories.JobRequestPaginationRepository;
import erecruitmentanem.msjobseeker.repositories.JobRequestRepository;
import erecruitmentanem.msjobseeker.repositories.JobSeekersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor
@Slf4j
public class JobRequestsService {

    @Autowired
    JobRequestRepository jobRequestRepository;
    @Autowired
    JobSeekersRepository jobSeekerRepository;
    @Autowired
    JobRequestPaginationRepository jobRequestPaginationRepository;




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
            return ResponseHandler.generateResponse("job request created ", jobRequest);
        } catch (Exception e) {
            log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }


    public ResponseEntity<Object> getJobRequestById(Long id){
        try{
            JobRequest jobRequest = (JobRequest) jobRequestRepository.findById(id).get();
            return ResponseHandler.generateResponse("job request found.", jobRequest);
        }catch (Exception e) {
            log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> updateJobRequest(Long id , JobRequest body){
        if(jobRequestRepository.existsById(id) == false){
            return ExceptionsHandler.itemNotFoundException();
        }
        JobRequest jobRequest = jobRequestRepository.findById(id).get();
        jobRequest.setNightWork(body.getNightWork());
        jobRequest.setReason(body.getReason());
        jobRequest.setMobility(body.getMobility());
        jobRequest.setLearning(body.getLearning());
        jobRequest.setAdmin(body.getAdmin());
        jobRequest.setDeviceEligibility(body.getDeviceEligibility());
        jobRequest.setAvalibility(body.getAvalibility());
        jobRequest.setAgency(body.getAgency());
        jobRequest.setTeamWork(body.getTeamWork());
        jobRequest.setStatus(body.getStatus());
        jobRequest.setRecycling(body.getRecycling());
        jobRequest.setTraining(body.getTraining());
        return ResponseHandler.generateResponse("job request updated successfully.", jobRequest);
    }

    public List<JobRequest> getJobRequestsList(int page,int size) {
        try {
            Pageable paging = PageRequest.of(page, size);

            Page<JobRequest> pageJobReq;
            pageJobReq = jobRequestPaginationRepository.findAll(paging);
            return pageJobReq.getContent();
        } catch (Exception e) {
            log.info(String.valueOf(e));
            return (List<JobRequest>) ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> deleteJobRequest(Long id) {
        try{
            jobRequestRepository.deleteById(id);
            return ResponseHandler.generateResponse("job request deleted.",null);
        }catch (Exception e) {
            log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }


    }
