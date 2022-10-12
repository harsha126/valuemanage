package com.valuemanage.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewReport {
    private Long metTotal;
    private Long metNew;
    private Long metOld;
    private Long orders;
    private Date reportDate;
    private String name;
    private String text;
    private Date commentDate;

}
