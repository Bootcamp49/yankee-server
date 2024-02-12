package com.nttdata.bootcamp.yankeemanagement.controller;

import com.nttdata.bootcamp.yankeemanagement.kafka.YankeeProducer;
import com.nttdata.bootcamp.yankeemanagement.model.Client;
import com.nttdata.bootcamp.yankeemanagement.model.ClientEvent;
import com.nttdata.bootcamp.yankeemanagement.model.YankeeTransferEvent;
import com.nttdata.bootcamp.yankeemanagement.model.YankeeTransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class YankeeController {
    @Autowired
    private YankeeProducer yankeeProducer;

    @PostMapping("/createyankee")
    public Mono<String> createYankeeClient(@RequestBody Client client){
        ClientEvent event = new ClientEvent();
        event.setStatus("pending");
        event.setMessage("client status is in pending state");
        event.setClient(client);
        yankeeProducer.createClientMessage(event);
        return Mono.just("Client created successfully");
    }

    @PostMapping("/movement")
    public Mono<String> createYankeeTransfer(@RequestBody YankeeTransferRequest yankeeTransferRequest){
        YankeeTransferEvent event = new YankeeTransferEvent();
        event.setStatus("pending");
        event.setMessage("transfer status is in pending");
        event.setYankeeTransferRequest(yankeeTransferRequest);
        yankeeProducer.createMovementTransfer(event);
        return Mono.just("Transfer created successfully");
    }

    @PostMapping("/paycredit")
    public Mono<String> payCredit(@RequestBody YankeeTransferRequest yankeeTransferRequest){
        YankeeTransferEvent event = new YankeeTransferEvent();
        event.setStatus("pending");
        event.setMessage("payment status is in pending");
        event.setYankeeTransferRequest(yankeeTransferRequest);
        yankeeProducer.payCreditActiveProduct(event);
        return Mono.just("Payment credit product successfully");
    }
}