package com.valuemanage.controllers;

import com.valuemanage.api.v1.model.DistributorDTO;
import com.valuemanage.api.v1.model.RepresentativeDTO;
import com.valuemanage.api.v1.model.RepresentativeInfoDTO;
import com.valuemanage.domain.*;
import com.valuemanage.security.UserPrincipal;
import com.valuemanage.services.ManagerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
@EnableGlobalMethodSecurity(prePostEnabled = true)
@PreAuthorize("hasRole('ROLE_MANAGER')")
@RequestMapping({"/api/v1/manager"})
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    public Long getId(){
        UserPrincipal userPrincipal  = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userPrincipal.getUser().getUid();
    }

    @GetMapping("/distributors")
    public ResponseEntity<?> getAllDistributor(@RequestParam(name = "size",defaultValue = "5") int size,
                                               @RequestParam(name = "page",defaultValue = "0") int page){
        return ResponseEntity.ok(managerService.getAllDistributors(getId(), PageRequest.of(page, size)));
    }

    @PostMapping("/distributors/new")
    public ResponseEntity<?> saveNewDistributor(@RequestBody NewDistributor newDistributor){
        return ResponseEntity.ok(managerService.saveNewDistributor(getId(),newDistributor));
    }

    @GetMapping("/representatives")
    public ResponseEntity<?> getAllRepresentatives(@RequestParam(name = "size",defaultValue = "5") int size,
                                                         @RequestParam(name = "page",defaultValue = "0") int page){
        return ResponseEntity.ok(managerService.getAllRepresentatives(getId(),PageRequest.of(page, size)));
    }

    @GetMapping("/representatives/{rep_id}")
    public ResponseEntity<?> getAllReps(@PathVariable String rep_id){
        return ResponseEntity.ok(managerService.getRepresentativeById(getId(),Long.parseLong(rep_id)));
    }

    @PostMapping({"/attendance/new"})
    public ResponseEntity<?> addAttendance(@RequestBody Attendence attendence) throws ParseException {
        return ResponseEntity.ok(managerService.addAttendance(getId(),attendence));
    }

    @GetMapping({"/attendance"})
    public ResponseEntity<?> checkAttendance() throws ParseException {
        return ResponseEntity.ok(managerService.getAttendance(getId()));
    }

    @GetMapping({"/attendance/all"})
    public ResponseEntity<?> getAttendance(){
        return ResponseEntity.ok(managerService.getAllAttendence(getId()));
    }

    @GetMapping({"/report"})
    public ResponseEntity<?> checkReport() throws ParseException {
        Report report = managerService.checkReport(getId());
        if(report == null) return ResponseEntity.badRequest().body("no report");
        return ResponseEntity.ok(report);
    }

    @PostMapping({"/report/new"})
    public ResponseEntity<?> addNewReport(@RequestBody NewReport newReport) throws ParseException {
        return ResponseEntity.ok(managerService.saveReport(getId(),newReport));
    }


}
