package com.valuemanage.api.v1.model;

import com.valuemanage.domain.Comment;
import com.valuemanage.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RetailerInfoDTO {
    private Long id;
    private String name;
    private String businessName;
    private String phoneNumber;
    private String owner;
    private Set<Comment> comments;
    private Set<Order> orders;
}
