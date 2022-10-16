package com.valuemanage.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long metTotal;
    private Long metNew;
    private Long metOld;
    private Long orders;
    private Date date;
    @OneToOne
    private Comment comment;
}
