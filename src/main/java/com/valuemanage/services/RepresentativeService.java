package com.valuemanage.services;

import com.valuemanage.api.v1.model.RetailerDTO;
import com.valuemanage.api.v1.model.RetailerInfoDTO;
import com.valuemanage.domain.Attendence;
import com.valuemanage.domain.NewReport;
import com.valuemanage.domain.NewRetailer;
import com.valuemanage.domain.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface RepresentativeService {


//    public

    Page<RetailerDTO> getAllRetailers(Pageable pageable, Long rep_id);

    Page<RetailerInfoDTO> getRetailerById(Long rep_id, Long ret_id, Pageable pageable);

    RetailerDTO saveRetailer(Long rep_id, NewRetailer newretailer);

    //    public Report saveReport(Long rep_id,Report report) throws ParseException;
    Report saveReport(Long rep_id, NewReport newReport) throws ParseException;

    List<Report> checkReport(Long rep_id) throws ParseException;

    Attendence addAttendance(Long rep_id, Attendence attendence) throws ParseException;

    Attendence getAttendance(Long rep_id) throws ParseException;

    List<Attendence> getAllAttendence(Long rep_id);

    boolean checkForRetailers(Long rep_id, Long ret_id);

    Pair<Date, Date> getDateRange(Date date);
}
