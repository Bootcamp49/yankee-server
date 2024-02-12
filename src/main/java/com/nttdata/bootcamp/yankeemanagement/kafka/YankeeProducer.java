package com.nttdata.bootcamp.yankeemanagement.kafka;

import com.nttdata.bootcamp.yankeemanagement.model.ClientEvent;
import com.nttdata.bootcamp.yankeemanagement.model.YankeeTransferEvent;

public interface YankeeProducer {
    void createClientMessage(ClientEvent event);

    void createMovementTransfer(YankeeTransferEvent event);

    void payCreditActiveProduct(YankeeTransferEvent event);
}
