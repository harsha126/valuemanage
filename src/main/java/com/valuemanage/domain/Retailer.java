package com.valuemanage.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Retailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String businessName;
    @OneToOne
    private Address address;
    private String phoneNumber;
    @OneToMany
    @Builder.Default
    private Set<Comment> comments = new HashSet<>();
    @OneToMany
    @Builder.Default
    private Set<Order> orders = new HashSet<>();
    private String owner;


}
