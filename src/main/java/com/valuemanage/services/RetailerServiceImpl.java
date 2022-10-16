package com.valuemanage.services;

import com.valuemanage.api.v1.mapper.RetailerInfoMapper;
import com.valuemanage.api.v1.mapper.RetailerListMapper;
import com.valuemanage.api.v1.model.RetailerDTO;
import com.valuemanage.api.v1.model.RetailerInfoDTO;
import com.valuemanage.repositories.RetailerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RetailerServiceImpl implements RetailerService {
    private final RetailerRepository retailerRepository;
    private final RetailerInfoMapper retailerInfoMapper;
    private final RetailerListMapper retailerListMapper;

    public RetailerServiceImpl(RetailerRepository retailerRepository, RetailerInfoMapper retailerInfoMapper, RetailerListMapper retailerListMapper) {
        this.retailerRepository = retailerRepository;
        this.retailerInfoMapper = retailerInfoMapper;
        this.retailerListMapper = retailerListMapper;
    }

    @Override
    public Page<RetailerDTO> getAllRetailers(Pageable pageable) {
        return retailerRepository.findAll(pageable).map(retailer -> {
            RetailerDTO retailerDTO = retailerListMapper.RetailerToRetailerDTO(retailer);
            retailerDTO.setRetailerUrl("/api/v1/retailers/" + retailer.getId());
            return retailerDTO;
        });
    }

    @Override
    public Page<RetailerInfoDTO> getRetailerById(Long Id, Pageable pageable) {
        return retailerRepository.findById(Id, pageable).map(retailerInfoMapper::RetailerToRetailerInfo);
    }
}
