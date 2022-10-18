package com.valuemanage.repositories;

import com.valuemanage.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    @Query("select d from Manager m join m.distributors d where m.id = ?1 ")
    Page<Distributor> findAllDistributors(Long man_id, Pageable pageable);

    @Query("select rep from Manager m join m.representatives rep where m.id = ?1 ")
    Page<Representative> findAllRepresentatives(Long man_id, Pageable pageable);

    @Query("select a from Manager m join m.attendances a where m.id = ?1 and a.date = ?2")
    Attendence getAttendance(Long man_id, Date date);

    @Query("select a from Manager m join m.attendances a where m.id = ?1")
    List<Attendence> getAllAttendence(Long man_id);

    @Query("select report from Manager m join m.reports report where m.id = ?1 and report.date = ?2 ")
    List<Report> findReportByDate(Long man_id, Date date);

    @Query("select rep from Manager m join m.representatives rep where m.id = ?1 and rep.id = ?2 ")
    Representative findAllReps(Long man_id, Long rep_id);

    @Query("select a from Manager m join m.representatives r join r.attendances a where m.id = ?1 and r.id = ?2 ")
    List<Attendence> findAllAttendenceOfRepresentativeById(Long man_id, Long rep_id);

    @Query("select count(rep) > 0 from Manager man join Representative rep where man.id = ?1 and rep.id = ?2")
    boolean checkForRepresentative(Long man_id, Long rep_id);
}
