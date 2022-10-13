package com.valuemanage.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String businessName;
    @OneToOne
    private Address address;
    private String phoneNumber;
    private String owner;
    private String erp;
}
