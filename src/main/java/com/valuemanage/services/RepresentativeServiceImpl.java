package com.valuemanage.services;

import com.valuemanage.api.v1.model.RetailerDTO;
import com.valuemanage.api.v1.model.RetailerInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class RepresentativeServiceImpl implements RepresentativeService {
    @Override
    public Page<RetailerDTO> getAllRetailers(Pageable pageable, Long rep_id) {
        return null;
    }

    @Override
    public Page<RetailerInfoDTO> getRetailerById(Long ret_id, Long rep_id, Pageable pageable) {
        return null;
    }
}
