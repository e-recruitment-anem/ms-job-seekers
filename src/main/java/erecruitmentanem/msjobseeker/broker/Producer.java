package erecruitmentanem.msjobseeker.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import erecruitmentanem.msjobseeker.entities.JobRequest;



@Slf4j
@Component
public class Producer {

    @Value("${topic.job-seekers.create-job-request}")
    private String orderTopic;


    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendJobRequest(JobRequest jobRequest) throws JsonProcessingException {

        String jobRequestAsMessage = objectMapper.writeValueAsString(jobRequest);
        kafkaTemplate.send("job-seekers.create-job-request",jobRequestAsMessage);
        log.info("job request produced {}", jobRequestAsMessage);
        return "message sent";

    }
}
