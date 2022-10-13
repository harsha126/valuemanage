package com.valuemanage.api.v1.model;

import com.valuemanage.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepresentativeDTO {
    private Long id;
    private String name;
    private String businessName;
    private String phoneNumber;
    private String owner;
    private Address address;
}
