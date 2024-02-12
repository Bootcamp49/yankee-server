package com.nttdata.bootcamp.yankeemanagement.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic createClient(){
        return TopicBuilder.name("create_yankee_client")
                .build();
    }

    @Bean
    public NewTopic topicCreateMovement(){
        return TopicBuilder.name("create_movement")
                .build();
    }

    @Bean
    public NewTopic topicPayCredit(){
        return TopicBuilder.name("pay_credit")
                .build();
    }

}
