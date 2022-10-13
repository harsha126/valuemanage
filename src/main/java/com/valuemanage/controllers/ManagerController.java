package com.valuemanage.controllers;

import com.valuemanage.api.v1.model.DistributorDTO;
import com.valuemanage.api.v1.model.RepresentativeDTO;
import com.valuemanage.domain.NewDistributor;
import com.valuemanage.services.ManagerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
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
}
