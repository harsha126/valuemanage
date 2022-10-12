package com.valuemanage.services;

import com.valuemanage.api.v1.model.RetailerDTO;
import com.valuemanage.api.v1.model.RetailerInfoDTO;
import com.valuemanage.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;

public interface RepresentativeService {


//    public

    public Page<RetailerDTO> getAllRetailers(Pageable pageable,Long rep_id);
    public Page<RetailerInfoDTO> getRetailerById(Long ret_id,Long rep_id,Pageable pageable);
    public RetailerDTO saveRetailer(Long rep_id, NewRetailer newretailer);
//    public Report saveReport(Long rep_id,Report report) throws ParseException;
    public Report saveReport(Long rep_id, NewReport newReport) throws ParseException;
    public Report checkReport(Long rep_id) throws ParseException;

    public Attendence addAttendance(Long rep_id,Attendence attendence) throws ParseException;

    public Attendence getAttendance(Long rep_id) throws ParseException;
}
