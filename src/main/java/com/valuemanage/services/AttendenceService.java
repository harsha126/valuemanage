package com.valuemanage.services;

import com.valuemanage.domain.Attendence;

import java.text.ParseException;

public interface AttendenceService {
    public Attendence save(Attendence attendence) throws ParseException;
}
