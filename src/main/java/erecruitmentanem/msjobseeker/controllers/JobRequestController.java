package erecruitmentanem.msjobseeker.controllers;

import erecruitmentanem.msjobseeker.entities.JobRequest;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.repositories.JobRequestPaginationRepository;
import erecruitmentanem.msjobseeker.repositories.JobRequestRepository;
import erecruitmentanem.msjobseeker.services.JobRequestsService;
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
        //List<JobRequest> jobRequest = new ArrayList<JobRequest>();
        //Pageable paging = PageRequest.of(page, size);
        //Page<JobRequest> pageJobReq = jobRequestRepository.findAll(true, paging);

        List<JobRequest> jobRequests = new ArrayList<JobRequest>();
        Pageable paging = PageRequest.of(page, size);

        Page<JobRequest> pageJobReq;
        pageJobReq = JobRequestPaginationRepository.findAll(paging);

        return pageJobReq.getContent();
        //return jobRequestsService.getJobRequestsList(page);
    }

}
