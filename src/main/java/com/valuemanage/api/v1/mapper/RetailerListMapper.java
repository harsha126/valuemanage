package com.valuemanage.api.v1.mapper;

import com.valuemanage.api.v1.model.RetailerDTO;
import com.valuemanage.domain.Retailer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface RetailerListMapper {
    RetailerListMapper INSTANCE = Mappers.getMapper(RetailerListMapper.class);
    public RetailerDTO RetailerToRetailerDTO(Retailer retailer);
}
