package com.valuemanage.services;

import com.valuemanage.api.v1.model.RetailerDTO;
import com.valuemanage.api.v1.model.RetailerInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetailerService {
    Page<RetailerDTO> getAllRetailers(Pageable pageable);

    Page<RetailerInfoDTO> getRetailerById(Long Id, Pageable pageable);
}
