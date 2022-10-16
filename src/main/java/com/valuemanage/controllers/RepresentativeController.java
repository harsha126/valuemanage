package com.valuemanage.controllers;

import com.valuemanage.api.v1.model.RetailerDTO;
import com.valuemanage.api.v1.model.RetailerInfoDTO;
import com.valuemanage.domain.*;
import com.valuemanage.security.UserPrincipal;
import com.valuemanage.services.RepresentativeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin
@RequestMapping({"/api/v1/representatives"})
@PreAuthorize("hasRole('ROLE_REPRESENTATIVE')")
public class RepresentativeController {
    private final RepresentativeService representativeService;

    public RepresentativeController(RepresentativeService representativeService) {
        this.representativeService = representativeService;
    }

    public Long getId(){
        UserPrincipal userPrincipal  = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userPrincipal.getUser().getUid();
    }



    @GetMapping({"/retailers"})
    public ResponseEntity<?> getAllRetailers(@RequestParam(name = "size",defaultValue = "5") int size,
                                             @RequestParam(name = "page",defaultValue = "0") int page){
        return ResponseEntity.ok(representativeService.getAllRetailers(PageRequest.of(page, size),getId()));
    }

    @GetMapping({"/retailers/{ret_id}"})
    public ResponseEntity<?> getRetailersInfo(@RequestParam(name = "size",defaultValue = "5") int size,
                                                 @RequestParam(name = "page",defaultValue = "0") int page,
                                                 @PathVariable String ret_id){
        return ResponseEntity.ok(representativeService.getRetailerById(getId(),Long.parseLong(ret_id),PageRequest.of(page,size)));
    }

    @PostMapping({"/retailers/new"})
    public ResponseEntity<?> addNewRetailer( @RequestBody NewRetailer newretailer){
        return ResponseEntity.ok(representativeService.saveRetailer(getId(),newretailer));
    }

    @GetMapping({"/report"})
    public ResponseEntity<?> checkReport() throws ParseException {
        Report report = representativeService.checkReport(getId());
        if(report == null) return ResponseEntity.badRequest().body("no report");
        return ResponseEntity.ok(report);
    }
    @PostMapping({"/report/new"})
    public ResponseEntity<?> addNewReport(@RequestBody NewReport newReport) throws ParseException {
        return ResponseEntity.ok(representativeService.saveReport(getId(),newReport));
    }


    @PostMapping({"/attendance/new"})
    public ResponseEntity<?> addAttendance(@RequestBody Attendence attendence) throws ParseException {
        return ResponseEntity.ok(representativeService.addAttendance(getId(),attendence));
    }

    @GetMapping({"/attendance"})
    public ResponseEntity<?> checkAttendance() throws ParseException {
        return ResponseEntity.ok(representativeService.getAttendance(getId()));
    }

    @GetMapping({"/attendence/all"})
    public ResponseEntity<?> getAttendence(){
        return ResponseEntity.ok(representativeService.getAllAttendence(getId()));
    }




}
