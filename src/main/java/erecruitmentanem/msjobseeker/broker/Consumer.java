package erecruitmentanem.msjobseeker.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import erecruitmentanem.msjobseeker.DTOs.CreateJobSeeker;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import erecruitmentanem.msjobseeker.services.JobSeekersService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {
    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final JobSeekersService jobSeekersService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper, JobSeekersService jobSeekersService) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.jobSeekersService = jobSeekersService;
    }

    @KafkaListener(topics = "job-seekers.create-job-seeker")
    public void consumeMessage(String message) throws JsonProcessingException {
        CreateJobSeeker createJobSeeker = objectMapper.readValue(message, CreateJobSeeker.class);
        
        CreateJobSeeker jobSeeker = modelMapper.map(createJobSeeker, CreateJobSeeker.class);
        // log.info("message consumed {}",  jobSeeker);
        jobSeekersService.createJobSeeker(jobSeeker);
    }

}
