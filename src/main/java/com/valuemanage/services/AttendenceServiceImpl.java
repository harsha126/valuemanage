package com.valuemanage.services;

import com.valuemanage.domain.Attendence;
import com.valuemanage.repositories.AttendenceRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AttendenceServiceImpl implements AttendenceService {
    private final AttendenceRepository attendenceRepository;

    public AttendenceServiceImpl(AttendenceRepository attendenceRepository) {
        this.attendenceRepository = attendenceRepository;
    }

    @Override
    public Attendence save(Attendence attendence) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = format.parse(format.format(new Date()));
        attendence.setDate(date);
        return attendenceRepository.save(attendence);
    }
}
