package com.valuemanage.controllers;

import com.valuemanage.api.v1.model.RetailerDTO;
import com.valuemanage.api.v1.model.RetailerInfoDTO;
import com.valuemanage.domain.*;
import com.valuemanage.services.RepresentativeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping({"/api/v1/representatives"})
public class RepresentativeController {
    private final RepresentativeService representativeService;

    public RepresentativeController(RepresentativeService representativeService) {
        this.representativeService = representativeService;
    }



    @GetMapping({"/{rep_id}/retailers"})
    public Page<RetailerDTO> getAllRetailers(@RequestParam(name = "size",defaultValue = "5") int size,
                                             @RequestParam(name = "page",defaultValue = "0") int page,
                                             @PathVariable String rep_id){
        return representativeService.getAllRetailers(PageRequest.of(page, size),Long.parseLong(rep_id));
    }

    @GetMapping({"/{rep_id}/retailers/{ret_id}"})
    public Page<RetailerInfoDTO> getAllRetailers(@RequestParam(name = "size",defaultValue = "5") int size,
                                                 @RequestParam(name = "page",defaultValue = "0") int page,
                                                 @PathVariable String rep_id,
                                                 @PathVariable String ret_id){
        return representativeService.getRetailerById(Long.parseLong(rep_id),Long.parseLong(ret_id),PageRequest.of(page,size));
    }

    @PostMapping({"/{rep_id}/retailers/new"})
    public RetailerDTO addNewRetailer(@PathVariable String rep_id, @RequestBody NewRetailer newretailer){
        return representativeService.saveRetailer(Long.parseLong(rep_id),newretailer);
    }

    @GetMapping({"/{rep_id}/report/"})
    public Report checkReport(@PathVariable String rep_id) throws ParseException {
        Report report = representativeService.checkReport(Long.parseLong(rep_id));
//        System.out.println(report+"fddskjldslsjlslhgfdsasdfghjklkjhgfdsasdfghjklkjhgfdsasdfghjkl");
        if(report == null) return new Report();
        return report;
    }

    @PostMapping({"/{rep_id}/report/new"})
    public Report addNewReport(@PathVariable String rep_id,@RequestBody NewReport newReport) throws ParseException {
        return representativeService.saveReport(Long.parseLong(rep_id),newReport);
    }


    @PostMapping({"/{rep_id}/attendance/new"})
    public Attendence addAttendance(@PathVariable String rep_id,@RequestBody Attendence attendence) throws ParseException {
        return representativeService.addAttendance(Long.parseLong(rep_id),attendence);
    }

    @GetMapping({"/{rep_id}/attendance"})
    public Attendence checkAttendence(@PathVariable String rep_id) throws ParseException {
        return representativeService.getAttendance(Long.parseLong(rep_id));
    }

    @GetMapping({"/{rep_id}/attendence/all"})
    public List<Attendence> getAttendence(@PathVariable String rep_id){
        return representativeService.getAllAttendence(Long.parseLong(rep_id));
    }




}
