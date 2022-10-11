package com.valuemanage.api.v1.mapper;

import com.valuemanage.api.v1.model.RetailerInfoDTO;
import com.valuemanage.domain.Retailer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RetailerInfoMapper {
    RetailerInfoMapper INSTANCE = Mappers.getMapper(RetailerInfoMapper.class);
    RetailerInfoDTO RetailerToRetailerInfo(Retailer retailer);

}
