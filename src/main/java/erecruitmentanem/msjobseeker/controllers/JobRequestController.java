package erecruitmentanem.msjobseeker.controllers;
import erecruitmentanem.msjobseeker.entities.JobRequest;
import erecruitmentanem.msjobseeker.helpers.ExceptionsHandler;
import erecruitmentanem.msjobseeker.repositories.JobRequestRepository;
import erecruitmentanem.msjobseeker.services.JobRequestsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/job-request")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class JobRequestController {

    @Autowired(required = false)
    JobRequestsService jobRequestsService;
    @Autowired(required = false)
    JobRequestRepository jobRequestRepository;


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
    @GetMapping("/b/{idJobSeeker}")
    ResponseEntity<Object> getJobRequestByJobSeekerId(@PathVariable("idJobSeeker") Long id){
        return jobRequestsService.getJobRequestByJobSeekerId(id);
    }

    @GetMapping("/search")
    ResponseEntity<Object> getJobRequests(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size , @RequestBody JobRequest request){
        return jobRequestsService.getJobRequests(page, size, request);
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
