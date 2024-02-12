package com.nttdata.bootcamp.yankeemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class YankeeTransferEvent {
    private String message;
    private String status;
    private YankeeTransferRequest yankeeTransferRequest;
}
