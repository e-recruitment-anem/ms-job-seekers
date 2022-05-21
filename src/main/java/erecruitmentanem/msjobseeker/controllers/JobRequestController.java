package erecruitmentanem.msjobseeker.controllers;
import erecruitmentanem.msjobseeker.entities.JobRequest;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.repositories.JobRequestPaginationRepository;
import erecruitmentanem.msjobseeker.repositories.JobRequestRepository;
import erecruitmentanem.msjobseeker.services.JobRequestsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
// use - instead of _
@RequestMapping("/job_request") 
@Slf4j
public class JobRequestController {

    @Autowired(required = false)
    JobRequestsService jobRequestsService;
    @Autowired(required = false)
    JobRequestRepository jobRequestRepository;
    @Autowired(required = false)
    JobRequestPaginationRepository jobRequestPaginationRepository;


    @PostMapping("/{idJobSeeker}")
    ResponseEntity<Object> createJobRequest(@RequestBody JobRequest body,@PathVariable("idJobSeeker") Long idJobSeeker){
        return jobRequestsService.createJobRequest(body,idJobSeeker);
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> getJobRequestById(@PathVariable("id") Long id){
        if(jobRequestRepository.existsById(id) == false){
            return ExceptionsHandler.itemNotFoundException();
        }
        return jobRequestsService.getJobRequestById(id);
    }


    @GetMapping("/list")
    Page<JobRequest> getJobRequests(@RequestParam("page") int page,@RequestParam("size") int size ,@RequestBody JobRequest request){
        return jobRequestsService.getJobRequests(page,size ,request);
    }


    @PutMapping("{id}")
    ResponseEntity<Object> updateJobRequest(@PathVariable("id") Long id , @RequestBody JobRequest body){
        return jobRequestsService.updateJobRequest(id , body);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteJobRequest(@PathVariable("id") Long id){
        return jobRequestsService.deleteJobRequestById(id);
    }

}
