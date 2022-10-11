package com.valuemanage.services;

import com.valuemanage.api.v1.model.RetailerDTO;
import com.valuemanage.api.v1.model.RetailerInfoDTO;
import com.valuemanage.domain.Retailer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetailerService {
    public Page<RetailerDTO> getAllRetailers(Pageable pageable);
    public Page<RetailerInfoDTO> getRetailerById(Long Id,Pageable pageable);
}
