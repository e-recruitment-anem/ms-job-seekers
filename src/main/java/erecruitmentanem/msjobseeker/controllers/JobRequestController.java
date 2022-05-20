package erecruitmentanem.msjobseeker.controllers;

import erecruitmentanem.msjobseeker.DTOs.JobSeekerDto;
import erecruitmentanem.msjobseeker.entities.JobRequest;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.repositories.JobRequestPaginationRepository;
import erecruitmentanem.msjobseeker.repositories.JobRequestRepository;
import erecruitmentanem.msjobseeker.services.JobRequestsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/job_request")
@Slf4j
public class JobRequestController {

    @Autowired(required = false)
    JobRequestsService jobRequestsService;
    @Autowired(required = false)
    JobRequestRepository jobRequestRepository;

    @Autowired(required = false)
    JobRequestPaginationRepository jobRequestPaginationRepository;


    @PostMapping
    ResponseEntity<Object> createJobRequest(@RequestBody JobRequest body){
        return jobRequestsService.createJobRequest(body);
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> getJobRequestById(@PathVariable("id") Long id){
        if(jobRequestRepository.existsById(id) == false){
            return ExceptionsHandler.itemNotFoundException();
        }
        return jobRequestsService.getJobRequestById(id);
    }

    @GetMapping("/list")
    List<JobRequest> getJobRequests(@RequestParam("page") int page,@RequestParam("size") int size){
        return jobRequestsService.getJobRequestsList(page,size);
    }


    @PutMapping("{id}")
    ResponseEntity<Object> updateJobRequest(@PathVariable("id") Long id , @RequestBody JobRequest body){
        return jobRequestsService.updateJobRequest(id , body);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteJobRequest(@PathVariable("id") Long id){
        return jobRequestsService.deleteJobRequest(id);
    }

}
