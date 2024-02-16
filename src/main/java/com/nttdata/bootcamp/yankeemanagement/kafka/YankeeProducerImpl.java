package com.nttdata.bootcamp.yankeemanagement.kafka;

import com.google.gson.Gson;
import com.nttdata.bootcamp.yankeemanagement.model.ClientEvent;
import com.nttdata.bootcamp.yankeemanagement.model.YankeeTransferEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class YankeeProducerImpl implements YankeeProducer {
    @Autowired
    private KafkaTemplate<String, ClientEvent> kafkaClientTemplate;
    @Autowired
    private NewTopic createClient;
    @Autowired
    private NewTopic topicCreateMovement;
    @Autowired
    private NewTopic topicPayCredit;
    @Autowired
    KafkaTemplate<String, YankeeTransferEvent> kafkaYankeeTemplate;
    @Override
    public void createClientMessage(ClientEvent event) {
        String eventMessage = eventToJsonString(event);
        Message<String> message = MessageBuilder
                .withPayload(eventMessage)
                .setHeader(KafkaHeaders.TOPIC, createClient.name())
                .build();
        kafkaClientTemplate.send(message);
    }

    @Override
    public void createMovementTransfer(YankeeTransferEvent event) {
        String eventMessage = eventToJsonString(event);
        Message<String> message = MessageBuilder
                .withPayload(eventMessage)
                .setHeader(KafkaHeaders.TOPIC, topicCreateMovement.name())
                .build();
        kafkaYankeeTemplate.send(message);
    }

    @Override
    public void payCreditActiveProduct(YankeeTransferEvent event) {
        String eventMessage = eventToJsonString(event);
        Message<String> message = MessageBuilder
                .withPayload(eventMessage)
                .setHeader(KafkaHeaders.TOPIC, topicPayCredit.name())
                .build();
        kafkaYankeeTemplate.send(message);
    }
    private <T>String eventToJsonString(T event){
        Gson gson = new Gson();
        return gson.toJson(event);
    };
}
