package com.nttdata.bootcamp.yankeemanagement.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    //En este caso la configuración del producer Factory está
    //En el config de este proyecto, no es necesario agregar la clase
    //de configuración para esto.

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
