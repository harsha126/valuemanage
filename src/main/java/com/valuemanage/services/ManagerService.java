package com.valuemanage.services;

import com.valuemanage.api.v1.model.DistributorDTO;
import com.valuemanage.api.v1.model.RepresentativeDTO;
import com.valuemanage.api.v1.model.RepresentativeInfoDTO;
import com.valuemanage.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public interface ManagerService {
    public Page<DistributorDTO> getAllDistributors(Long man_id,Pageable pageable);
    public DistributorDTO saveNewDistributor(Long man_id, NewDistributor newDistributor);

    public Page<RepresentativeDTO> getAllRepresentatives(Long man_id,Pageable pageable);


    public Attendence addAttendance(Long man_id, Attendence attendence) throws ParseException;

    public Attendence getAttendance(Long man_id) throws ParseException;

    public List<Attendence> getAllAttendence(Long man_id) ;

    public Report saveReport(Long man_id, NewReport newReport) throws ParseException;
    public Report checkReport(Long man_id) throws ParseException;
    public RepresentativeInfoDTO getRepresentativeById(Long man_id,Long rep_id);
}
