package com.valuemanage.controllers;

import com.valuemanage.api.v1.model.RetailerDTO;
import com.valuemanage.api.v1.model.RetailerInfoDTO;
import com.valuemanage.services.RetailerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/retailers")
public class RetailerController {
    private final RetailerService retailerService;

    public RetailerController(RetailerService retailerService) {
        this.retailerService = retailerService;
    }

    @GetMapping
    public Page<RetailerDTO> getAllRetailers(@RequestParam(name = "size",defaultValue = "5") int size,
                                             @RequestParam(name = "page",defaultValue = "0") int page){
        return retailerService.getAllRetailers(PageRequest.of(page, size));
    }

    @GetMapping({"/{Id}"})
    public Page<RetailerInfoDTO> getRetailerInfo(@RequestParam(name = "size",defaultValue = "5") int size,
                                                 @RequestParam(name = "page",defaultValue = "0") int page,
                                                 @PathVariable String Id){
        System.out.println(Id);
        return retailerService.getRetailerById(Long.parseLong(Id),PageRequest.of(page, size));
    }

}
