package com.nttdata.bootcamp.yankeemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String cellPhoneNumber;
    private String imei;
    private String email;
}
