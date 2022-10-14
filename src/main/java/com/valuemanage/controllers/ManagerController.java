package com.valuemanage.controllers;

import com.valuemanage.api.v1.model.DistributorDTO;
import com.valuemanage.api.v1.model.RepresentativeDTO;
import com.valuemanage.api.v1.model.RepresentativeInfoDTO;
import com.valuemanage.domain.*;
import com.valuemanage.services.ManagerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping({"/api/v1/manager"})
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/{man_id}/distributors")
    public Page<DistributorDTO> getAllDistributor(@PathVariable String man_id,
                                                  @RequestParam(name = "size",defaultValue = "5") int size,
                                                  @RequestParam(name = "page",defaultValue = "0") int page){
        return managerService.getAllDistributors(Long.parseLong(man_id), PageRequest.of(page, size));
    }

    @PostMapping("/{man_id}/distributors/new")
    public DistributorDTO saveNewDistributor(@PathVariable String man_id, @RequestBody NewDistributor newDistributor){
        return managerService.saveNewDistributor(Long.parseLong(man_id),newDistributor);
    }

    @GetMapping("/{man_id}/representatives")
    public Page<RepresentativeDTO> getAllRepresentatives(@PathVariable String man_id,
                                                         @RequestParam(name = "size",defaultValue = "5") int size,
                                                         @RequestParam(name = "page",defaultValue = "0") int page){
        return managerService.getAllRepresentatives(Long.parseLong(man_id),PageRequest.of(page, size));
    }

    @GetMapping("/{man_id}/representatives/{rep_id}")
    public RepresentativeInfoDTO getAllReps(@PathVariable String man_id,
                                            @PathVariable String rep_id){
        return managerService.getRepresentativeById(Long.parseLong(man_id),Long.parseLong(rep_id));
    }



    @PostMapping({"/{man_id}/attendance/new"})
    public Attendence addAttendance(@PathVariable String rep_id, @RequestBody Attendence attendence) throws ParseException {
        return managerService.addAttendance(Long.parseLong(rep_id),attendence);
    }

    @GetMapping({"/{rep_id}/attendance"})
    public Attendence checkAttendence(@PathVariable String rep_id) throws ParseException {
        return managerService.getAttendance(Long.parseLong(rep_id));
    }

    @GetMapping({"/{rep_id}/attendence/all"})
    public List<Attendence> getAttendence(@PathVariable String rep_id){
        return managerService.getAllAttendence(Long.parseLong(rep_id));
    }


    @GetMapping({"/{rep_id}/report/"})
    public Report checkReport(@PathVariable String rep_id) throws ParseException {
        Report report = managerService.checkReport(Long.parseLong(rep_id));
        if(report == null) return new Report();
        return report;
    }

    @PostMapping({"/{rep_id}/report/new"})
    public Report addNewReport(@PathVariable String rep_id,@RequestBody NewReport newReport) throws ParseException {
        return managerService.saveReport(Long.parseLong(rep_id),newReport);
    }


}
