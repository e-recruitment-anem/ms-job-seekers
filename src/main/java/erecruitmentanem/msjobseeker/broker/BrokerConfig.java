package erecruitmentanem.msjobseeker.broker;

import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@EnableKafka
@Configuration
public class BrokerConfig {

    
    private final KafkaProperties kafkaProperties;

    @Autowired
    public BrokerConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        // get configs on application.properties/yml
        Map<String, Object> properties = kafkaProperties.buildProducerProperties();
        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name("job-seekers.create-job-request")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic jobSeekerTopic() {
        return TopicBuilder
                .name("job-seekers.create-job-seeker")
                .partitions(1)
                .replicas(1)
                .build();
    }


    // ---------------- consumer ---------------
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

