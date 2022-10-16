package com.valuemanage.repositories;

import com.valuemanage.domain.Attendence;
import com.valuemanage.domain.Report;
import com.valuemanage.domain.Representative;
import com.valuemanage.domain.Retailer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface RepresentativeRepository extends JpaRepository<Representative, Long> {


    @Query("select ret from Representative r join r.retailers ret where r.id = ?1")
    Page<Retailer> findAllRetailer(Long rep_id, Pageable pageable);

    @Query("select ret from Representative r join r.retailers ret where r.id = ?1 and ret.id = ?2")
    Page<Retailer> findRetailerById(Long rep_id, Long Ret_id, Pageable pageable);

    @Query("select report from Representative r join r.reports report where r.id = ?1 and report.date = ?2 ")
    Report findReportByDate(Long rep_id, Date date);

    @Query("select a from Representative r join r.attendances a where r.id = ?1 and a.date = ?2")
    Attendence getAttendance(Long rep_id, Date date);

    @Query("select a from Representative r join r.attendances a where r.id = ?1")
    List<Attendence> getAllAttendence(Long rep_id);

    @Query("select count(ret)>0 from Representative rep join rep.retailers ret where rep.id = ?1 and ret.id = ?2")
    Boolean checkForRetailers(Long rep_id, Long ret_id);

}
