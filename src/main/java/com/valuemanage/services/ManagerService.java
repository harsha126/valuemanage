package com.valuemanage.services;

import com.valuemanage.api.v1.model.DistributorDTO;
import com.valuemanage.api.v1.model.RepresentativeDTO;
import com.valuemanage.api.v1.model.RepresentativeInfoDTO;
import com.valuemanage.domain.Attendence;
import com.valuemanage.domain.NewDistributor;
import com.valuemanage.domain.NewReport;
import com.valuemanage.domain.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public interface ManagerService {
    Page<DistributorDTO> getAllDistributors(Long man_id, Pageable pageable);

    DistributorDTO saveNewDistributor(Long man_id, NewDistributor newDistributor);

    Page<RepresentativeDTO> getAllRepresentatives(Long man_id, Pageable pageable);


    Attendence addAttendance(Long man_id, Attendence attendence) throws ParseException;

    Attendence getAttendance(Long man_id) throws ParseException;

    List<Attendence> getAllAttendence(Long man_id);

    Report saveReport(Long man_id, NewReport newReport) throws ParseException;

    List<Report> checkReport(Long man_id) throws ParseException;

    RepresentativeInfoDTO getRepresentativeById(Long man_id, Long rep_id);

    //    public List<Attendence> getAllAttendance
    boolean checkForRepresentative(Long man_id, Long rep_id);
}
