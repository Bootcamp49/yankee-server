package com.nttdata.bootcamp.yankeemanagement.kafka;

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
    KafkaTemplate<String, ClientEvent> kafkaClientTemplate;
    @Autowired
    NewTopic createClient;
    @Autowired
    NewTopic topicCreateMovement;
    @Autowired
    NewTopic topicPayCredit;

    KafkaTemplate<String, YankeeTransferEvent> kafkaYankeeTemplate;

    @Override
    public void createClientMessage(ClientEvent event) {
        Message<ClientEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, createClient.name())
                .build();
        kafkaClientTemplate.send(message);
    }

    @Override
    public void createMovementTransfer(YankeeTransferEvent event) {
        Message<YankeeTransferEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topicCreateMovement.name())
                .build();
        kafkaYankeeTemplate.send(message);
    }

    @Override
    public void payCreditActiveProduct(YankeeTransferEvent event) {
        Message<YankeeTransferEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topicPayCredit.name())
                .build();
        kafkaYankeeTemplate.send(message);
    }
}
