package com.valuemanage.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RetailerDTO {
    private Long id;
    private String name;
    private String businessName;
    private String phoneNumber;
    private String owner;
    
}
