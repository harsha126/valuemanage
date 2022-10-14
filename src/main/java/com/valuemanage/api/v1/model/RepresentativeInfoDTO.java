package com.valuemanage.api.v1.model;

import com.valuemanage.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RepresentativeInfoDTO {
    private Long id;
    private String name;
    private String businessName;
    private String phoneNumber;
    private String owner;
    private Set<Attendence> attendances;
    private Set<Report> reports;
    private Set<String> retailers;
}
