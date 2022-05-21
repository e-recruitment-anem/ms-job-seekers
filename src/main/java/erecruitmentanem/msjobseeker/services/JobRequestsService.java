package erecruitmentanem.msjobseeker.services;
import erecruitmentanem.msjobseeker.Specifications.JobRequestSpecification;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

    @Autowired
    private JobRequestSpecification jobRequestSpecification;

    //@Value("${pagination.page.size.default}")
    //private Integer defaultPageSize;

    public ResponseEntity<Object> createJobRequest(JobRequest body,Long idJobSeeker){
        try {
            if(jobRequestRepository.existsById(idJobSeeker) == false){
                return ExceptionsHandler.itemNotFoundException();
            }
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
            jobRequest.setTraining(body.getTraining());
            jobRequest.setJobSeeker(new JobSeeker());
            jobRequest.setJobSeeker(jobSeekerRepository.findById(idJobSeeker).get());
            jobRequestRepository.save(jobRequest);
            return ResponseHandler.generateResponse("job request created ", jobRequest);
        } catch (Exception e) {
            //log.info(String.valueOf(e));
            System.out.println(e);
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

    public Page<JobRequest> getJobRequests(int page,int size,JobRequest request) {
        //try {

            List<JobRequest> list = null;
            Page<JobRequest> pages = null;
            if (page == 1) {
                Pageable paging = PageRequest.of(page , size );
                pages = new PageImpl<>(jobRequestRepository.findAll(jobRequestSpecification.getJobRequests(request)));
             } 
            return pages;
    }

    public ResponseEntity<Object> deleteJobRequestById(Long id) {
        try{
            jobRequestRepository.deleteById(id);
            return ResponseHandler.generateResponse("job request deleted.",null);
        }catch (Exception e) {
            log.info(String.valueOf(e));
            return ExceptionsHandler.badRequestException();
        }
    }



    

    }
