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
public class Representative {
    @javax.persistence.Id
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
    private Set<Report> reports = new HashSet<>();
    @OneToMany
    @Builder.Default
    private Set<Retailer> retailers = new HashSet<>();
    @OneToMany
    @Builder.Default
    private Set<Attendence> attendances = new HashSet<>();
    private String owner;

}
